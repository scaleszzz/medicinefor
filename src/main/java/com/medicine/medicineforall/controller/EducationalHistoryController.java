package com.medicine.medicineforall.controller;

import com.medicine.medicineforall.models.EducationalHistory;
import com.medicine.medicineforall.repository.EducationalHistoryRepository;
import com.medicine.medicineforall.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patients/view")
@RequiredArgsConstructor
public class EducationalHistoryController {
    private final EducationalHistoryRepository educationalHistoryRepository;

    private final PatientRepository patientRepository;


    @GetMapping("/{patientId}/education")
    public String viewEducation(@PathVariable("patientId") Long id, Model model) {
        EducationalHistory educationalHistory = educationalHistoryRepository.findByPatientId(id);

        if (educationalHistory == null) {
            return "error";
        }

        model.addAttribute("educational_history", educationalHistory);
        model.addAttribute("patient", patientRepository.findById(id).orElse(null));
        return "view_patient";
    }
}
//    @GetMapping
//    public ResponseEntity<List<EducationalHistory>> getAllEducationalHistories() {
//        List<EducationalHistory> educationalHistories = educationalHistoryRepository.findAll();
//        return new ResponseEntity<>(educationalHistories, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<EducationalHistory> getEducationalHistoryById(@PathVariable("id") Long id) {
//        EducationalHistory educationalHistory = educationalHistoryRepository.findById(id).orElse(null);
//        if (educationalHistory == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(educationalHistory, HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<EducationalHistory> createEducationalHistory(@RequestBody EducationalHistory educationalHistory) {
//        EducationalHistory createdEducationalHistory = educationalHistoryRepository.save(educationalHistory);
//        return new ResponseEntity<>(createdEducationalHistory, HttpStatus.CREATED);


