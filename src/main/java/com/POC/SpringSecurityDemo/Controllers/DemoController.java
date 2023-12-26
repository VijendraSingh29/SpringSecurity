package com.POC.SpringSecurityDemo.Controllers;

import com.POC.SpringSecurityDemo.Models.User;
import com.POC.SpringSecurityDemo.Repositories.UserRepository;
import com.POC.SpringSecurityDemo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    UserService userService ;
    @GetMapping("/home")
    public String home()
    {
        return ("Welcome to spring Security");
    }

   //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/AdminLogin")
    public String AdminLogin()
    {
        return ("Admin Login Successfully");
    }

    //@PreAuthorize("hasRole('NORMAL')")
    @GetMapping("/UserLogin")
    public String NormalLogin()
    {
        return ("user Login Successfully");
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user)
    {
       userService.addUser(user);
         return "User is Added" ;
    }
}
