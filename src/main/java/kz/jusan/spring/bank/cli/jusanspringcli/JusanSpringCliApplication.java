package kz.jusan.spring.bank.cli.jusanspringcli;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JusanSpringCliApplication {
    public static void main(String[] args) {
        SpringApplication.run(JusanSpringCliApplication.class, args);
    }
}
