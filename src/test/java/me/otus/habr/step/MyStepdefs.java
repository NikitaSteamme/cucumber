package me.otus.habr.step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


import me.otus.habr.service.Driver;
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

    private WebDriver driver;

    public MyStepdefs() {
        driver = Driver.getDriver();
    }

    @Given("I am on the main page")
    public void iAmOnTheMainPage() {
        driver.get("https://habr.com/ru/");
    }

    private String postTitle;

    @When("I open {int} post")
    public void iOpenPost(int index) {
        System.out.println(index);

        List<WebElement> posts =
                driver.findElements(By.cssSelector("h2[class = 'post__title'] > a[class='post__title_link']"));

        WebElement post = posts.get(index - 1);
        postTitle = post.getText();
        logger.info(postTitle);
        post.click();

    }

    @Then("I am on post page")
    public void iAmOnPostPage() {
        assertThat(driver.getTitle(), startsWith(postTitle));
        assertThat (driver.getCurrentUrl(), anyOf(is(startsWith("https://habr.com/ru/post/")), is(startsWith("https://habr.com/ru/company"))));
    }

    @When("I search {string}")
    public void iSearch(String searchTerm) {
        driver.findElement(By.xpath("//button[@id='search-form-btn']")).click();
        driver.findElement(By.xpath("//input[@id='search-form-field']")).sendKeys(searchTerm, Keys.ENTER);
    }

    @Then("I am on result page with {string}")
    public void iAmOnResultPageWith(String searchTerm) {
        assertThat(driver.getTitle(), containsString(searchTerm));
        assertThat(driver.getCurrentUrl(), startsWith("https://habr.com/ru/search/?q=" + searchTerm));
    }
}
