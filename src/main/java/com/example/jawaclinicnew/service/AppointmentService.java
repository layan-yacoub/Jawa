package com.example.jawaclinicnew.service;
import com.example.jawaclinicnew.repository.AppointmentJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentJpaRepo appointmentJpaRepo;

}
