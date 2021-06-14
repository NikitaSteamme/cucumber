package me.otus.habr.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.DirtiesContext;

@Configuration
@ComponentScan("me.otus.habr")
@PropertySource("classpath:habr-web.properties")
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)

public class BeanConfigWeb {

    @Bean(value = "ff")
    public WebDriver driverServiceFf(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    @Bean
    public WebDriver driverServiceChrome(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
