package com.pm.patientservice.Controller;


import com.pm.patientservice.DTO.PatientRequestDTO;
import com.pm.patientservice.DTO.PatientResponseDTO;
import com.pm.patientservice.Service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(
        name ="Patient Service",
        description = "GET READ UPDATE AND DELETE OPERATION FOR Patient service"
)


@RestController
@RequestMapping("/patients")
public class PatientContoller {


    private PatientService patientService;

    PatientContoller(PatientService patientService){
        this.patientService=patientService;
    }

    @Operation(
            summary = "To get the patient from database",
            description = "fetch all product"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Created"
    )

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getPatient(){
        return ResponseEntity.status(HttpStatus.FOUND).body(patientService.getPatient());
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> savePatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.savePatient(patientRequestDTO));
    }





}
