package Assignment4;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resources/assignment/login.feature",
	glue = {"Assignment4"}
)
public class LoginRunner {

}
