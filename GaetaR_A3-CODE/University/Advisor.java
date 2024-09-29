import java.util.*;

public class Advisor extends UniversityMember {

  private String department;
  ArrayList<Student> advStudentList = new ArrayList<Student>();

  public Advisor() {
    department = "unknown";
  }
  public Advisor(String name, String depName) {
    super.setMemberName(name);
    setDepartment(depName);
  }
  public String getDepartment() {
    return department;
  }
  public void setDepartment(String name) {
    department = name;
  }
  public void addStudentToAdvisor(Student student) {
    advStudentList.add(student);
  }
  public Student getStudentFromAdvisor(int index) {
    return advStudentList.get(index);
  }
  public int getNumStudentsInAdvisorList() {
    return advStudentList.size();
  }
  public String toString() { 
    super.toString();
    return (super.toString() + "Department: " + department);
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Student)) {
      return false;
    }

    Student other = (Student) o;
    boolean equal = super.equals(other) && (this.year == other.year) && (this.studentNumber == other.studentNumber);

    return equal;

  }
}