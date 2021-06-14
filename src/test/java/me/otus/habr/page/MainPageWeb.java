package me.otus.habr.page;

import me.otus.habr.service.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class MainPageWeb implements MainPage{
    private final WebDriver driver;
    private final String url = "https://habr.com/ru/";

    public MainPageWeb() {
        driver = Driver.getDriver();
    }

    public void open(){driver.get(url);}

    public String openPost(int i){
        List<WebElement> posts =
                driver.findElements(By.cssSelector("h2[class = 'post__title'] > a[class='post__title_link']"));

        WebElement post = posts.get(i);
        String title = post.getText();

        post.click();
        return title;
    }

    public void verify(String postTitle){
        assertThat(driver.getTitle(), startsWith(postTitle));
        assertThat (driver.getCurrentUrl(), anyOf(is(startsWith("https://habr.com/ru/post/")), is(startsWith("https://habr.com/ru/company"))));
    }

    public WebElement getPost(int i){return driver.findElements(By.cssSelector("h2[class = 'post__title'] > a[class='post__title_link']")).get(i);}
}
