package apis.restfulbooker.objects;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;

public class ApisBooking {
    private SHAFT.API api;
    private static final String createbooking_servicename = "/booking";
    
    public ApisBooking(SHAFT.API api) {
        this.api = api;
    }
    public void createBooking(String firstname,String lastname,String additionalneeds){
        String createbookingbody = """
                {
                    "firstname" : "{FIRSTNAME}",
                    "lastname" : "{LASTNAME}",
                    "totalprice" : 111,
                    "depositpaid" : true,
                    "bookingdates" : {
                        "checkin" : "2023-11-01",
                        "checkout" : "2024-01-01"
                    },
                    "additionalneeds" : "{ADDITIONAL_NEEDS}"
                }
            """
                .replace("{FIRSTNAME}",firstname)
                .replace("{LASTNAME}",lastname)
                .replace("{ADDITIONAL_NEEDS}", additionalneeds);

        api.post(createbooking_servicename).
                setContentType(ContentType.JSON)
                .setRequestBody(createbookingbody)
                .setTargetStatusCode(Apis.SUCCESS).perform();
        api.getResponseJSONValue("bookingid");

    }

    public String getBookingIDS(String firstname, String lastname){
        api.get(createbooking_servicename)
                .setUrlArguments("firstname"+firstname+"&lastname"+lastname)
                .setTargetStatusCode(Apis.SUCCESS).perform();
        return api.getResponseJSONValue("$[0].bookingid");
    }
    public void deleteBooking(String firstname,String lastname ) {
        String ID = getBookingIDS( firstname,  lastname);
        api.delete("/booking/"+ID)
                .addHeader("Cookie","token="+Apis.token)
                .setTargetStatusCode(Apis.SUCCESS_DELETE)
                .perform();
    }

    public void validateThatBookingCreated(String expectedfirstname,String expectedlastname,String expectedAdditionalNeeds){
        api.verifyThatResponse().extractedJsonValue("booking.additionalneeds").isEqualTo("Breakfast").perform();
        api.verifyThatResponse().extractedJsonValue("booking.lastname").isEqualTo("Hisham").perform();
        api.verifyThatResponse().extractedJsonValue("booking.additionalneeds").isEqualTo(expectedAdditionalNeeds).perform();
        api.verifyThatResponse().body().contains("\"bookingid\":").perform();

    }
    public void validateThatTheBookingDeleted(){
        api.assertThatResponse().body().isEqualTo("Created").perform();
    }
}
