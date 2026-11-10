package spring_boot_security.user.application.command.login;

import lombok.Data;
import spring_boot_security.common.application.mediator.Request;

@Data
public class LoginUserRequest implements Request<LoginUserResponse> {

    private String email;
    private String password;
}
