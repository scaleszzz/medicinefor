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
@Table(name = "autismDetails")

public class AutismDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;
    private LocalDate diagnosisDate;
    private AutismType autismType;
    private SeverityLevel severityLevel;

}

enum AutismType{
    ASPERGERS,
    AUTISTIC_DISORDER,
    PDD_NOS,
    OTHER
}

enum SeverityLevel {
    MILD,
    MODERATE,
    SEVERE
}
