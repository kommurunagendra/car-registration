package com.kommuru.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * The class is used to capture search page web elements and methods.
 *
 * @author Nagendra Kommuru
 */
public class SearchPage extends BasePage {

    @FindBy(id = "vrm-input")
    private WebElement inputText;
    @FindBy(css = "form  button")
    private WebElement submit;
    @FindBy(css = ".container a")
    private WebElement search;

    public SearchPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void searchOption() {
        search.click();
    }

    public CarRegistraionPage sendRegistraionNum(String number) {
        inputText.sendKeys(number);
        submit.click();
        return new CarRegistraionPage();
    }
}
