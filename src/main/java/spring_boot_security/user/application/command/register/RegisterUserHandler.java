package spring_boot_security.user.application.command.register;

import org.springframework.stereotype.Service;
import spring_boot_security.common.application.mediator.RequestHandler;

@Service
public class RegisterUserHandler implements RequestHandler<RegisterUserRequest, RegisterUserResponse> {


    @Override
    public RegisterUserResponse handle(RegisterUserRequest request) {
        return null;
    }

    @Override
    public Class<RegisterUserRequest> getRequestType() {
        return RegisterUserRequest.class;
    }
}
