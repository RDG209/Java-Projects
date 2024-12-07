public class Student {
    private String name;
    private int id;
    private double gpa;

    public Student(String name, int id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    public int getId() {
        return id;
    }
    public void setId(int newId) {
        this.id = newId;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double newgpa) {
        this.gpa = newgpa;
    }
    public String toString() {
        return "Name: " + name + ", ID: " + id + ", GPA: " + gpa;
    }
}
