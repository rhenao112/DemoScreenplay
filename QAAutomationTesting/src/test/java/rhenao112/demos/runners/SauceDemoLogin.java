package rhenao112.demos.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/sauce_demo_login.feature",
        glue = {
                "rhenao112.demos.steps",
                "rhenao112.demos.hooks"
        },
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = "pretty"
)

public class SauceDemoLogin {

}