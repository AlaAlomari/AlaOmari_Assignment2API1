import Base.BaseClass;
import EntendedAPIs.MemberDetailsPage.MemberDetailsHeaderPage;
import EntendedAPIs.LoginAPI.LoginPage;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import EntendedAPIs.SignUpAPI.SignUpAPI_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskTest extends BaseClass {
    //-------------------SignUp----------
    SignUpAPI_Page SignUpPage = new SignUpAPI_Page();
    Response SignUpResponse;
   //-------------------Login------------
    LoginPage loginPage = new LoginPage();
    Response loginResponse;
    // ----------------memberdetails-----
    MemberDetailsHeaderPage memberdetailsheaderpage = new MemberDetailsHeaderPage();
    Response memberDetails;
    // ----------------VARs--------------
    String EmailAddress = "Ala" + Math.floor(Math.random() * 1000) + "@yahoo.com";
   String Password = "Test@123";
    String Email;
    String TokenValue;
    String FirstName;
    String X_APIKey="GfqP7b2I99sUMkbxGEk5Xk56RscaWRuo";

    // ----------------TCs----------------

    @Test(description = "Validate the Success Status code For the SignUp Page & Saving the email address value ", priority = 1)
    public void checkCreateNewMember () {
        //check the status code:
        SignUpResponse = SignUpPage.SignUpPost(EmailAddress,Password);
        Assert.assertEquals(SignUpResponse.getStatusCode(), 200);
        //check the email from the response:
        JsonPath jsonPathEvaluators = SignUpResponse.jsonPath();
         Email = jsonPathEvaluators.get("email").toString();
        System.out.println("Email Address From the Response:"+Email);
        FirstName = jsonPathEvaluators.get("user_metadata.firstName").toString();
        System.out.println(FirstName);
    }

    @Test(description = "Validate the Success Status code For the SignUp Page & Saving the Token value ", priority = 2)
    public void CheckLogin () {
        //check the status code:
        //Here we will use the email from the signup , Email:
        loginResponse = loginPage.loginPost(Email, Password);
        loginResponse.prettyPrint();
        Assert.assertEquals(loginResponse.getStatusCode(), 200);
        //check the Token from the response:
        JsonPath jsonPathEvaluators = loginResponse.jsonPath();
         TokenValue = "Bearer" +" "+ jsonPathEvaluators.get("access_token").toString();
        System.out.println(TokenValue);
    }

    @Test(description = "Validate the Get member details API", priority = 3)
    public void CheckMemberDetails () {
        //check the status code:
        memberDetails = memberdetailsheaderpage.GetMemberDetails(TokenValue,X_APIKey);
        memberDetails.prettyPrint();
        Assert.assertEquals(memberDetails.getStatusCode(), 200);

        JsonPath jsonPathEvaluators = memberDetails.jsonPath();
      //Validate that the FirstName value is the same as the FirstName value that was used with the Signup API:
        Assert.assertEquals(FirstName,jsonPathEvaluators.get("first_name").toString());
      //Validate that the Email value is the same as the email value that was used with the Signup API:
        Assert.assertEquals(Email,jsonPathEvaluators.get("email_address").toString());
     //Validate that the Tier value equals "BASE":
        Assert.assertEquals("BASE",jsonPathEvaluators.get("tier").toString());
     //Validate that the sw_onboarding value equals false:
        Assert.assertEquals("false",jsonPathEvaluators.get("extra_data.sw_onboarding").toString());
    }

}
