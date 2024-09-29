import java.util.*;
import java.io.*;

// CREATE NEW UNIVERSITY DRIVER CLASS
public class Main {
  public static void main(String[] args) throws FileNotFoundException, IOException {

    Scanner keyboard = new Scanner(System.in);

    System.out.print("Enter the name of a university: ");
    String uniName = keyboard.nextLine();

    University newUni = new University(uniName);

    newUni.hireAdvisors();
    newUni.admitStudents();
    newUni.printUniversityCommunity();
    
  }

  
}