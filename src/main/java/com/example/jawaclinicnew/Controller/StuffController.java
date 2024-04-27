package com.example.jawaclinicnew.Controller;

import com.example.jawaclinicnew.service.StuffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/stuff")
public class StuffController {
    private final StuffService stuffService ;

}
