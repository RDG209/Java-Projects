
public class Student extends UniversityMember {
  private Advisor advisor;
  String year;
  int studentNumber;
  static int IDNUMBER = 1000;

  public Student() {
    // does nothing?
  }

  public Student(String name, Advisor newAdvisor, String yearInput) {
    super(name);
    advisor = newAdvisor;
    year = yearInput;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String newYear) {
    year = newYear;
  }

  public int getStudentNumber() {
    return studentNumber;
  }

  public void setStudentNumber() {
    studentNumber = IDNUMBER;
    IDNUMBER += 1;
  }

  public Advisor getAdvisor() {
    return advisor;
  }

  public void setMemberName(Advisor newAdvisor) {
    advisor = newAdvisor;
  }

  public String toString() {
    super.toString();
    return (super.toString() + "Year: " + year + " StudentNumber: " + studentNumber);
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