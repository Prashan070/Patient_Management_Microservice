package com.pm.patientservice.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;                                        //128-bit unique id

    @NotNull
    private String patientName;

    @NotNull
    @Email(message = "Invalid Email Format")                  //coming from validation dependencies
    @Column(unique = true)                                    //duplicate not allow
    private String email;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private LocalDate registeredDate;

    @NotNull
    private  String address;

    public @NotNull String getAddress() {
        return address;
    }

    public void setAddress(@NotNull String address) {
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotNull String getPatientName() {
        return patientName;
    }

    public void setPatientName(@NotNull String patientName) {
        this.patientName = patientName;
    }

    public @NotNull @Email(message = "Invalid Email Format") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Email(message = "Invalid Email Format") String email) {
        this.email = email;
    }

    public @NotNull LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotNull LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public @NotNull LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(@NotNull LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }


}
