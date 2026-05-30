package io.github.edualves4785.dokamiapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DokamiapiApplication {



    public static void main(String[] args) {
        SpringApplication.run(DokamiapiApplication.class, args);

    }

}
