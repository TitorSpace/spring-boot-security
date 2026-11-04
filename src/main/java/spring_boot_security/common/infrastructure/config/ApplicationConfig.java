package spring_boot_security.common.infrastructure.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

//Al iniciar el proycto spring boot escaneara y buscara aqui en configuracion y traera las configuracion qeu tenga esta clase
@Configuration
@EnableAsync
//@EnableScheduling
@EnableCaching
public class ApplicationConfig {
}
