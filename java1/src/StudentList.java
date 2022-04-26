import java.util.ArrayList;
import java.util.List;

public class StudentList {
    private static StudentList instance = null;
    private List<Student> studentList = new ArrayList<Student>();

    private StudentList() {
    }

    public static StudentList getInstance() {
        if (instance == null) instance = new StudentList();
        return instance;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void addToStudentList(Student student) throws ExistingRollException {

        for (Student studentInList : studentList) {
            if (student.getRollNumber() == studentInList.getRollNumber()) {
                throw new ExistingRollException("Existing roll exception");
            }

        }

        studentList.add(student);


    }

    public void removeFromStudentList(int rollNumber) throws RollNotExistException {
        boolean flag = false;
        for (Student student : studentList) {
            if (rollNumber == student.getRollNumber()) {
                studentList.remove(student);
                flag = true;
                return;
            }

        }

        if (!flag) throw new RollNotExistException("roll doesn't exist");


    }


}
