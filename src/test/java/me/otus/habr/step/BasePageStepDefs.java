package me.otus.habr.step;

import io.cucumber.java.After;
import me.otus.habr.service.Driver;

public class BasePageStepDefs {

    @After
    public void after(){
        Driver.clearDriver();
    }
}
