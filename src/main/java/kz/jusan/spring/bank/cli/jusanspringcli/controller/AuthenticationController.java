package kz.jusan.spring.bank.cli.jusanspringcli.controller;

import kz.jusan.spring.bank.cli.jusanspringcli.output.BodyResponse;
import kz.jusan.spring.bank.cli.jusanspringcli.request.AuthRequest;
import kz.jusan.spring.bank.cli.jusanspringcli.service.UserService;
import kz.jusan.spring.bank.cli.jusanspringcli.util.CurrentData;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationController {
    @Autowired
    UserService userService;

    final CurrentData currentData = new CurrentData();


    @PostMapping("/authenticate")
    public BodyResponse authenticate(@RequestBody AuthRequest authRequest) {
        return userService.authenticate(authRequest, currentData.timestamp());
    }

    @PostMapping("/register")
    public BodyResponse register(@RequestBody AuthRequest createUserRequest) {
        return userService.register(createUserRequest, currentData.timestamp());
    }

}
