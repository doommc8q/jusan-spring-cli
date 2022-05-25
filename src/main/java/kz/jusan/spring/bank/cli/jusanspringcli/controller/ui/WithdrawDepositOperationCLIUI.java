package kz.jusan.spring.bank.cli.jusanspringcli.controller.ui;

import org.springframework.stereotype.Component;

@Component
public interface WithdrawDepositOperationCLIUI {
    double requestClientAmount();

    String requestClientAccountNumber();
}
