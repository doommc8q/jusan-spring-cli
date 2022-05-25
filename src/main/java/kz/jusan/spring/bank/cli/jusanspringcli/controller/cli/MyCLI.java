package kz.jusan.spring.bank.cli.jusanspringcli.controller.cli;

import kz.jusan.spring.bank.cli.jusanspringcli.controller.ui.CLIUI;
import kz.jusan.spring.bank.cli.jusanspringcli.entity.entityTypes.accountsType.AccountType;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Data
public class MyCLI implements CLIUI {
    private Scanner scanner;

    MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    public double requestClientAmount() {
        System.out.println("Type Amount of money");
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            return 0;
        }
    }

    public String requestClientAccountNumber() {
        System.out.println("Type account ID");
        return scanner.nextLine();
    }

    public AccountType requestAccountType() {
        String accountType = scanner.nextLine();
        if (!accountType.equals("CHECKING") && !accountType.equals("FIXED") && !accountType.equals("SAVING")) {
            System.out.println("Unexpected type");
            return null;
        }
        return AccountType.valueOf(accountType);
    }
}
