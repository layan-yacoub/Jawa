package com.example.jawaclinicnew.repository;
import com.example.jawaclinicnew.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillJpaRepo extends JpaRepository<Bill, Long> {
}
