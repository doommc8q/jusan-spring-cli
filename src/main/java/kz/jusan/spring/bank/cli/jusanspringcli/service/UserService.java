package kz.jusan.spring.bank.cli.jusanspringcli.service;

import kz.jusan.spring.bank.cli.jusanspringcli.output.OutputBody;
import kz.jusan.spring.bank.cli.jusanspringcli.repository.UserRepository;
import kz.jusan.spring.bank.cli.jusanspringcli.request.AuthenticationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public OutputBody authenticate(AuthenticationRequest authenticationRequest, String timestamp) {
        return null;
    }

    public OutputBody register(AuthenticationRequest authenticationRequest, String timestamp) {
        return null;
    }
}
