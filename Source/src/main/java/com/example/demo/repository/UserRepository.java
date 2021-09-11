package com.example.demo.repository;

import com.example.demo.models.Individuu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Individuu, Integer> {

    public Individuu findByEmail(String email);
}
