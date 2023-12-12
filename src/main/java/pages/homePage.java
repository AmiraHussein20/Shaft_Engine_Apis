package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
    SHAFT.GUI.WebDriver driver;

    String automationHomePageUrl="http://automationexercise.com";
    private final By signUpClick = By.xpath("//i[@class='fa fa-lock']");

    public homePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAutomationHomePageUrl() {
        driver.browser().navigateToURL(automationHomePageUrl);
    }
    public void navigateToSignUpPage(){
        driver.element().click(signUpClick);
    }
}
