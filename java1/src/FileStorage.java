import java.io.*;
import java.util.List;

public class FileStorage {
    private static FileStorage instance = null;
    private final String FILE_NAME = "student_details.txt";
    private File studentDetailsFile = null;

    private FileStorage() {
            studentDetailsFile = new File(FILE_NAME);
    }


    public static FileStorage getInstance() {
        if (instance == null)
            instance = new FileStorage();
        return instance;
    }

    public File getStudentDetailsFile() {
        return studentDetailsFile;
    }

    public List<Student> readStudentDetailsFile() throws Exception {

        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Student> studentList = (List<Student>) objectInputStream.readObject();
        objectInputStream.close();
        return studentList;


    }

    public void writeInStudentDetailsFile() throws Exception {

        List<Student> studentList = StudentList.getInstance().getStudentList();
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(studentList);
        objectOutputStream.close();
    }

}

