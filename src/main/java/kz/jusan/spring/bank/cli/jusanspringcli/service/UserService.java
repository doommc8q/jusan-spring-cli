package kz.jusan.spring.bank.cli.jusanspringcli.service;

import kz.jusan.spring.bank.cli.jusanspringcli.config.jwt.JwtProvider;
import kz.jusan.spring.bank.cli.jusanspringcli.entity.Role;
import kz.jusan.spring.bank.cli.jusanspringcli.entity.Users;
import kz.jusan.spring.bank.cli.jusanspringcli.output.BodyResponse;
import kz.jusan.spring.bank.cli.jusanspringcli.output.TokenResponse;
import kz.jusan.spring.bank.cli.jusanspringcli.repository.RoleRepository;
import kz.jusan.spring.bank.cli.jusanspringcli.repository.UserRepository;
import kz.jusan.spring.bank.cli.jusanspringcli.request.AuthRequest;
import kz.jusan.spring.bank.cli.jusanspringcli.util.ConstantMessages;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.Optional;

@Service
//@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private JwtProvider jwtProvider;

    public BodyResponse authenticate(AuthRequest authRequest, String timestamp) {
        Optional<Users> user = userRepository.findUserByUsername(authRequest.getUsername());
        if (user.isEmpty()) {
            return new BodyResponse(ConstantMessages.USER_NOT_EXIST, timestamp, Response.Status.CONFLICT, null);
        }

        if (user.get().getUsername().equals(authRequest.getUsername())) {
            return new BodyResponse(ConstantMessages.USER_EMAIL_WRONG, timestamp, Response.Status.CONFLICT, null);
        }

        if (user.get().getPassword().equals(passwordEncoder.encode(authRequest.getPassword()))) {
            return new BodyResponse(ConstantMessages.USER_PASSWORD_WRONG, timestamp, Response.Status.CONFLICT, null);
        }

        String token = jwtProvider.generateToken(user.get(), "USER_ROlE");

        if (token.equals("")) {
            return new BodyResponse(ConstantMessages.USER_AUTHENTICATED_FAIL, timestamp, Response.Status.BAD_REQUEST, null);
        }

        return new BodyResponse(ConstantMessages.USER_AUTHENTICATED_SUCCESS, timestamp, Response.Status.OK, new TokenResponse(token));
    }

    public BodyResponse register(AuthRequest authRequest, String timestamp) {
        if (userRepository.findUserByUsername(authRequest.getUsername()).isPresent()) {
            return new BodyResponse(ConstantMessages.USER_EXIST, timestamp, Response.Status.CONFLICT, null);
        }

        if (authRequest.getPassword().equals("")) {
            return new BodyResponse(ConstantMessages.USER_PASSWORD_SHORT, timestamp, Response.Status.BAD_REQUEST, null);
        }

        if (authRequest.getUsername().equals("")) {
            return new BodyResponse(ConstantMessages.USER_USERNAME_SHORT, timestamp, Response.Status.BAD_REQUEST, null);
        }
        Optional<Role> role = roleRepository.findByRoleType("ROLE_USER");
        if(role.isEmpty()) {
            return new BodyResponse(ConstantMessages.USER_ROLE_ERROR, timestamp, Response.Status.BAD_REQUEST, null);
        }
        Users userBuilder = Users.builder()
                .username(authRequest.getUsername())
                .password(passwordEncoder.encode(authRequest.getPassword()))
                .role(role.get())
                .build();
        return new BodyResponse(ConstantMessages.USER_CREATED, timestamp, Response.Status.OK, userRepository.save(userBuilder));
    }

    public BodyResponse getUserByUsername(String username, String timestamp) {
        Optional<Users> user = userRepository.findUserByUsername(username);
        if (user.isEmpty()) {
            return new BodyResponse(ConstantMessages.USER_NOT_EXIST, timestamp, Response.Status.CONFLICT, null);
        }
        return new BodyResponse(ConstantMessages.SUCCESS, timestamp, Response.Status.OK, user);
    }
}
