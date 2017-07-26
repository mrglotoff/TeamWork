import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDto {

    private int id;
    private String name;
    private int age;
    private Student student;
    private int course;

    @JsonCreator
    public StudentDto(@JsonProperty("id") int id,
                      @JsonProperty("name") String name,
                      @JsonProperty("age") int age,
                      @JsonProperty("course") int course,
                      @JsonProperty("student") Student student) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.student = student;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course= course;
    }

}
