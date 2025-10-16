package org.example.config;

import org.gradle.api.component.Component;

@Component
@ConfigurationProperties(prefix = "custom")
public class CustomProperties {
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}