import java.io.*;
import java.util.ArrayList;

public class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();
    private static final String DATA_FILE = "students.txt";

    public void addStudent(int rollNumber, String name, String grade) {
        students.add(new Student(rollNumber, name, grade));
        saveData();
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
        saveData();
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void saveData() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            outputStream.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            students = (ArrayList<Student>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            students = new ArrayList<>();
        }
    }

    public void initialize() {
        loadData();
    }
}
