package runner.WCAquino;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features/WCAquino/",
        glue = "steps/WCAquino",
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-report/WCAquino/report.html", "json:target/cucumber-report/WCAquino/cucumber.json"}




)

public class RunnerWC {


}
