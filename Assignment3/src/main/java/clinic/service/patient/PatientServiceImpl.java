package clinic.service.patient;

import clinic.model.Patient;
import clinic.model.builder.PatientBuilder;
import clinic.model.validation.Notification;
import clinic.model.validation.PatientValidator;
import clinic.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findById(long id) {
        return patientRepository.findById(id);
    }

    @Override
    public Notification<Boolean> addPatient(Patient patient) {
        Notification<Boolean> notification = new Notification<>();
        PatientValidator validator = new PatientValidator(patient);
        if (validator.validate()) {
            notification.setResult(true);
            patientRepository.save(patient);
        } else {
            validator.getErrors().forEach(notification::addError);
            notification.setResult(false);
        }
        return notification;
    }

    @Override
    public Notification<Boolean> updatePatient(long id, String name, long icn, long pnc, LocalDate bday, String address) {
        Notification<Boolean> notification = new Notification<>();
        if (patientRepository.findById(id) != null) {
            Patient patient = new PatientBuilder()
                    .setId(id)
                    .setName(name)
                    .setId_card_nr(icn)
                    .setPers_num_code(pnc)
                    .setBirthday(bday)
                    .setAddress(address)
                    .build();
            PatientValidator validator = new PatientValidator(patient);
            if (validator.validate()) {
                notification.setResult(true);
                patientRepository.save(patient);
            } else {
                validator.getErrors().forEach(notification::addError);
                notification.setResult(false);
            }
            return notification;
        }
        notification.addError("Patient does not exist!");
        return notification;
    }
}
