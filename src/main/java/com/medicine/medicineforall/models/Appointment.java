package com.medicine.medicineforall.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "appointment_date")
    private LocalDate appointmentDate;

    @Column(name="appointment_type")
    private String appointmentType;

    @Column(name="notes")
    private String notes;

    @ManyToOne
    @JoinColumn(name="patient_id",nullable = false)
    private Patient patient;


}
