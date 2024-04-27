package com.example.jawaclinicnew.Controller;

import com.example.jawaclinicnew.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService ;
}
