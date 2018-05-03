package clinic.repository;

import clinic.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    Consultation findById(long id);
    List<Consultation> findAll();
}
