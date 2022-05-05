package kz.jusan.spring.bank.cli.jusanspringcli;

import java.util.Scanner;

public class MyCLI implements CLIUI {
    private Scanner scanner;

    public MyCLI(Scanner scanner) {
        this.scanner = scanner;
    }

    MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    public double requestClientAmount() {
        return 0.0;
    }

    public String requestClientAccountNumber() {
        return "";
    }

    public AccountType requestAccountType() {
        String accountType = scanner.next();
        if (!accountType.equals("CHECKING") && !accountType.equals("FIXED") && !accountType.equals("SAVING")) {
            System.out.println("Unexpected type");
            return null;
        }
        return new AccountType(accountType);
    }
}
