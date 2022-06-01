package kz.jusan.spring.bank.cli.jusanspringcli.controller;

import jakarta.servlet.http.HttpServletRequest;
import kz.jusan.spring.bank.cli.jusanspringcli.output.BodyResponse;
import kz.jusan.spring.bank.cli.jusanspringcli.service.UserService;
import kz.jusan.spring.bank.cli.jusanspringcli.util.CurrentData;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    final CurrentData currentData = new CurrentData();

    @GetMapping
    public BodyResponse getUser(HttpServletRequest request) {
        String jwtToken = request.getHeader("Authorization").replace("Bearer ", "");
        return userService.getUser(jwtToken, currentData.timestamp());
    }

}
