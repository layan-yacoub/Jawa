package com.example.jawaclinicnew.Service;
import com.example.jawaclinicnew.repository.BillJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BillService {
    private final BillJpaRepo billJpaRepo ;

}
