import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JacksonUsage {
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        InputStream input = new FileInputStream("src/students.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper
                .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        TypeFactory typeFactory = TypeFactory.defaultInstance();
        List<StudentDto> students = objectMapper.readValue(input,
                typeFactory.constructCollectionType(
                        ArrayList.class, StudentDto.class));

        System.out.println("Student: " + students.get(0).getName() + ", Age: " + students.get(0).getAge()+
                ", Course: " + students.get(0).getCourse());
        System.out.println("Student: " + students.get(1).getName() + ", Age: " + students.get(1).getAge() +
                ", Course: " + students.get(1).getCourse());
    }
}
