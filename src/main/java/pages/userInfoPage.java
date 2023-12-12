package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class userInfoPage {
    SHAFT.GUI.WebDriver driver;
    private final By enterGender = By.id("id_gender2");
    private final By enterPassword = By.id("password");
    private final By enterDays = By.id("days");
    private final By enterMonths = By.id("months");
    private final By selectYear = By.xpath("//option[@value=2021]");
    private final By newsLetter = By.id("newsletter");
    private final By selectOption = By.id("optin");
    private final By firstName = By.xpath("//input[@data-qa=\"first_name\"]");
    private final By lastName = By.xpath("//input[@data-qa=\"last_name\"]");
    private final By companyName = By.xpath("//input[@data-qa=\"company\"]");
    private final By address1 = By.xpath("//input[@data-qa=\"address\"]");
    private final By address2 = By.xpath("//input[@data-qa=\"address2\"]");
    private final By countryName = By.id("country");
    private final By enterState = By.id("state");
    private final By enterCity = By.id("city");
    private final By enterZipCode = By.id("zipcode");
    private final By mobileNumber = By.id("mobile_number");
    private final By createAccountText = By.xpath("//button[@data-qa=\"create-account\"]");
    private final By checkCreateAccountText = By.xpath("//h2[@data-qa=\"account-created\"]");

    public userInfoPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public void assertAccountCreated(String expectedData) {
        driver.element().assertThat(checkCreateAccountText).text().isEqualTo(expectedData).perform();
    }
    public void enterAccountInfo(String password, String day, String month, String year){
        driver.element().click(enterGender);
        driver.element().type(enterPassword,password);
        driver.element().select(enterDays,day);
        driver.element().select(enterMonths,month);
        driver.element().select(selectYear,year);
        driver.element().click(newsLetter);
        driver.element().click(selectOption);
    }
    public void enterAddressInfo(String firstname,String lastname,String company,String firstAddress,String secondAddress,String country,String stateName,String cityName,String zipcode,String mobile){
        driver.element().type(firstName,firstname);
        driver.element().type(lastName,lastname);
        driver.element().type(companyName,company);
        driver.element().type(address1,firstAddress);
        driver.element().type(address2,secondAddress);
        driver.element().select(countryName,country);
        driver.element().type(enterState,stateName);
        driver.element().type(enterCity,cityName);
        driver.element().type(enterZipCode,zipcode);
        driver.element().type(mobileNumber,mobile);
        driver.element().click(createAccountText);
    }

}
