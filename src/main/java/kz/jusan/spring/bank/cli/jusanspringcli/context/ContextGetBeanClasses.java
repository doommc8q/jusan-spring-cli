package kz.jusan.spring.bank.cli.jusanspringcli.context;

import kz.jusan.spring.bank.cli.jusanspringcli.controller.cli.AccountBasicCLI;
import kz.jusan.spring.bank.cli.jusanspringcli.controller.cli.MyCLI;
import kz.jusan.spring.bank.cli.jusanspringcli.repository.TransactionDAO;
import kz.jusan.spring.bank.cli.jusanspringcli.controller.cli.TransactionDepositCLI;
import kz.jusan.spring.bank.cli.jusanspringcli.controller.cli.TransactionWithdrawCLI;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
public class ContextGetBeanClasses {
    MyCLI myCLI;
    AccountBasicCLI accountBasicCLI;
    TransactionDepositCLI transactionDepositCLI;
    TransactionWithdrawCLI transactionWithdrawCLI;
    TransactionDAO transactionDAO;
}
