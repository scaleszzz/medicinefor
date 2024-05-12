package com.medicine.medicineforall.repository;

import com.medicine.medicineforall.models.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {

    Treatment findByDiagnosisIdId(Long id);
    void deleteAllByDiagnosisIdId(Long id);

}