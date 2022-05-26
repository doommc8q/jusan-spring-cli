package kz.jusan.spring.bank.cli.jusanspringcli.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OutputBody {
    private String message;
    private String timestamp;
    private Integer statusCode;
    private Object body;
}
