package com.example.jawaclinicnew.repository;

import com.example.jawaclinicnew.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentJpaRepo extends JpaRepository<Appointment, Long> {
}
