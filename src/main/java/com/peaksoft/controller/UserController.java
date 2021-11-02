package com.peaksoft.controller;

import com.peaksoft.dao.UserDao;
import com.peaksoft.model.User;
import com.peaksoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUser(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "users";
    }

    @GetMapping("/add-user")
    public String getUser(User user) {
        return "add-user";
    }

    @PostMapping("/save-user")
    public String addUser(User user, Model model) {
        userService.addUser(user);
        model.addAttribute("users", userService.getAllUser());
        return "redirect:/users";
    }

//    @GetMapping("/edit/{id}")
//    public String edit(@RequestParam("id") int id, Model model) {
//        model.addAttribute("user", userService.getById(id));
//        return "editUser";
//    }

    //
//    }
    @GetMapping("/delete")
    public String deleteFromDB(@RequestParam("id") int id) {
        //id menen ochur
        userService.removeUser(id);

        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String updateUser(@RequestParam("id") int id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("updateUser", user);
        return "edit-form";
    }
}
