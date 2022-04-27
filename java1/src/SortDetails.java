import java.util.Collections;
import java.util.Comparator;

public class SortDetails {
    public static void sortStudentList(int sortParameter, int sortOrder) {
        final int FULL_NAME = 1;
        final int ROLL_NUMBER = 2;
        final int AGE = 3;
        final int ADDRESS = 4;


        switch (sortParameter) {
            case FULL_NAME:
                Collections.sort(StudentList.getInstance().getStudentList(), new SortOnFullName(sortOrder));
                break;
            case ROLL_NUMBER:
                Collections.sort(StudentList.getInstance().getStudentList(), new SortOnRoll(sortOrder));
                break;
            case AGE:
                Collections.sort(StudentList.getInstance().getStudentList(), new SortOnAge(sortOrder));
                break;
            case ADDRESS:
                Collections.sort(StudentList.getInstance().getStudentList(), new SortOnAddress(sortOrder));
                break;
        }


    }
}

class SortOnFullName implements Comparator<Student> {
    int order;
    SortOnFullName(int order){this.order=order;};
    public int compare(Student a, Student b)
    {
        return order==1? a.getFullName().compareTo(b.getFullName()):b.getFullName().compareTo(a.getFullName());
    }
}
class SortOnRoll implements Comparator<Student> {
    int order;
    SortOnRoll(int order){this.order=order;};
    public int compare(Student a, Student b)
    {
      return   order==1?a.getRollNumber() - b.getRollNumber(): b.getRollNumber()-a.getRollNumber();
    }
}
class SortOnAge implements Comparator<Student> {
    int order;
    SortOnAge(int order){this.order=order;};
    public int compare(Student a, Student b)
    {
        return order==1? a.getAge()-b.getAge():b.getAge()-a.getAge();
    }
}
class SortOnAddress implements Comparator<Student> {
    int order;
    SortOnAddress(int order){this.order=order;};
    public int compare(Student a, Student b)
    {
        return order==1? a.getAddress().compareTo(b.getAddress()):b.getAddress().compareTo(a.getAddress());
    }
}
