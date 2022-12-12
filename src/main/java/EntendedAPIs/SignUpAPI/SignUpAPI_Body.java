package EntendedAPIs.SignUpAPI;

public class SignUpAPI_Body {

        public static String requestBody(String EmailAddress,String Password){
            String request="{\n" +
                    "    \"password\": \""+Password+"\",\n" +
                    "    \"username\": \"Ala AL-Omari\",\n" +
                    "    \"user_metadata\": {\n" +

                    "         \"firstName\": \"Ala\",\n" +
                    "         \"mobile\": \"+962786487830\",\n" +
                    "         \"lastName\": \"AL-Omari\",\n" +
                    "         \"dateOfBirth\": \"1996-04-11\",\n" +
                    "         \"title\": \"Miss\",\n" +
                    "         \"share_tc\": \"Yes\"\n" +

                    "    },\n" +
                    "    \"email\": \""+EmailAddress+"\",\n" +
                    "    \"connection\": \"Username-Password-Authentication\",\n" +
                    "    \"client_id\": \"2IGVUsTpid0NZhjaMUe77k6wERpZ0pbG\"\n" +

                    "}";
            return request;
        }
}
