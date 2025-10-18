package stepDefination;

import config.SpringConfig;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.cucumber.spring.CucumberContextConfiguration;
import io.cucumber.spring.ScenarioScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
@CucumberContextConfiguration
@SpringBootTest(classes = SpringConfig.class)
public class StepDefination {

    @Autowired
    private Environment env;

    private String activeProfile;
    private String apiKey;

    @Before
    public void beforeScenario() {
        // Read properties from Spring Environment
        activeProfile = env.getProperty("spring.profiles.active", "stage");
        apiKey = env.getProperty("api.key", "");

        // Print to logs for CI/CD debugging
        System.out.println(">>> Active Spring Profile: " + activeProfile);
        if (apiKey != null && !apiKey.isEmpty()) {
            System.out.println(">>> API Key starts with: " + apiKey.substring(0, Math.min(4, apiKey.length())) + "****");
        } else {
            System.out.println(">>> API Key is NOT set!");
        }
    }

    // Example step usage
    @Given("I have a valid API key")
    public void iHaveAValidApiKey() {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalStateException("API Key is missing in environment!");
        }
        // Use apiKey in your test logic
    }

    @Given("I am running with the correct profile")
    public void iAmRunningWithTheCorrectProfile() {
        if (!"stage".equalsIgnoreCase(activeProfile) && !"test".equalsIgnoreCase(activeProfile)) {
            throw new IllegalStateException("Unexpected profile: " + activeProfile);
        }
        // Use activeProfile in your test logic
    }
}
