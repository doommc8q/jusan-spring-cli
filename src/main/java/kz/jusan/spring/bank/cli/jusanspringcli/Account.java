package kz.jusan.spring.bank.cli.jusanspringcli;

// В данном проекте основным доменом является счет Account
public class Account {
    private AccountType accountType;
    private long id;
    private String clientID;
    private long bankID;
    private double balance;
    private boolean withdrawAllowed;

    public String getClientID() {
        return clientID;
    }

    void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isWithdrawAllowed() {
        return withdrawAllowed;
    }

    public void setWithdrawAllowed(boolean withdrawAllowed) {
        this.withdrawAllowed = withdrawAllowed;
    }

    public void setBankID(long bankID) {
        this.bankID = bankID;
    }

    public long getBankID() {
        return bankID;
    }

    public Account(AccountType accountType, long bankID, long id, String clientID, double balance, boolean withdrawAllowed) {
        this.accountType = accountType;
        this.id = id;
        this.bankID = bankID;
        this.clientID = clientID;
        this.balance = balance;
        this.withdrawAllowed = withdrawAllowed;
    }

    @Override
    public String toString() {
        return String.format("Account{, id='%03d%06d', clientID='%s', balance=%.1f}", 1, id, clientID, balance);
    }
}
