package com.example.jawaclinicnew.Service;
import com.example.jawaclinicnew.repository.ClinicJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClinicService {
    private final ClinicJpaRepo clinicJpaRepo;
}
