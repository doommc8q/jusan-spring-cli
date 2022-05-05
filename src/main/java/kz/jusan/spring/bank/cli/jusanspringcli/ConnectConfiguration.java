package kz.jusan.spring.bank.cli.jusanspringcli;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan(basePackages = "kz.jusan.spring.bank.cli.jusanspringcli")
public class ConnectConfiguration {

    @Bean
    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    @Bean
    public AccountBasicCLI accountBasicCLI(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore, AccountListingServiceImpl accountListing) {
        return new AccountBasicCLI(createAccountOperationUI, bankCore, accountListing);
    }

    @Bean
    public AccountCreationService accountCreationService(MemoryAccountDAO memoryAccountDAO) {
        return new AccountCreationServiceImpl(memoryAccountDAO);
    }

    @Bean
    public AccountCreationServiceImpl accountCreationServiceImpl(MemoryAccountDAO memoryAccountDAO) {
        return new AccountCreationServiceImpl(memoryAccountDAO);
    }

    @Bean
    public AccountDAO accountDAO() {
        return new MemoryAccountDAO();
    }

    @Bean
    public AccountListingServiceImpl accountListingServiceImpl() {
        return new AccountListingServiceImpl();
    }

    @Bean
    public AccountListingService accountListingService() {
        return new AccountListingServiceImpl();
    }

    @Bean
    public BankCore bankCore(AccountCreationServiceImpl account) {
        return new BankCore(account);
    }

    @Bean
    public CreateAccountOperationUI createAccountOperationUI(Scanner scanner) {
        return new MyCLI(scanner);
    }

    @Bean
    public MemoryAccountDAO memoryAccountDAO() {
        return new MemoryAccountDAO();
    }
}
