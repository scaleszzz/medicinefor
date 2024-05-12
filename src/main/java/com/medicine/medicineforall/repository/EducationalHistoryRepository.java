package com.medicine.medicineforall.repository;

import com.medicine.medicineforall.models.EducationalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationalHistoryRepository extends JpaRepository<EducationalHistory, Long> {
    EducationalHistory findByPatientId(Long id);

    void deleteAllByPatientId(Long id);
}
