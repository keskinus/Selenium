package guru99;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resources/guru99/login.feature",
	glue = {"guru99"}
)
public class LoginRunner {

}
