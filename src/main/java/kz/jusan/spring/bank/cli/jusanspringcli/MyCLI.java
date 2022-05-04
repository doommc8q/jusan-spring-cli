package kz.jusan.spring.bank.cli.jusanspringcli;

import java.util.Scanner;

public class MyCLI implements CLIUI {
    private Scanner scanner;

    public MyCLI(Scanner scanner) {
        this.scanner = scanner;
    }

    public double requestClientAmount() {
        return 0.0;
    }

    public String requestClientAccountNumber() {
        return "";
    }

    public AccountType requestAccountType() {
        return new AccountType();
    }
}
