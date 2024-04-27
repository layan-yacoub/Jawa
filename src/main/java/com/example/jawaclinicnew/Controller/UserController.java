package com.example.jawaclinicnew.Controller;

import com.example.jawaclinicnew.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/user")
public class UserController {
    private final UserService userService;
    @GetMapping("/id")
    public ResponseEntity<Long> getUserIdByToken(@RequestHeader("Authorization") String token) {
        Long userId = userService.getUserIdByToken(token);
        if (userId != null) {
            return ResponseEntity.ok(userId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{user_id}/username")
    public ResponseEntity<String> getUserName(@PathVariable("user_id") Long userID) {
        try {
            String userName = userService.getUserName(userID);
            return ResponseEntity.ok(userName);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }
}