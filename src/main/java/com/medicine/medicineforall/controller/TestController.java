package com.medicine.medicineforall.controller;

import com.medicine.medicineforall.models.Patient;
import com.medicine.medicineforall.models.Test;
import com.medicine.medicineforall.repository.PatientRepository;
import com.medicine.medicineforall.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class TestController {

    private final TestRepository testRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public TestController(TestRepository testRepository, PatientRepository patientRepository) {
        this.testRepository = testRepository;
        this.patientRepository = patientRepository;
    }

    @GetMapping("/{id}/tests")
    public String viewPatientTests(@PathVariable("id") Long id, Model model) {

        List<Test> tests = testRepository.findByPatientId(id);
        Patient patient = patientRepository.findById(id).orElse(null);

        if (tests == null || patient == null) {
            return "error";
        }

        model.addAttribute("tests", tests);
        model.addAttribute("patient", patient);

        return "patient_tests";
    }

//    @PostMapping("/add")
//    public String addTest(@ModelAttribute Test test) {
//        testRepository.save(test);
//        return "redirect:/patients/";
//    }
}
