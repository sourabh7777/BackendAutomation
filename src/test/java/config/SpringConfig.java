package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
// This ensures application.properties or application-{profile}.properties are loaded
@PropertySource("classpath:application.properties")
public class SpringConfig {

    private final Environment env;

    public SpringConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public String apiKey() {
        // Reads from system property (-Dapi.key) or env var (API_KEY) if Gradle passes it
        return env.getProperty("api.key", "");
    }

    @Bean
    public String activeProfile() {
        // Reads from system property (-Dspring.profiles.active) or env var (SPRING_PROFILES_ACTIVE)
        return env.getProperty("spring.profiles.active", "stage");
    }
}
