package stepDefination;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.service.ExtentService;
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
public class stepDefination {

    @Autowired
    private Environment env;

    @Before
    public void beforeScenario() {
        System.out.println("🌱 Profile: " + env.getProperty("spring.profiles.active", "NOT_SET"));
        System.out.println("🔐 API Key: " + env.getProperty("api.key", "NOT_SET"));
    }

    @Given("the application context is loaded")
    public void contextLoads() {
        ExtentReports extent = ExtentService.getInstance();
        String profile = env.getProperty("spring.profiles.active", "NOT_SET");
        String apiKey = env.getProperty("api.key", "NOT_SET");

        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Spring Profile", profile);
        extent.setSystemInfo("API Key", apiKey);
    }

    @Then("I should see the profile and key printed in the logs")
    public void printValues() {
        System.out.println("🌱 spring_profile_active: " + env.getProperty("spring.profiles.active", "NOT_SET"));
        System.out.println("🔐 api_key: " + env.getProperty("api.key", "NOT_SET"));
    }
}