package apis.restfulbooker.tests;
import apis.restfulbooker.objects.Apis;
import apis.restfulbooker.objects.ApisBooking;
import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

    public class RestfulBookerApis {
        SHAFT.API api;
        private ApisBooking apisBooking;

        @BeforeClass
        public void beforeclass(){
            api = new SHAFT.API(Apis.baseUrl);
            Apis.login(api,"admin","password123");
            apisBooking = new ApisBooking(api);
        }

        ////Tests
        @Test(dependsOnMethods = {"createbookingtest","getBookingIdstest"})
        public void Deletetest(){
            apisBooking.deleteBooking("Amira","Hisham");
            apisBooking.validateThatTheBookingDeleted();
        }
        @Test
        public void createbookingtest(){
            apisBooking.createBooking("Amira","Hisham","Breakfast");
            apisBooking.validateThatBookingCreated("Amira","Hisham","Breakfast");
        }
        @Test
        public void getBookingIdstest(){
            apisBooking.getBookingIDS("Amira","Hisham");
        }
    }

