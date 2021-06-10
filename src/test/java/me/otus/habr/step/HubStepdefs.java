package me.otus.habr.step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HubStepdefs {
    public static final Logger logger = LogManager.getLogger(HubStepdefs.class);
    private final WebDriver driver;
    String hubName;

    public HubStepdefs() {
        BasicConfigurator.configure();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Given("I am on hub page")
    public void iAmOnHubPage() {
        driver.get("https://habr.com/ru/hubs/");
    }

    By locator = By.cssSelector("#hubs .list-snippet_title-link");

    @When("I search hub {string}")
    public void iSearchHub(String hubName) {
        this.hubName = hubName;
        driver.findElement(By.cssSelector("input[class='search-field__input search-field__input_suggest']")).sendKeys(hubName);
        driver.findElement(By.cssSelector("input[class='search-field__input search-field__input_suggest']")).sendKeys(Keys.ENTER);
        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBe(locator, hubName));


    }

    @And("choose found hub")
    public void chooseFoundHub() {
    }

    @And("each post has hub lable {string}")
    public void eachPostHasHubLable(String arg0) {
    }
}
