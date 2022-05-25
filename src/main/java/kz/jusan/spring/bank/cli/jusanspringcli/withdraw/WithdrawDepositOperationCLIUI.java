package kz.jusan.spring.bank.cli.jusanspringcli.withdraw;

import org.springframework.stereotype.Component;

@Component
public interface WithdrawDepositOperationCLIUI {
    double requestClientAmount();

    String requestClientAccountNumber();
}
