package com.medicine.medicineforall.controller;

import com.medicine.medicineforall.models.SocialSkillsAssessment;
import com.medicine.medicineforall.repository.PatientRepository;
import com.medicine.medicineforall.repository.SocialSkillsAssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/api/social-skills-assessments")
public class SocialSkillsAssessmentController {

    @Autowired
    private SocialSkillsAssessmentRepository socialSkillsAssessmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients/{id}/socialSkillsAssessment")
    public String viewSocialSkillsAssessment(@PathVariable("id")Long id, Model model) {
        SocialSkillsAssessment socialSkillsAssessment = socialSkillsAssessmentRepository.findByPatientId(id);

        if (socialSkillsAssessment == null) {
            return "error";
        }


        model.addAttribute("socialSkillsAssessment", socialSkillsAssessment);
        model.addAttribute("patient", patientRepository.findById(id).orElse(null));

        return "socialSkillsAssessment";
    }

}