import java.util.*;

public class Tasks {
    public static void addDetails() {

        String fullName = null, address;
        int age, rollNumber;
        Set<Courses> coursesSet = new HashSet<>();
        final int COURSES = 4;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter Full Name");
            try {
                fullName = sc.nextLine();
                System.out.println(fullName);
                Validations.validateName(fullName);
                break;
            } catch (EmptyStringException e) {
                System.out.println(e);
            } catch (InvalidNameSizeException e) {
                System.out.println(e);
            } catch (InvalidNameFormatException e) {
                System.out.println(e);
            }


        } while (true);


        do {
            System.out.println("Enter age");
            try {
                age = Integer.parseInt(sc.nextLine().replace("\n", ""));
                Validations.validateNumber(age);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e);
            } catch (InputMismatchException e) {
                System.out.println(e);
            } catch (InvalidNumberException e) {
                System.out.println(e);
            }

        } while (true);


        do {
            System.out.println("Enter address");
            try {
                address = sc.nextLine();
                Validations.validateString(address);
                break;
            } catch (EmptyStringException e) {
                System.out.println(e);
            }

        } while (true);


        do {
            System.out.println("Enter roll number");
            try {
                rollNumber = Integer.parseInt(sc.nextLine().replace("\n", ""));
                Validations.validateNumber(rollNumber);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e);
            } catch (InputMismatchException e) {
                System.out.println(e);
            } catch (InvalidNumberException e) {
                System.out.println(e);
            }


        } while (true);

        String course;
        do {
            if (coursesSet.size() == COURSES) break;
            System.out.println("Enter courses");
            try {
                course = sc.nextLine();
//                    Validations.validateCourse(course);
                coursesSet.add(Courses.valueOf(course));

            } catch (Exception e) {
                System.out.println("");
            }

        } while (true);

        Student student = new Student(fullName, address, age, rollNumber, coursesSet);

        try {
            StudentList.getInstance().addToStudentList(student);
        } catch (ExistingRollException e) {
            System.out.println(e);
        }


    }

    public static void displayDetails() {

        sortDisplayList();

        List<Student> studentList = StudentList.getInstance().getStudentList();
        for (Student student : studentList) {
            System.out.println(student.getFullName() + " " + student.getAge() + " " + student.getRollNumber() + " " + student.getRollNumber() + " " + student.getCoursesSet());
            System.out.println();
        }

    }

    private static void sortDisplayList() {
        int sortParameter;
        int sortOrder;
        final int SORT_PARAMETER_BEGIN = 1;
        final int SORT_PARAMETER_END = 4;
        final int SORT_ORDER_BEGIN = 1;
        final int SORT_ORDER_END = 2;
        Scanner sc = new Scanner(System.in);


        do {
            System.out.println("Enter parameter to sort on");
            try {
                sortParameter = Integer.parseInt(sc.nextLine().replace("\n", ""));
                Validations.validateNumber(sortParameter, SORT_PARAMETER_BEGIN, SORT_PARAMETER_END);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e);
            } catch (InputMismatchException e) {
                System.out.println(e);
            } catch (NumberOutOfRangeException e) {
                System.out.println(e);
            }
        } while (true);


        do {
            System.out.println("Enter order of sorting");
            try {
                sortOrder = Integer.parseInt(sc.nextLine().replace("\n", ""));
                Validations.validateNumber(sortOrder, SORT_ORDER_BEGIN, SORT_ORDER_END);
                break;

            } catch (NumberFormatException e) {
                System.out.println(e);
            } catch (InputMismatchException e) {
                System.out.println(e);
            } catch (NumberOutOfRangeException e) {
                System.out.println(e);
            }

        } while (true);

        SortDetails.sortStudentList(sortParameter, sortOrder);
    }

    public static void deleteDetails() {
        Scanner sc = new Scanner(System.in);
        List<Student> studentList = StudentList.getInstance().getStudentList();
        int rollNumber = 0;
        do {
            System.out.println("Enter roll number to delete");
            try {
                rollNumber = Integer.parseInt(sc.nextLine().replace("\n", ""));
                Validations.validateNumber(rollNumber);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e);
            } catch (InvalidNumberException e) {
                System.out.println(e);
            }

        } while (!true);

        try {
            StudentList.getInstance().removeFromStudentList(rollNumber);
        } catch (RollNotExistException e) {
            System.out.println(e);
        }


    }

    public static void saveDetails() {
        try {
            FileStorage.getInstance().writeInStudentDetailsFile();
        } catch (Exception e) {
            System.out.println("detail can't be saved");
        }


    }

    public static void exit() {
        System.out.println("Do you wanna save details?");
        Scanner sc = new Scanner(System.in);
        String saveOption = sc.nextLine();
        switch (saveOption) {
            case "yes":
                saveDetails();
                System.out.println("Exiting");
                break;
            default:
                System.out.println("Exiting");
        }
    }

    public static void initialiseStudentList() {
        try {
            FileStorage.getInstance().readStudentDetailsFile();
        } catch (Exception exception) {
            System.out.println("File can't be read");
        }
    }
}
