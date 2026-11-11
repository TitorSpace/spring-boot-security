package spring_boot_security.user.application.command.register;

import lombok.Data;
import spring_boot_security.common.application.mediator.Request;

@Data
public class RegisterUserRequest implements Request<RegisterUserResponse> {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
