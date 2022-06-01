package kz.jusan.spring.bank.cli.jusanspringcli.service;

import io.jsonwebtoken.Claims;
import kz.jusan.spring.bank.cli.jusanspringcli.config.jwt.JwtProvider;
import kz.jusan.spring.bank.cli.jusanspringcli.entity.Role;
import kz.jusan.spring.bank.cli.jusanspringcli.entity.Users;
import kz.jusan.spring.bank.cli.jusanspringcli.output.BodyResponse;
import kz.jusan.spring.bank.cli.jusanspringcli.output.ParsedToken;
import kz.jusan.spring.bank.cli.jusanspringcli.output.TokenResponse;
import kz.jusan.spring.bank.cli.jusanspringcli.output.UserResponse;
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
        Optional<Users> user = userRepository.findByUsername(authRequest.getUsername());
        if (user.isEmpty()) {
            return new BodyResponse(ConstantMessages.USER_NOT_EXIST, timestamp, Response.Status.CONFLICT, null);
        }

        if (!user.get().getUsername().equals(authRequest.getUsername())) {
            return new BodyResponse(ConstantMessages.USER_EMAIL_WRONG, timestamp, Response.Status.CONFLICT, null);
        }

        if (!passwordEncoder.matches(authRequest.getPassword(),user.get().getPassword())) {
            return new BodyResponse(ConstantMessages.USER_PASSWORD_WRONG, timestamp, Response.Status.CONFLICT, null);
        }

        String token = jwtProvider.generateToken(user.get(), "USER_ROlE");

        if (token.equals("")) {
            return new BodyResponse(ConstantMessages.USER_AUTHENTICATED_FAIL, timestamp, Response.Status.BAD_REQUEST, null);
        }

        return new BodyResponse(ConstantMessages.USER_AUTHENTICATED_SUCCESS, timestamp, Response.Status.OK, new TokenResponse(token));
    }

    public BodyResponse register(AuthRequest authRequest, String timestamp) {
        Optional<Users> user = userRepository.findByUsername(authRequest.getUsername());
        if (user.isPresent()) {
            return new BodyResponse(ConstantMessages.USER_EXIST, timestamp, Response.Status.CONFLICT, null);
        }


        if (authRequest.getPassword().equals("")) {
            return new BodyResponse(ConstantMessages.USER_PASSWORD_SHORT, timestamp, Response.Status.BAD_REQUEST, null);
        }

        if (authRequest.getUsername().equals("")) {
            return new BodyResponse(ConstantMessages.USER_USERNAME_SHORT, timestamp, Response.Status.BAD_REQUEST, null);
        }
        Optional<Role> role = roleRepository.findById(2L);
        if(role.isEmpty()) {
            return new BodyResponse(ConstantMessages.USER_ROLE_ERROR, timestamp, Response.Status.BAD_REQUEST, null);
        }
        Users userBuilder = Users.builder()
                .username(authRequest.getUsername())
                .password(passwordEncoder.encode(authRequest.getPassword()))
                .roleId(role.get().getRoleId())
                .build();
        return new BodyResponse(ConstantMessages.USER_CREATED, timestamp, Response.Status.OK, userRepository.save(userBuilder));
    }

    public Users getUserByUsername(String username, String timestamp) {
        Optional<Users> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            return null;
        }
        return user.get();
    }

    public Role getRoleById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isEmpty()) {
            return null;
        }
        return role.get();
    }

    public BodyResponse getUser(String token,String timestamp) {
        ParsedToken parsedToken = jwtProvider.parseFromToken(token);
        Optional<Users> user = userRepository.findById(parsedToken.getId());

        if (user.isEmpty()) {
            return new BodyResponse(ConstantMessages.USER_NOT_EXIST, timestamp, Response.Status.CONFLICT, null);
        }
        UserResponse userResponse = new UserResponse(user.get().getUserId(),user.get().getUsername(),user.get().getRoleId());
        return new BodyResponse(ConstantMessages.SUCCESS, timestamp, Response.Status.OK, userResponse);
    }

}
