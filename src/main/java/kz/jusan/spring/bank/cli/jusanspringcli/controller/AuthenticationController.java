package kz.jusan.spring.bank.cli.jusanspringcli.controller;

import kz.jusan.spring.bank.cli.jusanspringcli.output.OutputBody;
import kz.jusan.spring.bank.cli.jusanspringcli.request.AuthenticationRequest;
import kz.jusan.spring.bank.cli.jusanspringcli.service.UserService;
import kz.jusan.spring.bank.cli.jusanspringcli.util.CurrentData;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationController {
    @Autowired
    UserService userService;

    final CurrentData currentData = new CurrentData();


    @PostMapping("/authenticate")
    public OutputBody authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return userService.authenticate(authenticationRequest, currentData.timestamp());
    }

    @PostMapping("/register")
    public OutputBody register(@RequestBody AuthenticationRequest authenticationRequest) {
        return userService.register(authenticationRequest, currentData.timestamp());
    }
}
