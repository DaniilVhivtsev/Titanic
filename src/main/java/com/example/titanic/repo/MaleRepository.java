package com.example.titanic.repo;

import com.example.titanic.model.Female;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaleRepository extends JpaRepository<Female, Long> {
}
