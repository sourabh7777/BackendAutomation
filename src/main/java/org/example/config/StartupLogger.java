package org.example.config;



import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StartupLogger {

    private static final Logger logger = LoggerFactory.getLogger(StartupLogger.class);

    @Value("${spring_profile_active}")
    private String springProfile;

    @Value("${api_key}")
    private String apiKey;

    @PostConstruct
    public void logProperties() {
        logger.info("🌱 Custom Spring Profile Active: {}", springProfile);
        logger.info("🔐 API Key (masked): {}****", apiKey.substring(0, Math.min(4, apiKey.length())));
    }
}