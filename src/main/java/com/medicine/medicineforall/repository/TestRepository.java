package com.medicine.medicineforall.repository;

import com.medicine.medicineforall.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {
    List <Test> findByPatientId(Long patientId);
//    Test findByPatientId(Long id);

    void deleteAllByPatientId(Long id);
}
