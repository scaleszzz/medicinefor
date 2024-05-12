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
@Table(name = "therapies")
public class Therapie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long therapyId;

    @ManyToOne
    @JoinColumn(name = "diagnosis_id", nullable = false)
    private Diagnosis diagnosis;

    @Column(nullable = false)
    private String therapyType;

    @Column(nullable = false)
    private String therapyDescription;

//    @Temporal(TemporalType.DATE)
    @Column
    private LocalDate startDate;

    @Column
//    @Temporal(TemporalType.DATE)
    private LocalDate endDate;
}
