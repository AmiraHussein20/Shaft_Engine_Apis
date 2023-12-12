package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class signUpPage {
    SHAFT.GUI.WebDriver driver;
    private final By signUpText = By.xpath("//div[@class='signup-form']//h2");
    private final By enterName = By.name("name");
    private final By enterEmail = By.xpath("//input[@data-qa=\"signup-email\"]");
    private final By signUpButton = By.xpath("//button[@data-qa=\"signup-button\"]");

    public signUpPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public void assertOnSignUpText(String expectedResult) {
        driver.element().assertThat(signUpText).text().isEqualTo(expectedResult).perform();
    }

    public void enterInfoOFSignUpPage(String name, String email){
        driver.element().type(enterName,name);
        driver.element().type(enterEmail,email);
        driver.element().click(signUpButton);
    }
}
