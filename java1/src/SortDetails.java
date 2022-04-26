import java.util.Collections;

public class SortDetails {
    public static void sortStudentList(int sortParameter, int sortOrder) {
        final int FULL_NAME = 1;
        final int ROLL_NUMBER = 2;
        final int AGE = 3;
        final int ADDRESS = 4;


        switch (sortParameter) {
            case FULL_NAME:
                if (sortOrder == 1) {
                    sortOnFullNameIncreasing();
                } else {
                    sortOnFullNameDecreasing();
                }
                break;
            case ROLL_NUMBER:
                if (sortOrder == 1) {
                    sortOnRollIncreasing();
                } else {
                    sortOnRollDecreasing();
                }
                break;
            case AGE:
                if (sortOrder == 1) {
                    sortOnAgeIncreasing();
                } else {
                    sortOnAgeDecreasing();
                }
                break;
            case ADDRESS:
                if (sortOrder == 1) {
                    sortOnAddressIncreasing();
                } else {
                    sortOnAddressDecreasing();
                }
                break;
        }


    }

    private static void sortOnFullNameIncreasing() {
        Collections.sort(StudentList.getInstance().getStudentList(), (studentFirst, studentSecond) -> studentFirst.getFullName().compareTo(studentSecond.getFullName()));
    }

    private static void sortOnFullNameDecreasing() {
        Collections.sort(StudentList.getInstance().getStudentList(), (studentFirst, studentSecond) -> studentSecond.getFullName().compareTo(studentFirst.getFullName()));
    }

    private static void sortOnRollIncreasing() {
        Collections.sort(StudentList.getInstance().getStudentList(), (studentFirst, studentSecond) -> studentFirst.getRollNumber() - studentSecond.getRollNumber());
    }

    private static void sortOnRollDecreasing() {
        Collections.sort(StudentList.getInstance().getStudentList(), (studentFirst, studentSecond) -> studentSecond.getRollNumber() - studentFirst.getRollNumber());
    }

    private static void sortOnAgeIncreasing() {
        Collections.sort(StudentList.getInstance().getStudentList(), (studentFirst, studentSecond) -> studentFirst.getAge() - studentSecond.getAge());
    }

    private static void sortOnAgeDecreasing() {
        Collections.sort(StudentList.getInstance().getStudentList(), (studentFirst, studentSecond) -> studentSecond.getAge() - studentFirst.getAge());
    }

    private static void sortOnAddressIncreasing() {
        Collections.sort(StudentList.getInstance().getStudentList(), (studentFirst, studentSecond) -> studentFirst.getAddress().compareTo(studentSecond.getAddress()));
    }

    private static void sortOnAddressDecreasing() {
        Collections.sort(StudentList.getInstance().getStudentList(), (studentFirst, studentSecond) -> studentSecond.getAddress().compareTo(studentSecond.getAddress()));
    }

}
