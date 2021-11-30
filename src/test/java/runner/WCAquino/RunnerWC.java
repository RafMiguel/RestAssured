package runner.WCAquino;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources",
        glue = "steps",
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-report/WCAquino/report.html", "json:target/WCAquino/cucumber.json"}




)

public class RunnerWC {


}
