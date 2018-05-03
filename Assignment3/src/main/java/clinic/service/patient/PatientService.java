package clinic.service.patient;

import clinic.model.Patient;
import clinic.model.validation.Notification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface PatientService {

    List<Patient> findAll();
    Patient findById(long id);
    Notification<Boolean> addPatient(Patient patient);
    Notification<Boolean> updatePatient(long id, String name, long icn, long pnc, LocalDate bday, String address);

}
