package com.medicine.medicineforall.repository;

import com.medicine.medicineforall.models.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
    Medication findByTreatmentTreatmentId(Long id);

    void deleteAllByTreatmentTreatmentId(Long id);
}

