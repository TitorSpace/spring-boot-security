package spring_boot_security.user.application.command.register;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring_boot_security.common.application.mediator.RequestHandler;
import spring_boot_security.user.domain.User;
import spring_boot_security.user.domain.UserRole;
import spring_boot_security.user.domain.ports.AuthenticationPort;
import spring_boot_security.user.domain.ports.PasswordEncoderPort;
import spring_boot_security.user.domain.ports.UserRepository;

@Service
@RequiredArgsConstructor
public class RegisterUserHandler implements RequestHandler<RegisterUserRequest, RegisterUserResponse> {

    private final UserRepository userRepository;
    private final PasswordEncoderPort passwordEncoderPort;
    private final AuthenticationPort authenticationPort;

    @Override
    public RegisterUserResponse handle(RegisterUserRequest request) {

        boolean existsByEmail = userRepository.existsByEmail(request.getEmail());

        if (existsByEmail) {
            throw new RuntimeException("Email already exists");
        }

        String encoded = passwordEncoderPort.encode(request.getPassword());

        User user = User.builder().
                firstName(request.getFirstName()).
                lastName(request.getLastName()).
                email(request.getEmail()).
                password(encoded).
                role(UserRole.USER).
                build();

        userRepository.upsert(user);

        String token = authenticationPort.authenticate(request.getEmail(), request.getPassword());

        return new RegisterUserResponse(token);
    }

    @Override
    public Class<RegisterUserRequest> getRequestType() {
        return RegisterUserRequest.class;
    }
}
