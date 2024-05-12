package com.medicine.medicineforall.controller;

import com.medicine.medicineforall.models.Therapie;
import com.medicine.medicineforall.repository.TherapieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/therapies")
@RequiredArgsConstructor
public class TherapieController {

    private final TherapieRepository therapieRepository;

//    @Autowired
//    public  TherapieController(TherapieRepository therapieRepository) {
//        this.therapieRepository = therapieRepository;
//    }

    @GetMapping("/{id}")
    public String viewTherapie(@PathVariable("id") Long id, Model model){
        Therapie therapie = therapieRepository.findByDiagnosisId(id);

        if (therapie == null) {
            return "error";
        }

        model.addAttribute("therapie", therapie);
        return "therapie";
    }
}
