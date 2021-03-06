package fr.alternalis.banks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;

/**
 * Main class of the banks application.
 */
@SpringBootApplication
public class BanksApplication {

    public static void main(String[] args) {
        SpringApplication.run(BanksApplication.class, args);
    }

}
