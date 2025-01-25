package com.fatihberkant.jobportal.controller;

import com.fatihberkant.jobportal.entity.Users;
import com.fatihberkant.jobportal.entity.UsersType;
import com.fatihberkant.jobportal.repository.UsersRepository;
import com.fatihberkant.jobportal.services.UsersService;
import com.fatihberkant.jobportal.services.UsersTypeService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UsersController {

    private final UsersTypeService usersTypeService;
    private final UsersService usersService;
    private final UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersTypeService usersTypeService, UsersService usersService, UsersRepository usersRepository) {
        this.usersTypeService = usersTypeService;
        this.usersService = usersService;
        this.usersRepository = usersRepository;
    }

    @GetMapping("/register")
    public String register(Model model) {
        List<UsersType> usersTypes = usersTypeService.getAll();
        model.addAttribute("getAllTypes", usersTypes);
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping("/register/new")
    public String userRegistration(@Valid Users users, Model model) {
        Optional<Users> optionalUsers = usersService.getUserByEmail(users.getEmail());
        if (optionalUsers.isPresent()) {
            model.addAttribute("error", "This email already exists. Try to login or register with other email.");
            List<UsersType> usersTypes = usersTypeService.getAll();
            model.addAttribute("getAllTypes", usersTypes);
            model.addAttribute("user", new Users());
            return "register";
        }
        usersService.addNew(users);

        return "dashboard";
    }

}
