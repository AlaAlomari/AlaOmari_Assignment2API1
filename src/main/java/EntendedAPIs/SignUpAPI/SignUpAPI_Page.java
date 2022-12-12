package EntendedAPIs.SignUpAPI;
import Base.BaseClass;
import io.restassured.response.Response;

public class SignUpAPI_Page extends BaseClass {


    String url = "https://sit.maf-dev.auth0.com/dbconnections/signup";
    SignUpAPI_Body signUpRequestBody = new SignUpAPI_Body();

    public Response SignUpPost(String EmailAddress, String Password) {
        baseURL(url);

        Response signUpResponse = httpRequest().when()
                .header("Content-Type", "application/json")
                .body(signUpRequestBody.requestBody(EmailAddress, Password)).post();

        return signUpResponse;
    }
}
