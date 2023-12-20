package com.POC.SpringSecurityDemo.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping("/home")
    public String home()
    {
        return ("Welcome to spring Security");
    }

   //@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/AdminLogin")
    public String AdminLogin()
    {
        return ("Admin Login Successfully");
    }
    //@PreAuthorize("hasRole('NORMAL')")
    @RequestMapping("/UserLogin")
    public String NormalLogin()
    {
        return ("user Login Successfully");
    }
}
