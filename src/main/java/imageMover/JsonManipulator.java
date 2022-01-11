package imageMover;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

/**
 * Class contains methods used to manipulate the Json into the correct format
 * Used for converting to Title Case, converting true/false from string to boolean,
 * removing prefixes and converting objects to lists. Other unused functionality was added
 * at the projects creation but were not used.
 */
public class JsonManipulator {

    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper() {

        return new ObjectMapper();
    }

    /**
     * Method to parse Json to JsonNode
     * @param src String the Json
     * @return The mapped object
     * @throws IOException
     */
    public static JsonNode parse(String src) throws IOException {

        return objectMapper.readTree(src);
    }

    /**
     * Method to JSON data mapped to pojo
     * @param node the JsonNode
     * @param clazz the class we are mapping to
     * @param <A> They class type
     * @return the mapped Json
     * @throws JsonProcessingException
     */
    public static <A> A fromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException {

        return objectMapper.treeToValue(node, clazz);
    }

    /**
     * Method to convert java object back to Json
     * @param a the Java object
     * @return the Json object
     */
    public static JsonNode toJson(Object a) {

        return objectMapper.valueToTree(a);
    }

    /**
     * Method to convert strings to Title Case
     * @param input unformatted input
     * @return string in Title Case
     */
    public static String TitleCase(String input) {

        // checking if there is content in the passed variable
        if (input == null || input.isEmpty()) {
            return input;
        }
        //initializing string builder
        StringBuilder converted = new StringBuilder();
        //Removing underscores and replacing them with space so following code will capitalise what it needs to
        input = input.replaceAll("_", " ").toLowerCase();

        boolean convertNext = true;
        for (char ch : input.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                convertNext = true;
            } else if (convertNext) {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            } else {
                ch = Character.toLowerCase(ch);
            }
            converted.append(ch);
        }
        return converted.toString();

    }

    /**
     * Method to remove prefixes from string
     * @param input input string
     * @return string with everything before the : removed (if one exists)
     */
    public static String RemovePrefixes(String input) {

        String prefixRemoved = input.substring(input.indexOf(":")+1);

        prefixRemoved.trim();

        return prefixRemoved;
    }

    /**
     * Method to convert strings to boolean data type
     * @param input a string containing a boolean
     * @return the boolean
     */
    public static Boolean ConvertToBoolean(String input) {

        boolean booleanItem = Boolean.parseBoolean(input);

        return booleanItem;
    }

    /**
     * Method to convert objects to lists so they can be iterated though
     * @param obj incoming java object
     * @return the object converted to list
     */
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
