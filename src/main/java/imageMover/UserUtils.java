package imageMover;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;


final class UserUtils {

    /**
     * Method to parse through Json calling methods to manipulate the data
     * and format it use with ImageMover software
     * @param user the incoming cognito user object from AWS
     * @return outputmap the formatted data
     */
    public static Map<String, Object> parseAttributes(Map<String, Object> user) {

        // Insert your code here.
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> outputMap;
        //Grabbing the nested array
        String key = "UserAttributes";
        Object newMap = user.get(key);
        // Removing the no longer needed array and adding everything else to the final map
        user.remove("UserAttributes");
        outputMap = user;
        //Declaring list to make java objects iterable
        List nestedList;
        //Converting to said list
        nestedList = JsonManipulator.convertObjectToList(newMap);
        //looping through the list
        for (Object item : nestedList) {
            Map<String, Object> mapEntry = mapper.convertValue(item, Map.class);
            //assign the name fields to the map key
            String mapKey = mapEntry.get("Name").toString();
            //assign the value field to the map value
            Object mapValue = mapEntry.get("Value");
            //removing underscores prior to calling Title Case Method
            mapKey.replaceAll("_", " ");
            //Making everything lowercase for the boolean check method call
            mapValue = mapValue.toString().toLowerCase();
            //Checking if string contains boolean before calling the boolean conversion method
            if (mapValue.equals("true") | mapValue.equals("false")) {
                JsonManipulator.ConvertToBoolean(mapValue.toString());
            }
            //Calling multiple manipulation methods to format the list
            mapKey = JsonManipulator.RemovePrefixes(mapKey);
            mapKey = JsonManipulator.TitleCase(mapKey);
            mapValue = JsonManipulator.TitleCase(mapValue.toString());
            //Placing formatted list data in the output map
            outputMap.put(mapKey, mapValue);
        }
        //Creating new field display name and populating it with data from the AWS cognito object
        String displayName = "DisplayName";
        Object displayValueOne = user.get("Family Name");
        Object displayValueTwo = user.get("Given Name");
        Object displayValue = displayValueOne.toString() + ", " + displayValueTwo.toString() + ",";
        //Adding it to the output map
        outputMap.put(displayName, displayValue);
        //Removing the sub attribute from the returned object
        outputMap.remove("Sub");
        //Finally, returning the object
        return outputMap;
    }

}