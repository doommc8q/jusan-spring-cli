package kz.jusan.spring.bank.cli.jusanspringcli.cli;

import kz.jusan.spring.bank.cli.jusanspringcli.withdraw.WithdrawDepositOperationCLIUI;
import org.springframework.stereotype.Component;

@Component
public interface CLIUI extends CreateAccountOperationUI, WithdrawDepositOperationCLIUI {

}
