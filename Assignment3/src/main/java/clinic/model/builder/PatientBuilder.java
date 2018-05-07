package clinic.model.builder;

import clinic.model.Patient;

import java.time.LocalDate;
import java.util.Date;

public class PatientBuilder {

    private Patient patient;

    public PatientBuilder() {
        patient = new Patient();
    }

    public PatientBuilder setId(long id) {
        patient.setId(id);
        return this;
    }

    public PatientBuilder setName(String name) {
        patient.setName(name);
        return this;
    }

    public PatientBuilder setId_card_nr(long id_card_nr) {
        patient.setId_card_nr(id_card_nr);
        return this;
    }

    public PatientBuilder setPers_num_code(long pnc) {
        patient.setPers_num_code(pnc);
        return this;
    }

    public PatientBuilder setBirthday(LocalDate date) {
        patient.setBirthday(date);
        return this;
    }

    public PatientBuilder setAddress(String address) {
        patient.setAddress(address);
        return this;
    }

    public Patient build() {
        return patient;
    }
}
