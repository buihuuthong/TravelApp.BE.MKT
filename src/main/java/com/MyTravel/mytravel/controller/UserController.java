package com.MyTravel.mytravel.controller;

//import com.MyTravel.mytravel.model.MyUser;
import com.MyTravel.mytravel.model.User;
import com.MyTravel.mytravel.repository.UserRepository;
import com.MyTravel.mytravel.security.services.AuthService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    AuthService authService;

    @GetMapping("/getAccountInformation")
    @ApiResponses(@ApiResponse(code = 404, message = "USER_NOT_FOUND"))
    public User GetUser(Principal principal) {
        String getUsername = authService.getUsername(principal);
        return userRepository.findByUsername(getUsername).orElse(null);
    }

    @PutMapping("/updateAccountInformation")
    public User PutUser(@RequestBody User user, Principal principal)
    {
        User oldUser = userRepository.findByUsername(authService.getUsername(principal)).orElse(null);
        oldUser.setUsername(user.getUsername());
        oldUser.setEmail(user.getEmail());
        oldUser.setPhoneNumber(user.getPhoneNumber());
        oldUser.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(oldUser);
    }

}
