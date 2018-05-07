import clinic.model.Consultation;
import clinic.model.Patient;
import clinic.model.User;
import clinic.model.builder.ConsultationBuilder;
import clinic.model.builder.PatientBuilder;
import clinic.model.builder.UserBuilder;
import clinic.repository.ConsultationRepository;
import clinic.repository.PatientRepository;
import clinic.repository.UserRepository;
import clinic.service.consultation.ConsultationService;
import clinic.service.consultation.ConsultationServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration
public class ConsultationServiceImplTest {


    @Mock
    ConsultationRepository consultationRepository;
    @Mock
    UserRepository userRepository;
    @Mock
    PatientRepository patientRepository;

    @InjectMocks
    ConsultationService consultationService = new ConsultationServiceImpl(consultationRepository,userRepository,patientRepository);


    Consultation testConsultation;
    Patient testPatient;
    User testDoctor;
    List<Consultation> consultationList;

    @Before
    public void init() {
        testDoctor = new UserBuilder()
                .setName("dal@gm.com")
                .setPassword("dali123*")
                .setRole("doctor")
                .build();

        LocalDate date=LocalDate.parse("1960-05-05");
        LocalDate date2=LocalDate.parse("2019-05-05");
        testPatient=new PatientBuilder()
                .setName("PatientName")
                .setId_card_nr(12345)
                .setPers_num_code(12345)
                .setBirthday(date)
                .setAddress("test address")
                .build();

        testConsultation=new ConsultationBuilder()
                .setDate(date2)
                .setPatient(testPatient)
                .setDoctor(testDoctor)
                .setDetails("test details")
                .build();
    }

    @Test
    public void addConsultation() {
        when(patientRepository.findById(1)).thenReturn(testPatient);
        when(userRepository.findById(1)).thenReturn(testDoctor);
        Assert.assertTrue(consultationService.addConsultation(testConsultation.getDate().toString(),1,1).getResult());
    }

    @Test
    public void findById(){
        long id=1;
        when(consultationRepository.findById(id)).thenReturn(testConsultation);
        testConsultation.setId(id);
        Assert.assertEquals(id,consultationRepository.findById(id).getId());
    }

    @Test
    public void findByDate(){
        LocalDate date=LocalDate.parse("2019-05-05");
        List<Consultation> list=new ArrayList<>();
        list.add(testConsultation);
        when(consultationRepository.findByDate(date)).thenReturn(list);
        Assert.assertEquals(consultationRepository.findByDate(date).size(),1);
    }
}