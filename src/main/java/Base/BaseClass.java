package Base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseClass {


    public String baseURL(String url) {
        return RestAssured.baseURI = url;
    }

    public RequestSpecification httpRequest() {
        RequestSpecification httpRequest = RestAssured.given();
        return httpRequest;
    }
}
