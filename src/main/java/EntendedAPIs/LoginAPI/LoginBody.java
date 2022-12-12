package EntendedAPIs.LoginAPI;

public class LoginBody{


    public static String requestBody(String EmailAddress,String Password){
            String request ="{\n" +
            "\"grant_type\":\"password\",\n" +
            "\"username\":\""+ EmailAddress +"\",\n" +
            "\"password\":\""+Password+"\",\n" +
            "\"audience\":\"https://sit.maf-dev.auth0.com/api/v2/\",\n" +
            "\"client_id\":\"l9DGyNKhON48e6BgTFAg17wWY78urJ4t\",\n" +
            "\"client_secret\":\"yl9xlvv9N35GpLYDxBp22HLFvPv4_RrtPQxFhznSV2C5xqUYWVWqXl7qwdt2gq2f\"\n" +
            "}";
        return request;
}}
