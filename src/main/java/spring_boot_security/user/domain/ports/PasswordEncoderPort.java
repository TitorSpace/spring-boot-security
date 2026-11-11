package spring_boot_security.user.domain.ports;

public interface PasswordEncoderPort {

    String encode(String password);
}
