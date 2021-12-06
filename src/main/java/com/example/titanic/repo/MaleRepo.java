package com.example.titanic.repo;

import com.example.titanic.model.Female;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
@Component
public interface MaleRepo extends JpaRepository<Female, Long> {
}
