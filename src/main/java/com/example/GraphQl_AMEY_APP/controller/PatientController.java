package com.example.GraphQl_AMEY_APP.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.GraphQl_AMEY_APP.model.Patient;
import com.example.GraphQl_AMEY_APP.service.PatientService;

import lombok.RequiredArgsConstructor;

@Controller 
public class PatientController {
	
	@Autowired
    private  PatientService patientService; 

	@QueryMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @QueryMapping
    public Optional<Patient> getPatientById(@Argument Integer id) {
        return patientService.getPatientById(id);
    }

    @MutationMapping
    public Patient addPatient(
            @Argument String firstName,
            @Argument String lastName,
            @Argument String dateOfBirth,
            @Argument String gender,
            @Argument String contactNumber,
            @Argument String email,
            @Argument String address,
            @Argument String bloodGroup,
            @Argument String emergencyContactName,
            @Argument String emergencyContactNumber
    ) {
        // ✅ Create a Patient object manually
        Patient patient = new Patient();
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setDateOfBirth(LocalDate.parse(dateOfBirth));
        patient.setGender(gender);
        patient.setContactNumber(contactNumber);
        patient.setEmail(email);
        patient.setAddress(address);
        patient.setBloodGroup(bloodGroup);
        patient.setEmergencyContactName(emergencyContactName);
        patient.setEmergencyContactNumber(emergencyContactNumber);

        return patientService.addPatient(patient);
    }
    @MutationMapping
    public Optional<Patient> updatePatient(
            @Argument Integer id,
            @Argument String firstName,
            @Argument String lastName,
            @Argument String dateOfBirth,
            @Argument String gender,
            @Argument String contactNumber,
            @Argument String email,
            @Argument String address,
            @Argument String bloodGroup,
            @Argument String emergencyContactName,
            @Argument String emergencyContactNumber
    ) {
        Patient updatedPatient = new Patient();
        updatedPatient.setFirstName(firstName);
        updatedPatient.setLastName(lastName);
        updatedPatient.setDateOfBirth(LocalDate.parse(dateOfBirth));
        updatedPatient.setGender(gender);
        updatedPatient.setContactNumber(contactNumber);
        updatedPatient.setEmail(email);
        updatedPatient.setAddress(address);
        updatedPatient.setBloodGroup(bloodGroup);
        updatedPatient.setEmergencyContactName(emergencyContactName);
        updatedPatient.setEmergencyContactNumber(emergencyContactNumber);

        return patientService.updatePatient(id, updatedPatient);
    }

    @MutationMapping
    public boolean deletePatient(@Argument Integer id) {
        return patientService.deletePatient(id);
    }
    

}
