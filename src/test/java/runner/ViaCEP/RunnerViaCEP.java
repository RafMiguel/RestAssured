package runner.ViaCEP;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features/ViaCEP",
        glue = "steps/ViaCEP",
        monochrome = false,
        plugin = {"pretty", "html:target/cucumber-report/ViaCEP/report.html", "json:target/cucumber-report/ViaCEP/cucumber.json"}




)

public class RunnerViaCEP {
}
