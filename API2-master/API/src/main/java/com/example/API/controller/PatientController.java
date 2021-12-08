package com.example.API.controller;

import com.example.API.model.Patient;
import com.example.API.service.PatientService;
import com.example.API.service.dto.PatientsDto;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService service;

    @GetMapping("/patients")
    public List<Patient> list() {
        return service.listAll();
    }

    @GetMapping("/patients/{id}")
    public Patient get(@PathVariable Integer id) {
        return service.get(id);
    }


    @PostMapping("/patients")
    public Patient add(@RequestBody Patient patient) {
        return service.save(patient);
    }


    @PutMapping("/patients/{id}")
    public Patient update(@RequestBody Patient patient, @PathVariable Integer id) {
        return service.save(patient);
    }


    @DeleteMapping("/patients/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.delete(id);
    }


    @DeleteMapping("/patients")
    public void deleteAll() {
        service.deleteAll();

    }


    @RequestMapping(value = "patient", method = RequestMethod.GET)
    public List<Patient> patientName(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {

        return this.service.findPatientByName(firstName, lastName);

    }

    @RequestMapping(value = "patientlastName", method = RequestMethod.GET)
    public List<Patient> listPatientsByName(@RequestParam(name = "lastName") String lastName) {

        return this.service.findAllPatientsBylastName(lastName);

    }

    @RequestMapping(value = "agePatient", method = RequestMethod.GET)
    public List<PatientsDto> agePatient(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {

        return this.service.agePatient(firstName, lastName);

    }
}