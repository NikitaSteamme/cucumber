package me.otus.habr;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber/html", "json:target/cucumber/json/cucumber"},
        monochrome = true,
        features = "src/test/resources/feature",
        glue = {"me.otus.habr"},
        publish = true
)
public class CucumberRunTest {
}
