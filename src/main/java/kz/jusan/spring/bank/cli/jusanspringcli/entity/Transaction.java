package kz.jusan.spring.bank.cli.jusanspringcli.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transaction {
    @Id
    Long transactionId;
    String clientId;
    Long accountId;
    Long bankId;
    String transactionData;
    double amount;
    Long transactionTypeId;
    boolean completed;
}
