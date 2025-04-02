package com.pm.patientservice.Service;

import com.pm.patientservice.DTO.PatientRequestDTO;
import com.pm.patientservice.DTO.PatientResponseDTO;
import com.pm.patientservice.Entity.Patient;
import com.pm.patientservice.Exception.EmailAlreadyExistException;
import com.pm.patientservice.Exception.PatentAlreadyExistException;
import com.pm.patientservice.Mapper.PatientMapper;
import com.pm.patientservice.Repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {


    private PatientRepository patientRepository;

    PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    public List<PatientResponseDTO> getPatient() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponseDTO> patientResponseDTOS =
                patients.stream().map(patient -> PatientMapper.getPatientResponseDTO(patient)).toList();
        return patientResponseDTOS;
    }


    public PatientResponseDTO savePatient(PatientRequestDTO patientRequestDTO) {
        Patient patient = PatientMapper.getPatient(patientRequestDTO);
        Optional<Patient> OptionalPatient = patientRepository.findByPatientName(patientRequestDTO.getPatientName());


        if (OptionalPatient.isPresent()) {
            throw new PatentAlreadyExistException("Patient " + patientRequestDTO.getPatientName() + " already exist");
        }

      Optional<Patient> optionalPatientforEmail =  patientRepository.findByEmail(patientRequestDTO.getEmail());
        if(optionalPatientforEmail.isPresent()){
            throw  new EmailAlreadyExistException("Email "+ patientRequestDTO.getEmail() + " already exist");
        }
        patient = patientRepository.save(patient);
        return PatientMapper.getPatientResponseDTO(patient);
    }


}
