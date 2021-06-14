package me.otus.habr.step;

import io.cucumber.java.After;
import me.otus.habr.config.BeanConfigWeb;
import me.otus.habr.service.Driver;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = BeanConfigWeb.class)
public class BasePageStepDefs {


    public BasePageStepDefs() {
        System.setProperty("platform", "mobile");
    }

    @After
    public void after(){
        Driver.clearDriver();
    }
}
