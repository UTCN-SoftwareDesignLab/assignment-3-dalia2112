package clinic.controller;

import clinic.model.Consultation;
import clinic.model.Patient;
import clinic.model.builder.PatientBuilder;
import clinic.model.validation.Notification;
import clinic.service.consultation.ConsultationService;
import clinic.service.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;


@Controller
public class SecretaryController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private ConsultationService consultationService;

    /*********************ADD / UPDATE PATIENT*******************/

    @RequestMapping(value = "/secretaryOp", method = RequestMethod.GET)
    public String showSecretary() {
        return "secretaryOp";
    }


    @RequestMapping(value = "/secretaryOp", params = "addPatient", method = RequestMethod.POST)
    public String addPatient(Model model, @RequestParam String name, @RequestParam long icn, @RequestParam long pnc, @RequestParam String bday, @RequestParam String addr) {

        LocalDate bd=LocalDate.parse(bday);
        Patient patient=new PatientBuilder()
                .setName(name)
                .setId_card_nr(icn)
                .setPers_num_code(pnc)
                .setBirthday(bd)
                .setAddress(addr)
                .build();
        Notification<Boolean> notification=patientService.addPatient(patient);
        return "secretaryOp";
    }

    @RequestMapping(value = "/patientView", params = "viewPatients", method = RequestMethod.GET)
    public String findAllPatients(Model model) {
        final List<Patient> items = patientService.findAll();
        model.addAttribute("patients", items);
        return "secretaryOp";
    }


    /********************CONSULTATIONS********************/


}
