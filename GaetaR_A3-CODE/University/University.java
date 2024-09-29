import java.util.*;
import java.io.*;

public class University {
  private String univName;
  ArrayList<Advisor> advList = new ArrayList<Advisor>();
  ArrayList<Student> freshmanStudList = new ArrayList<Student>();
  ArrayList<Student> sophmoreStudList = new ArrayList<Student>();
  ArrayList<Student> juniorStudList = new ArrayList<Student>();
  ArrayList<Student> seniorStudList = new ArrayList<Student>();

  Scanner keyboard = new Scanner(System.in);
  
  public University() throws FileNotFoundException {
    univName = "Unknown";
  }
  public University(String name) {
    setUniName(name);
  }
  public String getUniName() {
    return univName;
  }
  public void setUniName(String name) {
    univName = name;
  }

  public void hireAdvisors() throws FileNotFoundException  {
    System.out.print("Enter filename for the Advisor info: ");
    String fileName = keyboard.nextLine();
    File file = new File(fileName);

    Scanner scan = new Scanner(file);

    while (scan.hasNext()) {
      String advName = scan.nextLine();
      String advDep = scan.nextLine();

      Advisor newAdv = new Advisor(advName, advDep);
      
      advList.add(newAdv);
    }

    scan.close();
  }
  public void admitStudents() throws FileNotFoundException {
    System.out.print("Enter filename for the Student info: ");
    String fileName = keyboard.nextLine();
    File file = new File(fileName);

    Scanner scan = new Scanner(file);

    int advIndex = advList.size() -1;

    while (scan.hasNext()) {
      String stuName = scan.nextLine();
      String stuYear = scan.nextLine();

      if (stuYear.equalsIgnoreCase("freshman")) {
        Student newStudent = new Student(stuName, advList.get(advIndex), stuYear);
        freshmanStudList.add(newStudent);
        advList.get(advIndex).addStudentToAdvisor(newStudent);
      } else if (stuYear.equalsIgnoreCase("sophmore")) {
        Student newStudent = new Student(stuName, advList.get(advIndex), stuYear);
        sophmoreStudList.add(newStudent);
        advList.get(advIndex).addStudentToAdvisor(newStudent);
      } else if (stuYear.equalsIgnoreCase("junior")) {
        Student newStudent = new Student(stuName, advList.get(advIndex), stuYear);
        juniorStudList.add(newStudent);
        advList.get(advIndex).addStudentToAdvisor(newStudent);
      } else if (stuYear.equalsIgnoreCase("senior")) {
        Student newStudent = new Student(stuName, advList.get(advIndex), stuYear);
        seniorStudList.add(newStudent);
        advList.get(advIndex).addStudentToAdvisor(newStudent);
      } else {
        System.out.println("Invalid Year, Student Declined, Continueing to the next student...");
        continue;
      }

      

      advIndex = (advIndex + 1) % advList.size();  // Round-robin cycling
      
    }

    scan.close();
  }
  public void printUniversityCommunity() throws IOException {
    System.out.println("Enter the filename for the output file: ");
    String filename = keyboard.nextLine();

    PrintWriter writer = new PrintWriter(new FileWriter(filename));
    
    writer.println(univName + "'s Community of Advisors and Their students:");
    for (Advisor adv : advList) {
      writer.println(adv.toString());
      for (Student stud : adv.advStudentList) {
        writer.println(stud.toString());
      }
      writer.println("");
      
    }

    writer.println(univName + "'s List Of Students By Year");

    writer.println("\nFRESHMAN");
    for (Student fresh : freshmanStudList) { //freshman print ALL
      writer.println(fresh.toString());
    }
    writer.println("\nSOPHMORE");
    for (Student soph : sophmoreStudList) { // sophmore print ALL
      writer.println(soph.toString());
    }
    writer.println("\nJUNIOR");
    for (Student jun : juniorStudList) { // junior print ALL
      writer.println(jun.toString());
    }
    writer.println("\nSENIOR");
    for (Student sen : seniorStudList) { // senior print ALL
      writer.println(sen.toString());
    }

    writer.close();
  }
  
}