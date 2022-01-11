package imageMover;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class JsonManipulatorTest {


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




    @Test
    void parse() throws IOException {

        JsonNode node = JsonManipulator.parse(jsonSource);
        assertEquals(node.get("Username").asText(), "00d23c55-51b4-49e3-a1ba-8e9b2685ab70");

    }

    @Test
    void fromJson() throws IOException {

        JsonNode node = JsonManipulator.parse(response);
        FormattedCustomer pojo = JsonManipulator.fromJson(node, FormattedCustomer.class);
        assertEquals(pojo.getUsername(), "00d23c55-51b4-49e3-a1ba-8e9b2685ab70");
    }

    @Test
    void toJson() {
        FormattedCustomer pojo = new FormattedCustomer();
        pojo.setUsername("JamesPeach");

        JsonNode node = JsonManipulator.toJson(pojo);
        assertEquals(node.get("Username").asText(), "JamesPeach");
    }

    // The following tests are for the actual input from AWS

    @Test
    void parseInput() throws IOException {

        JsonNode node = JsonManipulator.parse(response);
        assertEquals(node.get("Username").asText(), "00d23c55-51b4-49e3-a1ba-8e9b2685ab70");

    }

    @Test
    void fromJsonInput() throws IOException {

        JsonNode node = JsonManipulator.parse(response);
        CustomerInput pojo = JsonManipulator.fromJson(node, CustomerInput.class);
        assertEquals(pojo.getUsername(), "00d23c55-51b4-49e3-a1ba-8e9b2685ab70");
    }

    @Test
    void toJsonInput() {
        CustomerInput pojo = new CustomerInput();
        pojo.setUsername("JamesPeach");

        JsonNode node = JsonManipulator.toJson(pojo);
        assertEquals(node.get("Username").asText(), "JamesPeach");
    }

//    @Test
//    void createObjectTest() throws IOException {
//        JsonNode node = JsonManipulator.parse(response);
//        CustomerInput upperPojo = JsonManipulator.fromJson(node, CustomerInput.class);
//        UserAttribute lowerPojo = JsonManipulator.fromJson(node, UserAttribute.class);
//
//        FormattedCustomer currentCustomer = new FormattedCustomer();
//
//        currentCustomer.setUsername(upperPojo.getUsername());
//        currentCustomer.setUserCreateDate(upperPojo.getUserCreateDate());
//        currentCustomer.setUserLastModifiedDate(upperPojo.getUserLastModifiedDate());
//        currentCustomer.setEnabled(upperPojo.getEnabled());
//        currentCustomer.setUserStatus(upperPojo.getUserStatus());
//
//    }

    @Test
    void nodeIterationTest() throws IOException {

        JsonNode root = JsonManipulator.parse(response);
        JsonNode items = root.at("/UserAttributes");
        List<UserAttribute> userAttributes = new ArrayList<>();

        if(items.isArray()) {


        }


    }

    @Test
    void mappingJsonTest() throws IOException {
//        JsonNode node = JsonManipulator.parse(jsonSource);
        ObjectMapper mapper = new ObjectMapper();
        try {

            // convert JSON string to Map
            Map<String, Object> map = mapper.readValue(jsonSource, Map.class);

            Map<String, Object> outputMap;
            outputMap = new HashMap<>();

//            for (String key : map.keySet()) {
//                System.out.println(key + ":" + map.get(key));
//            }
            String key = "UserAttributes";

            Object newMap = map.get(key);

            List newList = new ArrayList<>();

            newList = convertObjectToList(newMap);

            for (Object item : newList) {
                Map<String, Object> mapEntry = mapper.convertValue(item, Map.class);
                System.out.println("the item" + item);
                String mapKey = mapEntry.get("Name").toString();
                Object mapValue = mapEntry.get("Value");

                outputMap.put(mapKey, mapValue);
                System.out.println(mapKey);
                System.out.println("Map Value: " + mapValue);


            }

            System.out.println("Output map: " + outputMap);
            System.out.println(outputMap.remove("sub"));
            System.out.println("Output map: " + outputMap);

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static List<?> convertObjectToList(Object obj) {
        List<?> list = new ArrayList<>();
        if (obj.getClass().isArray()) {
            list = Arrays.asList((Object[])obj);
        } else if (obj instanceof Collection) {
            list = new ArrayList<>((Collection<?>)obj);
        }
        return list;
    }


}