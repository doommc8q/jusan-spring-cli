package kz.jusan.spring.bank.cli.jusanspringcli.context;

import kz.jusan.spring.bank.cli.jusanspringcli.cli.AccountBasicCLI;
import kz.jusan.spring.bank.cli.jusanspringcli.cli.MyCLI;
import kz.jusan.spring.bank.cli.jusanspringcli.deposit.TransactionDepositCLI;
import kz.jusan.spring.bank.cli.jusanspringcli.withdraw.TransactionWithdrawCLI;
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
}
