package com.example.jawaclinicnew.service;
import com.example.jawaclinicnew.config.JwtService;
import com.example.jawaclinicnew.domain.User;

import com.example.jawaclinicnew.repository.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserJpaRepo userJpaRepo;
    private final JwtService jwtService;

    public Long getUserIdByToken(String token) {
        String email = jwtService.extractUsername(token); // Extract email from the token
        if (email != null) {
            // Implement logic to retrieve the user's ID based on their email
            User user = userJpaRepo.findByEmail(email).orElse(null);
            if (user != null) {
                return user.getUserID();
            }
        }
        return null; // Handle the case where the email is not found or the user is not found
    }

    public String getUserName(Long userId) {
        User user = userJpaRepo.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        else return user.getUsername();
    }


}