package com.example.jawaclinicnew.Service;

import com.example.jawaclinicnew.repository.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserJpaRepo userJpaRepo;
}