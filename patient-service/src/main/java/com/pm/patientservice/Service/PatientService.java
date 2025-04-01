package com.pm.patientservice.Service;

import com.pm.patientservice.DTO.PatientRequestDTO;
import com.pm.patientservice.DTO.PatientResponseDTO;
import com.pm.patientservice.Entity.Patient;
import com.pm.patientservice.Mapper.PatientMapper;
import com.pm.patientservice.Repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public PatientResponseDTO savePatient(PatientRequestDTO patientResponseDTO){
     Patient patient=   PatientMapper.getPatient(patientResponseDTO);
      patient = patientRepository.save(patient);
      return PatientMapper.getPatientResponseDTO(patient);
    }

}
