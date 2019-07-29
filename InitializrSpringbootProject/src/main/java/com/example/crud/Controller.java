
package com.example.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    UserRepository userRepository;
    
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("user",new User());
        return "index";
    }
    
    @PostMapping("/save")
    public String save(User user){
        userRepository.save(user);
        return "index";
    }
    
    @PostMapping("/save")
    public String save(Model model){
        model.addAttribute("userList", userRepository.findAll());
        return "list";
    }
}
