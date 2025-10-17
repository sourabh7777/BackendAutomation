package stepDefination;
import io.cucumber.java.en.*;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest
public class stepDefination {

    @Value("${SPRING_PROFILE_ACTIVE}")
    private String springProfileActive;

    @Value("${API_KEY}")
    private String apiKey;

    @Given("the application context is loaded")
    public void contextLoads() {
        // Spring context loads automatically with @SpringBootTest
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