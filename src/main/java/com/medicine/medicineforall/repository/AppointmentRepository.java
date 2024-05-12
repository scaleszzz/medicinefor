package com.medicine.medicineforall.repository;

import com.medicine.medicineforall.models.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    Appointment findByPatientId(Long patientId);

    void deleteAllByPatientId(Long id);
}
