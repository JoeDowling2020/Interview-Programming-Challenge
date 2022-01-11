package imageMover;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Main class and point of entry for simple json formatting application
 */
public class Driver {

    /**
     * Main method for application
     * @param arg command line arguments
     * @throws JsonProcessingException
     */
    public static void main(String[] arg) throws JsonProcessingException {

        //The AWS Cognito object received
        String jsonSource = "{\n" +
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

        //Jackson mapper to process Json
        ObjectMapper mapper = new ObjectMapper();
        //Mapping the Json input
        Map<String, Object> inputMap = mapper.readValue(jsonSource, Map.class);
        //Second map to hold the correctly formatted data
        Map<String, Object> outputMap;
        outputMap = new HashMap<>();
        //Instantiate User Utils method
        UserUtils userUtils = new UserUtils();
        //Parse the attributes and assign the results to the output map
        outputMap = userUtils.parseAttributes(inputMap);
        //Printing the final map to the console
        System.out.println("Formatted Data: " + outputMap);
    }
}
