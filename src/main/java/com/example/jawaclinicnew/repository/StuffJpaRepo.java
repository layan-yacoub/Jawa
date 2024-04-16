package com.example.jawaclinicnew.repository;
import com.example.jawaclinicnew.domain.Stuff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StuffJpaRepo extends JpaRepository<Stuff, Long> {
}

