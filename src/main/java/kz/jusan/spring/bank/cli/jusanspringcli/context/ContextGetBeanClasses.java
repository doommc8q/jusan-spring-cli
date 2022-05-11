package kz.jusan.spring.bank.cli.jusanspringcli.context;

import kz.jusan.spring.bank.cli.jusanspringcli.cli.AccountBasicCLI;
import kz.jusan.spring.bank.cli.jusanspringcli.cli.MyCLI;
import kz.jusan.spring.bank.cli.jusanspringcli.deposit.TransactionDepositCLI;
import kz.jusan.spring.bank.cli.jusanspringcli.withdraw.TransactionWithdrawCLI;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ContextGetBeanClasses {
    private MyCLI myCLI;
    private AccountBasicCLI accountBasicCLI;
    private TransactionDepositCLI transactionDepositCLI;
    private TransactionWithdrawCLI transactionWithdrawCLI;
}
