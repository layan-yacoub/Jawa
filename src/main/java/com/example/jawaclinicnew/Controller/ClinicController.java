package com.example.jawaclinicnew.Controller;

import com.example.jawaclinicnew.Service.ClinicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/clinic")
public class ClinicController {
    private final ClinicService clinicService ;
}
