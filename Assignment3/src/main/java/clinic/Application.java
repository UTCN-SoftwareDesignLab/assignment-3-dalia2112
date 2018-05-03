package clinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;

@SpringBootApplication
@EntityScan("clinic.model")
@EnableJpaRepositories({"clinic.repository"})
@ComponentScan({"clinic.model", "clinic.repository","clinic.service.user","clinic.service.patient","clinic.service.consultation","clinic.controller"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
}
