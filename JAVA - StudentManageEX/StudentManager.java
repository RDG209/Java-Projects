import java.util.*;

public class StudentManager {
    private ArrayList<Student> studentList;

    public StudentManager() {
        this.studentList = new ArrayList<Student>();
    }

    public void addStudent(String name, int id, double gpa) {
        studentList.add(new Student(name, id, gpa));
    }

    public void deleteStudent(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
                return;
            }
        }
    }

    public Student searchStudentByName(String name) {
        for (Student student : studentList) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        System.out.println("Error, no student by that name.");
        return null;
    }

    public Student searchStudentById(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        System.out.println("Error, no student by that ID.");
        return null;
    }

    public void sortStudentsByGPA() {
        Collections.sort(studentList, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getGpa(), s1.getGpa());
            }
        });
    }

    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner keyboard = new Scanner(System.in);

        manager.addStudent("Bob", 1, 4.0);
        manager.addStudent("Shob", 2, 2.2);
        manager.addStudent("Cob", 3, 3.4);

        System.out.println("All Students:");
        manager.displayStudents();

        System.out.print("Enter the ID of the student you wish to find: ");
        int ID = keyboard.nextInt();
        System.out.println("\nSearching for student with ID " + ID + " :");
        Student foundStudent = manager.searchStudentById(ID);
        if (foundStudent != null) {
            System.out.println(foundStudent);
        } else {
            System.out.println("Student not found.");
        }

        manager.sortStudentsByGPA();
        System.out.println("\n\nAfter Sorting by GPA (Descending):");
        manager.displayStudents();

        System.out.print("Enter the ID of the student you wish to delete: ");
        ID = keyboard.nextInt();
        manager.deleteStudent(ID);
        System.out.println("\nAfter Deleting student with ID " + ID + " :");
        manager.displayStudents();
    }
}
