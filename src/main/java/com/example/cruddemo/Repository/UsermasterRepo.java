package com.example.cruddemo.Repository;

import com.example.cruddemo.Entity.Usermaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsermasterRepo extends JpaRepository<Usermaster, Long> {
    boolean existsByEmail(String email);
}
