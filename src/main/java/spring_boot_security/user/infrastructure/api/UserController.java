package spring_boot_security.user.infrastructure.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_boot_security.common.application.mediator.Mediator;
import spring_boot_security.user.application.command.login.LoginUserRequest;
import spring_boot_security.user.application.command.login.LoginUserResponse;
import spring_boot_security.user.application.command.register.RegisterUserRequest;
import spring_boot_security.user.application.command.register.RegisterUserResponse;
import spring_boot_security.user.infrastructure.api.dto.LoginRequestDto;
import spring_boot_security.user.infrastructure.api.dto.RegisterRequestDto;
import spring_boot_security.user.infrastructure.api.dto.TokenResponseDto;
import spring_boot_security.user.infrastructure.api.mapper.UserMapper;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "User", description = "User API operations")
@Slf4j
public class UserController {

    private final Mediator mediator;
    private final UserMapper userMapper;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {

        LoginUserRequest request = userMapper.mapToLoginUserRequest(loginRequestDto);

        LoginUserResponse response = mediator.dispatch(request);

        TokenResponseDto tokenResponseDto = userMapper.mapToTokenResponseDto(response);
        return ResponseEntity.ok(tokenResponseDto);
    }

    @PostMapping("/register")
    public ResponseEntity<TokenResponseDto> register(@RequestBody RegisterRequestDto registerRequestDto) {

        RegisterUserRequest request = userMapper.mapToRegisterUserRequest(registerRequestDto);

        RegisterUserResponse response = mediator.dispatch(request);

        TokenResponseDto tokenResponseDto = userMapper.mapToTokenResponseDto(response);
        return ResponseEntity.ok(tokenResponseDto);

        return ResponseEntity.ok(tokenResponseDto);
    }
}
