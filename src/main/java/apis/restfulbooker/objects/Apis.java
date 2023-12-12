package apis.restfulbooker.objects;

import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;

public class Apis {
    public static String token;
   private SHAFT.API api;
    public Apis(SHAFT.API api) {
        this.api = api;
    }

    public  static String baseUrl=System.getProperty("baseUrl");
    ////Status Codes
    public static final int SUCCESS = 200;
    public static final int SUCCESS_DELETE = 201;
    private static final String authentication_servicename = "/auth";
    public static void login(SHAFT.API api ,String username,String password){
        String tokenbody = """
                {
                    "username" : "{USERNAME}",
                    "password" : "{PASSWORD}"
                    }
                """
                .replace("{USERNAME}",username)
                .replace("{PASSWORD}",password);
        api.post(authentication_servicename)
                .setContentType(ContentType.JSON)
                .setRequestBody(tokenbody)
                .setTargetStatusCode(Apis.SUCCESS).
                perform();
        api.assertThatResponse().body().contains("\"token\":").perform();
        token = api.getResponseJSONValue("token");
        api.addHeader("Cookie","token="+token);
    }
}
