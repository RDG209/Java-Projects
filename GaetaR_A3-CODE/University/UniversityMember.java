
public class UniversityMember {
  private String memberName;

  public UniversityMember() {
    memberName = "unknown";
  }
  public UniversityMember(String name) {
    setMemberName(name);
  }
  public String getMemberName() {
    return memberName;
  }
  public void setMemberName(String name) {
    memberName = name;
  }
  public String toString() { // instructions say to specifically 'print out member name'
    System.out.println(memberName);
    return ("Name: " + memberName);
  }
  public boolean equals(String otherName) {
    if (memberName.equals(otherName)) {
      return true;
    } else {
      return false;
    }
  }
}