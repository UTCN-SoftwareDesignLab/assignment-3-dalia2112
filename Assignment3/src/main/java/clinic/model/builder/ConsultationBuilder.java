package clinic.model.builder;

import clinic.model.Consultation;
import clinic.model.Patient;
import clinic.model.User;

import java.time.LocalDate;

public class ConsultationBuilder {

    private Consultation consultation;

    public ConsultationBuilder() {
        consultation=new Consultation();
    }

    public ConsultationBuilder setId(long id){
        consultation.setId(id);
        return this;
    }

    public ConsultationBuilder setDate(LocalDate date){
        consultation.setDate(date);
        return this;
    }

    public ConsultationBuilder setPatient(Patient patient){
        consultation.setPatient(patient);
        return this;
    }

    public ConsultationBuilder setDoctor(User doctor){
        consultation.setDoctor(doctor);
        return this;
    }

    public ConsultationBuilder setDetails(String details){
        consultation.setDetails(details);
        return this;
    }

    public Consultation build(){
        return consultation;
    }
}
