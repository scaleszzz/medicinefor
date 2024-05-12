package com.medicine.medicineforall.controller;

import com.medicine.medicineforall.models.Treatment;
import com.medicine.medicineforall.repository.TreatmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/treatments")
@RequiredArgsConstructor
public class TreatmentController {

    private final TreatmentRepository treatmentRepository;

//    @Autowired
//    public TreatmentController(TreatmentRepository treatmentRepository) {
//        this.treatmentRepository = treatmentRepository;
//    }

    @GetMapping("/{id}")
    public String viewTreatment(@PathVariable("id") Long id, Model model) {
        Treatment treatment = treatmentRepository.findByDiagnosisIdId(id);

        if (treatment == null) {
            return "error";
        }

        model.addAttribute("treatment", treatment);
        return "treatment";
    }
}

