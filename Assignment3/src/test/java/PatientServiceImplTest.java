import clinic.model.Patient;
import clinic.model.User;
import clinic.model.builder.PatientBuilder;
import clinic.model.builder.UserBuilder;
import clinic.repository.PatientRepository;
import clinic.repository.UserRepository;
import clinic.service.patient.PatientService;
import clinic.service.patient.PatientServiceImpl;
import clinic.service.user.UserService;
import clinic.service.user.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.swing.*;
import java.time.LocalDate;

import static reactor.core.publisher.Mono.when;

public class PatientServiceImplTest {

    @Mock
    PatientRepository patientRepository;

    @InjectMocks
    PatientService patientService = new PatientServiceImpl(patientRepository);


    Patient patient;

    @Before
    public void init() {
        LocalDate date=LocalDate.parse("1960-05-05");
        patient=new PatientBuilder()
                .setName("PatientName")
                .setId_card_nr(12345)
                .setPers_num_code(12345)
                .setBirthday(date)
                .setAddress("test address")
                .build();
    }

//    @Test
////    public void addPatient() {
////        JOptionPane.showMessageDialog(null,patientService.addPatient("PatientName",12345,12345,"1960-05-05","test address").getResult());
////        Assert.assertTrue(patientService.addPatient("PatientName",12345,12345,"1960-05-05","test address").getResult());
////    }

//    @Test
//    public void findById(){
//        long id=1;
//        Mockito.when(patientRepository.findById(id)).thenReturn(patient);
//        patient.setId(id);
//        Assert.assertEquals(id,patientRepository.findById(id).getId());
//    }

}
