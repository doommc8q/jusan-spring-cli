package kz.jusan.spring.bank.cli.jusanspringcli.cli;

import kz.jusan.spring.bank.cli.jusanspringcli.accountsType.AccountType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MyCLI extends CLIUI {
    Scanner scanner;

    MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    public double requestClientAmount() {
        return scanner.nextDouble();
    }

    public String requestClientAccountNumber() {
        String id = scanner.next();
        if (id.length() >=9){
            return "";
        }
        return id.substring(id.indexOf("00000") + 5);
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
