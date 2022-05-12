package kz.jusan.spring.bank.cli.jusanspringcli.transaction;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transaction {
    String id;
    String clientId;
    long accountId;
    String data;
    double amount;
    TransactionType transactionType;
    boolean completed;

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", clientId='" + clientId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", data=" + data +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                ", completed=" + completed +
                '}';
    }
}
