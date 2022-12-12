package EntendedAPIs.LoginAPI;

import Base.BaseClass;
import io.restassured.response.Response;

public class LoginPage extends BaseClass {
    String url="https://sit.maf-dev.auth0.com/oauth/token";
    LoginBody  loginRequestBody= new LoginBody();
    public Response loginPost(String EmailAddress, String Password){

        baseURL(url);

        Response loginResponse = httpRequest().when()
                .header("Content-Type","application/json")
                .body(loginRequestBody.requestBody(EmailAddress,Password)).post();

        return loginResponse;
    }
}
