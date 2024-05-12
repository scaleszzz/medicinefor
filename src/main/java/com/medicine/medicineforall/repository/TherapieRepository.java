package com.medicine.medicineforall.repository;

import com.medicine.medicineforall.models.Therapie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TherapieRepository extends JpaRepository<Therapie, Long> {

    Therapie findByDiagnosisId(Long id);
    void deleteAllByDiagnosisId(Long id);

}
