package com.example.GraphQl_AMEY_APP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GraphQl_AMEY_APP.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
