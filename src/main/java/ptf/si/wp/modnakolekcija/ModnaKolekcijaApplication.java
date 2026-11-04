package ptf.si.wp.modnakolekcija;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"ptf.si.wp.modnakolekcija", "controller", "data", "model", "repository"})
@EntityScan(basePackages = "model")
@EnableJpaRepositories(basePackages = "repository")
public class ModnaKolekcijaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModnaKolekcijaApplication.class, args);
    }
}