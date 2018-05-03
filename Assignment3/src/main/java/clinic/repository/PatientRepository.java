package clinic.repository;

import clinic.model.Patient;
import clinic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findById(long id);
    List<Patient> findAll();

}
