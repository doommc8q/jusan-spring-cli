package kz.jusan.spring.bank.cli.jusanspringcli.output;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.ws.rs.core.Response.Status;


@Data
@AllArgsConstructor
public class BodyResponse {
    private String message;
    private String timestamp;
    private Status statusCode;
    private Object body;
}
