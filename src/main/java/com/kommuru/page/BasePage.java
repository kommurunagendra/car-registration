package com.kommuru.page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * The class is a base page and used for initializing browser and closing the browser
 *
 * @author Nagendra Kommuru
 */
public class BasePage {
    public static WebDriver driver;
    public static Properties props;

    public BasePage() {
        props = new Properties();
        try {
            ClassLoader classLoader = BasePage.class.getClassLoader();
            FileInputStream fileInputStream = new FileInputStream(new File(classLoader.getResource("config.properties").getFile()).getAbsolutePath());
            props.load(fileInputStream);
        } catch (Exception e) {
            e.getMessage();
        }

    }

    public static void initializeBrowser() {
        if (props.getProperty("browserName").equalsIgnoreCase("CHROME")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(props.getProperty("baseUrl"));
    }

    public static void close() {
        driver.quit();
    }
}
