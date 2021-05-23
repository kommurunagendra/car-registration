package com.kommuru.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The class is used to capture registration page web elements and it's methods.
 *
 * @author Nagendra Kommuru
 */
public class CarRegistraionPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[5]/div[1]/div/span/div[2]/dl[1]/dd")
    private WebElement regNumber;
    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[5]/div[1]/div/span/div[2]/dl[2]/dd")
    private WebElement make;
    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[5]/div[1]/div/span/div[2]/dl[3]/dd")
    private WebElement model;
    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[5]/div[1]/div/span/div[2]/dl[4]/dd")
    private WebElement colour;
    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[5]/div[1]/div/span/div[2]/dl[5]/dd")
    private WebElement year;

    public CarRegistraionPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public String getRegistrionNumber() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(regNumber));
        return regNumber.getText();
    }

    public String getMake() {
        return make.getText();
    }

    public String getModel() {
        return model.getText();
    }

    public String getColour() {
        return colour.getText();
    }

    public String getYear() {
        return year.getText();
    }

}
