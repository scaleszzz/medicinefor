package com.medicine.medicineforall.controller;


import ch.qos.logback.core.model.Model;
import com.medicine.medicineforall.models.UserCredential;
import com.medicine.medicineforall.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

    @GetMapping("/")
    public String getLogin(){
        return "login";
    }

    @GetMapping("/login")
    public String log(){
        return "login";
    }

    @PostMapping("/login")
    @Transactional
    public String addLogin(@RequestParam("email") String email, @RequestParam("password") String password){
        UserCredential userCredential = userRepository.findByEmail(email).orElse(null);
        if (userCredential == null || !userCredential.getPassword().equals(password)){
            return "redirect:/";
        }
        return "redirect:/patients/";
    }


    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/register")
    @Transactional
    public String addUser(@ModelAttribute UserCredential user){
        userRepository.save(user);
        return "redirect:/patients/";
    }
}
