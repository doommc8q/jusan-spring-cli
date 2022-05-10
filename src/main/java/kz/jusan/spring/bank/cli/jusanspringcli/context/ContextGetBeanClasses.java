package kz.jusan.spring.bank.cli.jusanspringcli.context;

import kz.jusan.spring.bank.cli.jusanspringcli.cli.AccountBasicCLI;
import kz.jusan.spring.bank.cli.jusanspringcli.cli.MyCLI;
import kz.jusan.spring.bank.cli.jusanspringcli.deposit.TransactionDepositCLI;
import kz.jusan.spring.bank.cli.jusanspringcli.withdraw.TransactionWithdrawCLI;

public class ContextGetBeanClasses {
    private MyCLI myCLI;
    private AccountBasicCLI accountBasicCLI;
    private TransactionDepositCLI transactionDepositCLI;
    private TransactionWithdrawCLI transactionWithdrawCLI;

    public ContextGetBeanClasses(MyCLI myCLI, AccountBasicCLI accountBasicCLI, TransactionDepositCLI transactionDepositCLI, TransactionWithdrawCLI transactionWithdrawCLI) {
        this.myCLI = myCLI;
        this.accountBasicCLI = accountBasicCLI;
        this.transactionDepositCLI = transactionDepositCLI;
        this.transactionWithdrawCLI = transactionWithdrawCLI;
    }

    public MyCLI getMyCLI() {
        return myCLI;
    }

    public void setMyCLI(MyCLI myCLI) {
        this.myCLI = myCLI;
    }

    public AccountBasicCLI getAccountBasicCLI() {
        return accountBasicCLI;
    }

    public void setAccountBasicCLI(AccountBasicCLI accountBasicCLI) {
        this.accountBasicCLI = accountBasicCLI;
    }

    public TransactionDepositCLI getTransactionDepositCLI() {
        return transactionDepositCLI;
    }

    public void setTransactionDepositCLI(TransactionDepositCLI transactionDepositCLI) {
        this.transactionDepositCLI = transactionDepositCLI;
    }

    public TransactionWithdrawCLI getTransactionWithdrawCLI() {
        return transactionWithdrawCLI;
    }

    public void setTransactionWithdrawCLI(TransactionWithdrawCLI transactionWithdrawCLI) {
        this.transactionWithdrawCLI = transactionWithdrawCLI;
    }
}
