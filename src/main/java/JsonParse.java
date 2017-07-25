import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.io.IOException;


class JsonParser {
    public static void main(String args[]) {

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

        //map json to student

        try {
            Student student = mapper.readValue(jsonString, Student.class);

            System.out.println(student);

            mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
            jsonString = mapper.writeValueAsString(student);

            System.out.println(jsonString);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


