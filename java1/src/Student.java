import java.io.Serializable;
import java.util.Set;

enum Courses {
    A, B, C, D, E, F
};

public class Student implements Serializable {
    private final String fullName;
    private final String address;
    private final int age;
    private final int rollNumber;
    private final Set<Courses> coursesSet;

    Student(String fullName, String address, int age, int rollNumber, Set<Courses> coursesSet) {
        this.fullName = fullName;
        this.address = address;
        this.age = age;
        this.rollNumber = rollNumber;
        this.coursesSet = coursesSet;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public Set<Courses> getCoursesSet() {
        return coursesSet;
    }

    public String getAddress() {
        return address;
    }
}
