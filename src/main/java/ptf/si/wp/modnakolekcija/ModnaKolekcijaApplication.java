package ptf.si.wp.modnakolekcija;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"ptf.si.wp.modnakolekcija", "controller", "data", "model"})
public class ModnaKolekcijaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModnaKolekcijaApplication.class, args);
    }

}
