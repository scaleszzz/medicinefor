package com.medicine.medicineforall.controller;

import com.medicine.medicineforall.models.BehavioralSession;
import com.medicine.medicineforall.repository.BehavioralSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/behavioral-sessions")
public class BehavioralSessionController {

    private final BehavioralSessionRepository behavioralSessionRepository;

    @Autowired
    public BehavioralSessionController(BehavioralSessionRepository behavioralSessionRepository) {
        this.behavioralSessionRepository = behavioralSessionRepository;
    }

    @GetMapping("/{id}")
    public String viewBehavioralSession(@PathVariable("id") Long id, Model model) {
        BehavioralSession behavioralSession = behavioralSessionRepository.findByPatientId(id);

        if (behavioralSession == null) {
            return "error";
        }

        model.addAttribute("behavioralSession", behavioralSession);
        return "behavioral_session";
    }
}
