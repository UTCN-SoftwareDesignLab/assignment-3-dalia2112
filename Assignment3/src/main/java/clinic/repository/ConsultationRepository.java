package clinic.repository;

import clinic.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    Consultation findById(long id);

    List<Consultation> findAll();

    List<Consultation> findByDoctorId(long docId);

    List<Consultation> findByDate(LocalDate date);
}
