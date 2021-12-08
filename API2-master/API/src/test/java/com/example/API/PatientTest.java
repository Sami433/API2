
package com.example.API;


import com.example.API.model.Patient;
import com.example.API.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class PatientTest {
    @Autowired
    private PatientRepository repository;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testCreatePatient() {
        Patient patient = new Patient();
        patient.setId(Integer.valueOf("6"));
        patient.setFirstName("Marvin");
        patient.setLastName("Kumar");
        patient.setGender("male");
        patient.setBirthdate("02/02/1998");
        patient.setAddress("rue x");

        Patient savedPatient = repository.save(patient);
        Patient existPatient = testEntityManager.find(Patient.class, savedPatient.getId());
        assertThat(existPatient.getAddress()).isEqualTo(patient.getAddress());
    }


}


