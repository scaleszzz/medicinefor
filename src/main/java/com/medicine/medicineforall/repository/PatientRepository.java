package com.medicine.medicineforall.repository;

import com.medicine.medicineforall.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT p FROM Patient p WHERE lower(p.firstname) LIKE %:search% OR lower(p.lastname) LIKE %:search%")
    List<Patient> findByFirstNameOrLastNameContainingIgnoreCase(@Param("search") String search);
}
