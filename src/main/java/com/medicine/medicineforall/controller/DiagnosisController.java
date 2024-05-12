package com.medicine.medicineforall.controller;

import com.medicine.medicineforall.models.Diagnosis;
import com.medicine.medicineforall.repository.DiagnosisRepository;
import com.medicine.medicineforall.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/diagnoses")
public class DiagnosisController {

    private final DiagnosisRepository diagnosisRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public DiagnosisController(DiagnosisRepository diagnosisRepository, PatientRepository patientRepository) {
        this.diagnosisRepository = diagnosisRepository;
        this.patientRepository = patientRepository;
    }

    @GetMapping("/{patientId}")
    public String viewDiagnosis(@PathVariable("patientId") Long Id, Model model) {
        Diagnosis diagnosis = diagnosisRepository.findByPatientId(Id);

        if (diagnosis == null) {
            return "error";
        }

        model.addAttribute("diagnosis", diagnosis);
        model.addAttribute("patient", patientRepository.findById(Id).orElse(null));
        return "diagnosis";
    }
}
