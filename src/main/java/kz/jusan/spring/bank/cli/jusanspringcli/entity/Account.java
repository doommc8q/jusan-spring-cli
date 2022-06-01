package kz.jusan.spring.bank.cli.jusanspringcli.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    @Id
    Long accountId;
    String fullAccountId;
    Long accountTypeId;
    String clientId;
    Long bankId;
    Double balance;
    Long userId;
}
