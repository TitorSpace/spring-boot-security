package spring_boot_security.user.infrastructure.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import spring_boot_security.user.application.command.login.LoginUserRequest;
import spring_boot_security.user.application.command.login.LoginUserResponse;
import spring_boot_security.user.application.command.register.RegisterUserRequest;
import spring_boot_security.user.application.command.register.RegisterUserResponse;
import spring_boot_security.user.infrastructure.api.dto.LoginRequestDto;
import spring_boot_security.user.infrastructure.api.dto.RegisterRequestDto;
import spring_boot_security.user.infrastructure.api.dto.TokenResponseDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {

    LoginUserRequest mapToLoginUserRequest(LoginRequestDto loginRequestDto);

    RegisterUserRequest mapToRegisterUserRequest(RegisterRequestDto registerRequestDto);

    TokenResponseDto mapToTokenResponseDto(LoginUserResponse loginUserResponse);

    TokenResponseDto mapToTokenResponseDto(RegisterUserResponse registerUserResponse);

}
