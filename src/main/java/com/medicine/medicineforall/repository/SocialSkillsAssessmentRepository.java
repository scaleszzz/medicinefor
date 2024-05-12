package com.medicine.medicineforall.repository;

import com.medicine.medicineforall.models.SocialSkillsAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialSkillsAssessmentRepository extends JpaRepository<SocialSkillsAssessment, Long> {
    SocialSkillsAssessment findByPatientId(Long id);

    void deleteAllByPatientId(Long id);
}
