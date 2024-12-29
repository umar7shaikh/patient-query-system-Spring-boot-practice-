package com.example.patient_query_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.patient_query_system.model.PatientQuery;

// Optional: Add @Repository annotation
public interface PatientQueryRepository extends JpaRepository<PatientQuery, Long> {
}

