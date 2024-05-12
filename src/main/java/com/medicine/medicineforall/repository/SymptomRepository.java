package com.medicine.medicineforall.repository;

import com.medicine.medicineforall.models.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomRepository extends JpaRepository<Symptom, Long> {
    Symptom findByPatientId(Long id);

    void deleteAllByPatientId(Long id);

}
