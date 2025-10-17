package stepDefination;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.service.ExtentService;
import config.SpringConfig;
import io.cucumber.java.en.*;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringConfig.class)
@CucumberContextConfiguration
public class stepDefination {

    @Value("${spring.profiles.active}")
    private String springProfileActive;

    @Value("${api.key}")
    private String apiKey;

    @Given("the application context is loaded")
    public void contextLoads() {
        // Spring context loads automatically with @SpringBootTest
        ExtentReports extent = ExtentService.getInstance();
        extent.setSystemInfo("Spring Profile", System.getProperty("spring.profiles.active", "NOT_SET"));
        extent.setSystemInfo("API Key", System.getProperty("api.key", "NOT_SET"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("OS", System.getProperty("os.name"));


    }

    @When("I retrieve the value of {string}")
    public void retrieveValue(String key) {
        // No-op: values are injected via @Value
    }

    @Then("I should see the profile and key printed in the logs")
    public void printValues() {
        System.out.println("🌱 spring_profile_active: " + springProfileActive);
        System.out.println("🔐 api_key: " + apiKey);
    }
}