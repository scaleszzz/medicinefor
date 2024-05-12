package com.medicine.medicineforall.repository;

import com.medicine.medicineforall.models.BehavioralSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BehavioralSessionRepository extends JpaRepository<BehavioralSession, Long> {
    BehavioralSession findByPatientId(Long patientId);

    void deleteAllByPatientId(Long id);
}