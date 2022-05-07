package kz.jusan.spring.bank.cli.jusanspringcli;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;


public class JusanSpringCliApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("props.xml");
        printCommands();
        try (Scanner scanner = new Scanner(System.in)) {
            AccountBasicCLI accountBasicCLI = context.getBean(AccountBasicCLI.class);
            while (true) {
                String input = scanner.next();
                commandOperations(input, accountBasicCLI);
                if (input.equals("7")) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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

    public static void commandOperations(String commandNumber, AccountBasicCLI accountBasicCLI) {
        switch (commandNumber) {
            case "1" -> {
                accountBasicCLI.getAccount("1");
            }
            case "2" -> {
                System.out.println("""
                        Choose account type
                        [CHECKING, SAVING, FIXED]""");
                accountBasicCLI.createAccountRequest("1");
            }
            case "3" -> System.out.println("deposit");
            case "4" -> System.out.println("withdraw");
            case "5" -> System.out.println("transfer");
            case "6" -> printCommands();
            case "7" -> System.out.println("Application closed");
            default -> System.out.println("Not expected command");
        }
    }
}
