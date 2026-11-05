package spring_boot_security.user.infrastructure.dto;

import lombok.Data;

@Data
public class LoginRequestDto {

    private String email;
    private String password;
}
