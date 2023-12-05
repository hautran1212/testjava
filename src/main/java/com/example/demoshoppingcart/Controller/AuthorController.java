package com.example.demoshoppingcart.Controller;

import com.example.demoshoppingcart.Domain.UserModel;
import com.example.demoshoppingcart.Exception.FieldMissMatchException;
import com.example.demoshoppingcart.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    @Autowired
    private UserService userService;

    @GetMapping("login")
    public String index(){
        return "Login";
    }

    @GetMapping("signup")
    public String signUpPage(Model model){
        model.addAttribute("user", new UserModel());
        return "Signup";
    }

    @PostMapping("signup")
    public String signUp(@ModelAttribute("user") UserModel user) throws Exception, FieldMissMatchException {
        userService.register(user);
        return "redirect:/login";
    }
}
