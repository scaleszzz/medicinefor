package com.medicine.medicineforall.controller;

import com.medicine.medicineforall.models.*;
import com.medicine.medicineforall.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final AppointmentRepository appointmentRepository;
    private final AutismDetailsRepository autismDetailsRepository;
    private final BehavioralSessionRepository behavioralSessionRepository;
    private final DiagnosisRepository diagnosisRepository;
    private final EducationalHistoryRepository educationalHistoryRepository;
    private final TestRepository testRepository;
    private final SymptomRepository symptomRepository;
    private final SocialSkillsAssessmentRepository socialSkillsAssessmentRepository;
    private final TherapieRepository therapieRepository;
    private final TreatmentRepository treatmentRepository;
    private final MedicationRepository medicationRepository;
    private final PatientRepository patientRepository;


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("patients", patientRepository.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "add_patient";
    }

    @PostMapping("/add")
    public String addPatient(@ModelAttribute Patient patient, Appointment appointment, AutismDetails autismDetails, BehavioralSession behavioralSession, Diagnosis diagnosis, EducationalHistory educationalHistory, Test test, Symptom symptom, SocialSkillsAssessment socialSkillsAssessment, Therapie therapie, Treatment treatment, Medication medication) {
        Patient patient1 =  patientRepository.save(patient);
        appointment.setPatient(patient1);
        appointmentRepository.save(appointment);
        autismDetails.setPatient(patient1);
        autismDetailsRepository.save(autismDetails);
        behavioralSession.setSessionId("ass");
        behavioralSession.setPatient(patient1);
        behavioralSessionRepository.save(behavioralSession);
        diagnosis.setPatient(patient1);
        diagnosisRepository.save(diagnosis);
        educationalHistory.setPatient(patient1);
        educationalHistoryRepository.save(educationalHistory);
        test.setPatient(patient1);
        testRepository.save(test);
        symptom.setPatient(patient1);
        symptomRepository.save(symptom);
        socialSkillsAssessment.setPatient(patient1);
        socialSkillsAssessmentRepository.save(socialSkillsAssessment);
        therapie.setDiagnosis(diagnosis);
        therapieRepository.save(therapie);
        treatment.setDiagnosisId(diagnosis);
        treatmentRepository.save(treatment);
        medication.setTreatment(treatment);
        medicationRepository.save(medication);
        return "redirect:/patients/";
    }

//    @GetMapping("/view/{id}")
//    public String viewPatient(@PathVariable Long id, Model model) {
//        Patient patient = patientRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid patient id: " + id));
//        model.addAttribute("patient", patient);
//
////        Appointment appointments = appointmentRepository.findByPatientId(id);
////        model.addAttribute("appointments", appointments);
//
//        return "view_patient";
//    }

    @PostMapping("/delete/{id}")
    @Transactional
    public String deletePatient(@PathVariable Long id) {
        appointmentRepository.deleteAllByPatientId(id);
        autismDetailsRepository.deleteAllByPatientId(id);
        behavioralSessionRepository.deleteAllByPatientId(id);
        List<Diagnosis>diagnosesList=diagnosisRepository.findAllByPatientId(id);
        for(Diagnosis diagnosis: diagnosesList){
            therapieRepository.deleteAllByDiagnosisId(diagnosis.getId());
            treatmentRepository.deleteAllByDiagnosisIdId(diagnosis.getId());
            Treatment treatment =treatmentRepository.findByDiagnosisIdId(diagnosis.getId());
            medicationRepository.deleteAllByTreatmentTreatmentId(treatment.getTreatmentId());
        }
        diagnosisRepository.deleteAllByPatientId(id);
        educationalHistoryRepository.deleteAllByPatientId(id);
        testRepository.deleteAllByPatientId(id);
        symptomRepository.deleteAllByPatientId(id);
        socialSkillsAssessmentRepository.deleteAllByPatientId(id);


        patientRepository.deleteById(id);

        return "redirect:/patients/";
    }


}

