import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JacksonUsage {

    public static final String INPUT_FILE = "src/students.json";

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        TypeFactory typeFactory = TypeFactory.defaultInstance();
        try {
            InputStream input = new FileInputStream(INPUT_FILE);
            List<StudentDto> students = objectMapper.readValue(input, typeFactory.constructCollectionType(ArrayList.class, StudentDto.class));

            System.out.println("Student: " + students.get(0).getName() + ", Age: " + students.get(0).getAge() +
                    ", Course: " + students.get(0).getCourse());
            System.out.println("Student: " + students.get(1).getName() + ", Age: " + students.get(1).getAge() +
                    ", Course: " + students.get(1).getCourse());

            SortAndOutputStudents(students);
        } catch (FileNotFoundException ex) {
            System.out.println("File " + INPUT_FILE + " not found");
        } catch (JsonParseException ex) {
            System.out.println("Parse exception");
        } catch (IOException ex) {
            System.out.println("IO exception");
        }
    }

    public static void SortAndOutputStudents(List<StudentDto> students) {
        //before sort
        System.out.println();
        System.out.println("List is not sorted");
        for (StudentDto student : students) {
            System.out.println("Student: " + student.getName() + ", Age: " + student.getAge() +
                    ", Course: " + student.getCourse());
        }

        Collections.sort(students);

        System.out.println();
        System.out.println("List is sorted by dafault (Name then Age)");
        for (StudentDto student : students) {
            System.out.println("Student: " + student.getName() + ", Age: " + student.getAge() +
                    ", Course: " + student.getCourse());
        }

        Collections.sort(students, StudentDto.CourseNameComparator);

        System.out.println();
        System.out.println("List is sorted by Course then default sorting");
        for (StudentDto student : students) {
            System.out.println("Student: " + student.getName() + ", Age: " + student.getAge() +
                    ", Course: " + student.getCourse());
        }

    }
}
