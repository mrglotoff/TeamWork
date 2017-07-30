import java.util.Comparator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDto implements Comparable<StudentDto> {

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

	
    public int compareTo(StudentDto sd) {
		int compareisionByName = this.name.compareTo(sd.name);

	    if( compareisionByName != 0 )
	    {
	        //sort by name
	        return compareisionByName;
	    }
	    else
	    {
	        //name equal, sort by age
	        //return this.age.compareTo(sd.age);
	    	 return this.age < sd.age ? -1 : this.age == sd.age ? 0 : 1;
	    }
	}
    
    public static Comparator<StudentDto> CourseNameComparator = new Comparator<StudentDto>() {

    	public int compare(StudentDto student1, StudentDto student2) {
    		
    		
    		int student1Course = student1.getCourse();
    		int student2Course = student2.getCourse();
    		
    		int compareisionByCourse = student1Course < student2Course ? -1 : student1Course == student2Course ? 0 : 1;

    		if( compareisionByCourse != 0 )
    	    {
    	        //sort by name
    	        return compareisionByCourse;
    	    }
    	    else
    	    {
    	        //name equal, sort by age
    	        return student1.compareTo(student2);
    	    }
    	}
    };

}
