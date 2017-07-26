import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


class JsonParser {
    public static void main(String args[]) {

        try {
            String content = new Scanner(new File("filename"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = ;


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


