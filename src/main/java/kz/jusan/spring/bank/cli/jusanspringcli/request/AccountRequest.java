package kz.jusan.spring.bank.cli.jusanspringcli.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountRequest {
    String clientId;
    Long bankId;
    String accountType;
}
