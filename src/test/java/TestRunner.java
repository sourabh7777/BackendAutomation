

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",                // Path to your .feature files
        glue = {"stepDefination"},                     // Package containing step definitions
        plugin = {
                "pretty",                                            // Console output
                "html:target/cucumber-report.html",                  // HTML report
                "json:target/cucumber-report.json"                   // JSON report
        }
)
public class TestRunner {
}