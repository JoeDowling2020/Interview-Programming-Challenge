package imageMover;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestServiceClient {

    @Test
    public void testCustomerData() throws Exception {

        //Here AWS Cognito would be called in a real application instead the example file is use
        String response = "{\n" +
                "  \"Username\": \"00d23c55-51b4-49e3-a1ba-8e9b2685ab70\",\n" +
                "  \"EmailVerified\": true,\n" +
                "  \"Email\": \"sally@example.com\",\n" +
                "  \"DisplayName\": \"Slingshot, Sally\",\n" +
                "  \"GivenName\": \"Sally\",\n" +
                "  \"FamilyName\": \"Slingshot\",\n" +
                "  \"Tags\": [\n" +
                "    \"hockey\",\n" +
                "    \"basketball\",\n" +
                "    \"baseball\"\n" +
                "  ],\n" +
                "  \"UserCreateDate\": \"2021-04-13T15:50:42.802Z\",\n" +
                "  \"UserLastModifiedDate\": \"2021-04-13T15:50:51.671Z\",\n" +
                "  \"Enabled\": true,\n" +
                "  \"UserStatus\": \"CONFIRMED\"\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        FormattedCustomer formattedCustomer = mapper.readValue(response, FormattedCustomer.class);
        String expectedUsername = "00d23c55-51b4-49e3-a1ba-8e9b2685ab70";
        assertEquals(expectedUsername, formattedCustomer.getUsername());


    }


    @Test
    public void testCorrectCustomerData() throws Exception {

        String originalResponse =
                "{\n" +
                        "  \"Username\": \"00d23c55-51b4-49e3-a1ba-8e9b2685ab70\",\n" +
                        "  \"UserAttributes\": [\n" +
                        "    {\n" +
                        "      \"Name\": \"sub\",\n" +
                        "      \"Value\": \"00d23c55-51b4-49e3-a1ba-8e9b2685ab70\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"Name\": \"email_verified\",\n" +
                        "      \"Value\": \"true\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"Name\": \"email\",\n" +
                        "      \"Value\": \"sally@example.com\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"Name\": \"given_name\",\n" +
                        "      \"Value\": \"Sally\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"Name\": \"family_name\",\n" +
                        "      \"Value\": \"Slingshot\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"Name\": \"custom:tags\",\n" +
                        "      \"Value\": \"hockey,basketball,baseball\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"UserCreateDate\": \"2021-04-13T15:50:42.802Z\",\n" +
                        "  \"UserLastModifiedDate\": \"2021-04-13T15:50:51.671Z\",\n" +
                        "  \"Enabled\": true,\n" +
                        "  \"UserStatus\": \"CONFIRMED\"\n" +
                        "}";

        ObjectMapper mapper = new ObjectMapper();
        FormattedCustomer formattedCustomer = mapper.readValue(originalResponse, FormattedCustomer.class);
        String expectedUsername = "00d23c55-51b4-49e3-a1ba-8e9b2685ab70";
        assertEquals(expectedUsername, formattedCustomer.getUsername());


    }
}