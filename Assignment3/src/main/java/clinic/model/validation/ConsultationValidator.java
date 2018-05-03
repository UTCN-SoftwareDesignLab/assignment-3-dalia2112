package clinic.model.validation;

import clinic.model.Consultation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConsultationValidator {

    private final Consultation consultation;
    private List<String> errors;

    public ConsultationValidator(Consultation consultation) {
        this.consultation = consultation;
        errors=new ArrayList<>();
    }

    public boolean validate() {
        validateDate(consultation.getDate());
        return errors.isEmpty();
    }

    public List<String> getErrors() {
        return errors;
    }

    private void validateDate(LocalDate date){
        if(LocalDate.now().getYear()<date.getYear())
            errors.add("Invalid date! Appointments must be done in the future!");
    }


    public String getFormattedErrors() {
        String result = "";
        for (String error : getErrors())
            result += error + "\n \n";
        return result;
    }
}
