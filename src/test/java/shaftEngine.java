import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.homePage;
import pages.signUpPage;
import pages.userInfoPage;


    public class shaftEngine{
        private signUpPage signpage;
        private userInfoPage userinfo;
        private homePage homepage;
        SHAFT.GUI.WebDriver driver;
        SHAFT.TestData.JSON testData;

        @BeforeClass
        public void beforeClass() {
            testData = new SHAFT.TestData.JSON("src/test/resources/Test Data/TestData.json");
        }

        @BeforeMethod
        public void beforeMethod() {
            driver = new SHAFT.GUI.WebDriver();
            signpage = new signUpPage(driver);
            userinfo = new userInfoPage(driver);
            homepage = new homePage(driver);
        }
        @Test
        public void CreateUser() {
            homepage.navigateToAutomationHomePageUrl();
            homepage.navigateToSignUpPage();
            signpage.assertOnSignUpText(testData.getTestData("testDataExpectedSignUpText"));
            signpage.enterInfoOFSignUpPage(testData.getTestData("testDataName"),testData.getTestData("testDataMail")+System.currentTimeMillis()+"@gizasystems.com");
            userinfo.enterAccountInfo(testData.getTestData("testDataPass"),testData.getTestData("testDataDay"),testData.getTestData("testDataMonth"),testData.getTestData("testDataYear"));
            userinfo.enterAddressInfo(testData.getTestData("testDataFirstName"),testData.getTestData("testDataLastName"),testData.getTestData("testDataCompany"),testData.getTestData("testDataAddress1"),testData.getTestData("testDataAddress2"),testData.getTestData("testDatacountry"),testData.getTestData("testDataState"),testData.getTestData("testDataCity"),testData.getTestData("testDataZipCode"),testData.getTestData("testDataMobile"));
            userinfo.assertAccountCreated(testData.getTestData("testDataCreateAccountText"));
        }
}
