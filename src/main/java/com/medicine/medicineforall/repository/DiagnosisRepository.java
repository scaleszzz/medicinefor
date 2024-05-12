package com.medicine.medicineforall.repository;

import com.medicine.medicineforall.models.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
    Diagnosis findByPatientId(Long patientId);

    List<Diagnosis> findAllByPatientId(Long id);

    void deleteAllByPatientId(Long id);
}
