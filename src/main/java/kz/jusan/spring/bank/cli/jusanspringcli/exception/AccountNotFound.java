package kz.jusan.spring.bank.cli.jusanspringcli.exception;

public class AccountNotFound extends RuntimeException{
    public AccountNotFound(Long id) {
        super(String.format("Could not find account %d", id));
    }
}
