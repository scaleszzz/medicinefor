package com.medicine.medicineforall.controller;

import com.medicine.medicineforall.models.AutismDetails;
import com.medicine.medicineforall.models.Patient;
import com.medicine.medicineforall.repository.AutismDetailsRepository;
import com.medicine.medicineforall.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AutismDetailsController {

    private final PatientRepository patientRepository;
    private final AutismDetailsRepository autismDetailsRepository;

    @Autowired
    public AutismDetailsController(PatientRepository patientRepository, AutismDetailsRepository autismDetailsRepository) {
        this.patientRepository = patientRepository;
        this.autismDetailsRepository = autismDetailsRepository;
    }

    @GetMapping("/patients/autism-details/{id}")
    public String getAutismDetails(@PathVariable Long id, Model model) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient id: " + id));

        List<AutismDetails> autismDetailsList = autismDetailsRepository.findByPatientId(id);

        AutismDetails autismDetails = autismDetailsList.isEmpty() ? null : autismDetailsList.get(0);

        if (autismDetails == null) {
            throw new IllegalArgumentException("Autism details not found for patient id: " + id);
        }

        model.addAttribute("patient", patient);
        model.addAttribute("autismDetails", autismDetails);
        return "autism_details";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("autismDetails", new AutismDetails());
        return "add_patient";
    }

    @PostMapping("/add")
    public String addPatient(@ModelAttribute AutismDetails autismDetails){
        autismDetailsRepository.save(autismDetails);
        return "redirect:/patients/";
    }
}
