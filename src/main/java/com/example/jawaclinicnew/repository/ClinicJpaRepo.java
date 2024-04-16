package com.example.jawaclinicnew.repository;
import com.example.jawaclinicnew.domain.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClinicJpaRepo extends JpaRepository<Clinic, Long> {
}