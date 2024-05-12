package com.medicine.medicineforall.repository;

import com.medicine.medicineforall.models.AutismDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutismDetailsRepository extends JpaRepository<AutismDetails, Long> {
    List<AutismDetails> findByPatientId(Long id);
    void deleteAllByPatientId(Long id);
}
