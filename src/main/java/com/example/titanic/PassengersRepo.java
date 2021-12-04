package com.example.titanic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengersRepo extends JpaRepository<Passenger, Long> {
}
