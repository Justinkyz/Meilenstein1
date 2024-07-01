package de.htw.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/login")
    public String login(@RequestBody User loginRequest) {
        System.out.println("Login request received for user: " + loginRequest.getUsername());
        User user = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null) {
            System.out.println("Login successful for user: " + loginRequest.getUsername());
            return "Login successful";
        } else {
            System.out.println("Invalid username or password for user: " + loginRequest.getUsername());
            return "Invalid username or password";
        }
    }
}
