package kz.jusan.spring.bank.cli.jusanspringcli.cli;

import kz.jusan.spring.bank.cli.jusanspringcli.accountsType.AccountType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@EqualsAndHashCode(callSuper = true)
@Service
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MyCLI extends CLIUI {
    Scanner scanner;

    MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    public double requestClientAmount() {
        System.out.println("Type Amount of money");
        return scanner.nextDouble();
    }

    public String requestClientAccountNumber() {
        System.out.println("Type account ID");
        return scanner.next();
    }

    public AccountType requestAccountType() {
        String accountType = scanner.next();
        if (!accountType.equals("CHECKING") && !accountType.equals("FIXED") && !accountType.equals("SAVING")) {
            System.out.println("Unexpected type");
            return null;
        }
        return AccountType.valueOf(accountType);
    }
}
