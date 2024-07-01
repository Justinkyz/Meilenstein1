package de.htw.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User authenticate(String username, String password) {
        System.out.println("Authenticating user: " + username);
        User user = userRepository.findByUsername(username);
        if (user != null) {
            System.out.println("User found: " + user.getUsername());
            if (user.getPassword().equals(password)) {
                System.out.println("Password match for user: " + username);
                return user;
            } else {
                System.out.println("Password mismatch for user: " + username);
            }
        } else {
            System.out.println("User not found: " + username);
        }
        return null;
    }
}
