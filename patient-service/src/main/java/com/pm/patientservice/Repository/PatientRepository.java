package com.pm.patientservice.Repository;

import com.pm.patientservice.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {

    Optional<Patient> findByPatientName(String patientName);

    Optional<Patient> findByEmail(String email);
}
