import java.util.*;

public class Worker implements Comparable<Worker> {
  private int id;
  private String name;
  private Integer salary;
  private String jobTitle;

  public Worker(int newID, String newName, Integer newSalary, String newTitle) {
    setID(newID);
    setName(newName);
    setSalary(newSalary);
    setJobTitle(newTitle);
  }

  public int compareTo(Worker other) {
    return Integer.compare(other.salary, this.salary);
  }
  public String toString() {
    return String.format("ID: %s | Name: %s | Salary: %s | Job Title: %s |", id, name, salary, jobTitle);
  }
  
  public void setID(int newID) {
    id = newID;
  }
  public int getID() {
    return id;
  }
  public void setName(String newName) {
    name = newName;
  }
  public String getName() {
    return name;
  }
  public void setSalary(Integer newSalary) {
    salary = newSalary;
  }
  public Integer getSalary() {
    return salary;
  }
  public void setJobTitle(String newTitle) {
    jobTitle = newTitle;
  }
  public String getJobTitle() {
    return jobTitle;
  }
}