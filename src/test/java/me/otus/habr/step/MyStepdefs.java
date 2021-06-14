package me.otus.habr.step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


import me.otus.habr.page.MainPageWeb;
import me.otus.habr.service.Driver;
import me.otus.habr.service.MainPageService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class MyStepdefs {
    public static final Logger logger = LogManager.getLogger(MyStepdefs.class);

    private final MainPageService mainPageService;

    public MyStepdefs() {
        mainPageService = new MainPageService();
    }

    @Given("I am on the main page")
    public void iAmOnTheMainPage() {
        mainPageService.openPage();
    }

    private String postTitle;

    @When("I open {int} post")
    public void iOpenPost(int index) {
        postTitle = mainPageService.openPost(index);
     }

    @Then("I am on post page")
    public void iAmOnPostPage() {
       mainPageService.verify(postTitle);
    }

    @When("I search {string}")
    public void iSearch(String searchTerm) {
//        driver.findElement(By.xpath("//button[@id='search-form-btn']")).click();
//        driver.findElement(By.xpath("//input[@id='search-form-field']")).sendKeys(searchTerm, Keys.ENTER);
    }

    @Then("I am on result page with {string}")
    public void iAmOnResultPageWith(String searchTerm) {
//        assertThat(driver.getTitle(), containsString(searchTerm));
//        assertThat(driver.getCurrentUrl(), startsWith("https://habr.com/ru/search/?q=" + searchTerm));
    }
}
