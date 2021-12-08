package com.example.API.service;

import com.example.API.model.Patient;
import com.example.API.repository.PatientRepository;
import com.example.API.service.dto.PatientsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PatientService extends CalculatorAge{

    @Autowired
    private PatientRepository repo;


    public List<Patient> listAll() {
        return repo.findAll();
    }

    public Patient save(Patient patient) {
        return repo.save(patient);
    }

    public Patient get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public void deleteAll() {
        repo.deleteAll();
    }


    public List<Patient> findPatientByName(String firstName, String lastName) {
        return this.listAll().stream()
                .filter(patient -> patient.getFirstName().equals(firstName))
                .filter(patient -> patient.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }
   public List<Patient> findAllPatientsBylastName(String lastName) {
        return this.listAll().stream()
               .filter(patient -> patient.getLastName().equals(lastName))
               .collect(Collectors.toList());

}

    public List<PatientsDto> agePatient (String firstName, String lastName) {
        List<Patient> patients = findPatientByName (firstName, lastName);
        List<PatientsDto> result = new ArrayList<>();

        for (Patient patient : patients) {

            if (patient != null) {
                PatientsDto dto = new PatientsDto();
                dto.setId(patient.getId());
                dto.setBirthdate(patient.getBirthdate());
                dto.setLastName(patient.getLastName());
                dto.setFirstName(patient.getFirstName());
                dto.setAddress(patient.getAddress());
                dto.setGender(patient.getGender());
                dto.setAge(String.valueOf(calculatorAge(patient.getBirthdate())));
                result.add(dto);
            }
        }
        return result;
    }



}
