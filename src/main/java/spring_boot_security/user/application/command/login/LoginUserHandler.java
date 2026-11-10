package spring_boot_security.user.application.command.login;

import org.springframework.stereotype.Service;
import spring_boot_security.common.application.mediator.RequestHandler;

@Service
public class LoginUserHandler implements RequestHandler<LoginUserRequest, LoginUserResponse> {


    @Override
    public LoginUserResponse handle(LoginUserRequest request) {
        return null;
    }

    @Override
    public Class<LoginUserRequest> getRequestType() {
        return null;
    }
}
