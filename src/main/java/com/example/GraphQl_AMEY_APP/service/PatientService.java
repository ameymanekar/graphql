package com.example.GraphQl_AMEY_APP.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.GraphQl_AMEY_APP.model.Patient;
import com.example.GraphQl_AMEY_APP.repository.PatientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    
    public PatientService(PatientRepository patientRepository) {
    	this.patientRepository = patientRepository;
    	
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Integer id) {
        return patientRepository.findById(id);
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
    
    public Optional<Patient> updatePatient(Integer id, Patient updatedPatient) {
        return patientRepository.findById(id).map(existingPatient -> {
            existingPatient.setFirstName(updatedPatient.getFirstName());
            existingPatient.setLastName(updatedPatient.getLastName());
            existingPatient.setAddress(updatedPatient.getAddress());
            existingPatient.setBloodGroup(updatedPatient.getBloodGroup());
            existingPatient.setContactNumber(updatedPatient.getContactNumber());
            existingPatient.setDateOfBirth(updatedPatient.getDateOfBirth());
            existingPatient.setEmail(updatedPatient.getEmail());
            existingPatient.setEmergencyContactName(updatedPatient.getEmergencyContactName());
            existingPatient.setEmergencyContactNumber(updatedPatient.getEmergencyContactNumber());
            existingPatient.setGender(updatedPatient.getGender());
            return patientRepository.save(existingPatient);
        });
    }

    public boolean deletePatient(Integer id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
