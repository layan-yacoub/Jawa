package com.example.jawaclinicnew.Controller;

import com.example.jawaclinicnew.Service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/bill")
public class BillController {
    private final BillService billService ;
}
