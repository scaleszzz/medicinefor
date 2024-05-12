package com.medicine.medicineforall.controller;

import com.medicine.medicineforall.models.Medication;
import com.medicine.medicineforall.repository.MedicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/medications")
@RequiredArgsConstructor
public class MedicationController {

//    private final TreatmentRepository treatmentRepository;

    private final MedicationRepository medicationRepository;

//    @Autowired
//    public MedicationController(MedicationRepository medicationRepository){
//        this.medicationRepository = medicationRepository;
//    }

    @GetMapping("/{id}")

    public String viewMedication(@PathVariable("id") Long id, Model model) {

//        Treatment treatment = treatmentRepository.findById(id).orElse(null);
//
//        if (treatment == null) {
//            return "error";
//        }

        Medication medication = medicationRepository.findByTreatmentTreatmentId(id);

        if (medication == null) {
            return "error";
        }

        model.addAttribute("medication", medication);
        return "medications";
    }


}
