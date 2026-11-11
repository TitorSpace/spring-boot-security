package spring_boot_security.user.infrastructure.password;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring_boot_security.user.domain.ports.PasswordEncoderPort;

@Service
@RequiredArgsConstructor
public class PasswordEncoderImpl implements PasswordEncoderPort {

    private final PasswordEncoder passwordEncoder;

    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
}
