package spring_boot_security.user.domain.ports;

public interface AuthenticationPort {

    String authenticate(String username, String password);
}
