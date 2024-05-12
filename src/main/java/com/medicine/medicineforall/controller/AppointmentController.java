package com.medicine.medicineforall.controller;

import com.medicine.medicineforall.models.Appointment;
import com.medicine.medicineforall.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/appointment")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentController(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        Iterable<Appointment> appointmentIterable = appointmentRepository.findAll();
        List<Appointment> appointments = new ArrayList<>();
        appointmentIterable.forEach(appointments::add);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  String getAppointmentById(@PathVariable("id") Long id, Model model)  {
        Appointment appointment = appointmentRepository.findByPatientId(id);
        if (appointment == null){
            return null;
        }
        model.addAttribute("appointment", appointment);
        return "appointment-details";
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment){
        Appointment createdAppointment = appointmentRepository.save(appointment);
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable("id") Long id, @RequestBody Appointment appointment){
        Appointment existingAppointment = appointmentRepository.findById(id).orElse(null);
        if(existingAppointment == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingAppointment.setAppointmentDate(appointment.getAppointmentDate());
        existingAppointment.setAppointmentType(appointment.getAppointmentType());
        existingAppointment.setNotes(appointment.getNotes());
        existingAppointment.setPatient(appointment.getPatient());

        Appointment updatedAppointment = appointmentRepository.save(existingAppointment);
        return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAppointment(@PathVariable("id")Long id){
        appointmentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "add_patient";
    }

    @PostMapping("/add")
    public String addPatient(@ModelAttribute Appointment appointment) {
        appointmentRepository.save(appointment);
        return "redirect:/patients/";
    }
}
