package com.tantai.dacnpm.controller;

import com.tantai.dacnpm.config.JwtUtil;
import com.tantai.dacnpm.entity.User;
import com.tantai.dacnpm.service.User.JwtUserDetailsServiceImpl;
import com.tantai.dacnpm.service.User.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class APIController {
    private final UserServiceImpl userService;

    @Autowired
    private JwtUserDetailsServiceImpl jwtUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    public APIController(UserServiceImpl userService) {
        this.userService = userService;

    }

    @PostMapping("/create-token")
    public ResponseEntity<?> createToken (@RequestBody Map<String, String> user) throws Exception {
        Map<String, Object> tokenResponse = new HashMap<>();
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(user.get("username"));
        final String token = jwtUtil.generateToken(userDetails);

        tokenResponse.put("token", token);
        return ResponseEntity.ok(tokenResponse);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers () {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser (@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
