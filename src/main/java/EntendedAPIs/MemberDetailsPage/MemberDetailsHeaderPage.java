package EntendedAPIs.MemberDetailsPage;

import Base.BaseClass;
import io.restassured.response.Response;

public class MemberDetailsHeaderPage extends BaseClass {
    String url = "https://maf-holding-dev.apigee.net/v1/gravity/dk-gravity-memberdetails";
    public Response GetMemberDetails(String token, String X_APIKey) {
        baseURL(url);
        Response GetMemberDetailsResponse = httpRequest().when().
                headers("x-api-key",X_APIKey,"Authorization",token).get();
        return GetMemberDetailsResponse;
    }}
