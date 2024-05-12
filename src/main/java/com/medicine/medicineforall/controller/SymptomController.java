package com.medicine.medicineforall.controller;

import com.medicine.medicineforall.models.Symptom;
import com.medicine.medicineforall.repository.PatientRepository;
import com.medicine.medicineforall.repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SymptomController {

    private final SymptomRepository symptomRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public SymptomController(SymptomRepository symptomRepository, PatientRepository patientRepository) {
        this.symptomRepository = symptomRepository;
        this.patientRepository = patientRepository;
    }

    @GetMapping("/patients/{patientId}/symptoms")
    public String getPatientSymptoms(@PathVariable("patientId") Long patientId, Model model) {
        Symptom symptoms = symptomRepository.findByPatientId(patientId);

        if (symptoms == null) {
            return "error";
        }

        model.addAttribute("symptoms", symptoms);
        model.addAttribute("patient", patientRepository.findById(patientId).orElse(null));

        return "patient_symptoms";
    }
}
