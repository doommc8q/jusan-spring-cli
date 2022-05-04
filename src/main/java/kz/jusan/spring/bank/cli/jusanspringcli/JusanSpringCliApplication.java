package kz.jusan.spring.bank.cli.jusanspringcli;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;


@SpringBootApplication
public class JusanSpringCliApplication {
    public static void main(String[] args) {
        printCommands();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("props.xml");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                MyCLI myCLI = applicationContext.getBean((MyCLI.class));
                String input = scanner.next();
                commandOperations(input);
            }
        }
//		SpringApplication.run(JusanSpringCliApplication.class, args);
    }

    public static void printCommands() {
        System.out.println("""
                Welcome to CLI bank service
                Enter operation number:
                1 - show accounts
                2 - create account
                3 - deposit
                4 - withdraw
                5 - transfer
                6 - this message
                7 - exit""");
    }

    public static void commandOperations(String commandNumber) {
        switch (commandNumber) {
            case "1" -> System.out.println("show accounts");
            case "2" -> System.out.println("create account");
            case "3" -> System.out.println("deposit");
            case "4" -> System.out.println("withdraw");
            case "5" -> System.out.println("transfer");
            case "6" -> System.out.println("this message");
            case "7" -> System.out.println("Application closed");
            default -> System.out.println("Not expected command");
        }
    }
}
