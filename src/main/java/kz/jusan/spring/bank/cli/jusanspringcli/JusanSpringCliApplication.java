package kz.jusan.spring.bank.cli.jusanspringcli;

import kz.jusan.spring.bank.cli.jusanspringcli.controller.cli.AccountBasicCLI;
import kz.jusan.spring.bank.cli.jusanspringcli.controller.cli.MyCLI;
import kz.jusan.spring.bank.cli.jusanspringcli.context.ContextGetBeanClasses;
import kz.jusan.spring.bank.cli.jusanspringcli.repository.TransactionDAO;
import kz.jusan.spring.bank.cli.jusanspringcli.controller.cli.TransactionDepositCLI;
import kz.jusan.spring.bank.cli.jusanspringcli.controller.cli.TransactionWithdrawCLI;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JusanSpringCliApplication implements CommandLineRunner {
    final static String clientID = "1";

    @Autowired
    ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(JusanSpringCliApplication.class).close();
    }

    // Method which implemented from Class CommandLineRunner
    @Override
    public void run(String... arg0) {
        ContextGetBeanClasses classContext = new ContextGetBeanClasses(
                context.getBean(MyCLI.class),
                context.getBean(AccountBasicCLI.class),
                context.getBean(TransactionDepositCLI.class),
                context.getBean(TransactionWithdrawCLI.class),
                context.getBean(TransactionDAO.class)
        );

        printCommands();

        try {
            commandCycle(classContext, clientID);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            classContext.getMyCLI().getScanner().close();
        }
    }

    // Method to print commands and definition
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

    // Method to print command operations
    public static void commandOperations(
            String commandNumber,
            AccountBasicCLI accountBasicCLI,
            TransactionDepositCLI transactionDepositCLI,
            TransactionWithdrawCLI transactionWithdrawCLI,
            TransactionDAO transactionDAO,
            String clientID
    ) {
        switch (commandNumber) {
            case "1" -> accountBasicCLI.getAccounts(clientID);
            case "2" -> accountBasicCLI.createAccountRequest(clientID);
            case "3" -> transactionDepositCLI.depositMoney(clientID);
            case "4" -> transactionWithdrawCLI.withdrawMoney(clientID);
            case "5" -> transactionDAO.findAll().forEach(System.out::println);
            case "6" -> printCommands();
            case "7" -> System.out.println("Application Closed");
            default -> System.out.println("Not expected command");
        }
    }

    // Cycle method to call commandOperations
    public void commandCycle(ContextGetBeanClasses classContext, String clientID) {
        while (true) {
            String input = classContext.getMyCLI().getScanner().nextLine();
            commandOperations(
                    input,
                    classContext.getAccountBasicCLI(),
                    classContext.getTransactionDepositCLI(),
                    classContext.getTransactionWithdrawCLI(),
                    classContext.getTransactionDAO(),
                    clientID
            );

            if (input.equals("7")) {
                break;
            }
        }
    }
}
