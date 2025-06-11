package com.example.cruddemo.Repository;

import com.example.cruddemo.Entity.Userdetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserdetailRepo extends JpaRepository<Userdetail, Long> {
}
