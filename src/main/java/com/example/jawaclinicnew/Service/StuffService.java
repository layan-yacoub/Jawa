package com.example.jawaclinicnew.Service;
import com.example.jawaclinicnew.repository.StuffJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StuffService {
    private final StuffJpaRepo stuffJpaRepo;

}
