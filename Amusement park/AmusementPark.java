import java.util.*;
import java.io.*;

public class AmusementPark {
  private String parkName;
  private int numAttractions;
  private ArrayList<Attraction> attractionList = new ArrayList<Attraction>();

  public AmusementPark() {
    setParkName("");
  }
  public AmusementPark(String name, int numAttractions) {
    setParkName(name);
    setNumAttractions(numAttractions);
    createAttractions(numAttractions);
  }

  public void setParkName(String name) {
    parkName = name;
  }
  public String getParkName() {
    return parkName;
  }
  public void setNumAttractions(int num) {
    numAttractions = num;
  }
  public int getNumAttractions() {
    return numAttractions;
  }
  public void createAttractions(int num) {
    Random randy = new Random(9);

    for (int i = 0; i < num; i++) {
      int ratePerMinute = randy.nextInt(22,36);

      Attraction newAttraction = new Attraction(ratePerMinute);
      attractionList.add(newAttraction);
    }
  }
  public void runThePark(int minutes) {
    Random randyX = new Random(17);

    int initialRiders = 31*randyX.nextInt(5,15);

    for (int j = 0; j < initialRiders; j++) {
      Attraction current = attractionList.get(randyX.nextInt(0, numAttractions));

      if (j % 7 < 3) {
        FastRider newFast = new FastRider(0);
        current.addRiderFastLine(newFast);
      } else {
        NormalRider newRider = new NormalRider(0);
        current.addRiderNormalLine(newRider);
      }
    }
      
    for (int min = 1; min <= minutes; min++) {
      int newRiders = 55*randyX.nextInt(5,15);

      for (int k = 0; k < newRiders; k++) {
        Attraction randomRide = attractionList.get(randyX.nextInt(0, numAttractions));

        if (k % 7 < 3) {
          FastRider newFast = new FastRider(min);
          randomRide.addRiderFastLine(newFast);
        } else {
          NormalRider newRider = new NormalRider(min);
          randomRide.addRiderNormalLine(newRider);
        }
      }

      for (Attraction ride : attractionList) {
        int toBeProcessed = ride.getRatePerMinute();

        while (toBeProcessed > 0) {
          if (ride.getFastLineSize() > 0  && (toBeProcessed % 3 == 0 || ride.getNormalLineSize() > 0)) {
            FastRider removedRider = ride.removeRiderFastLine();
            removedRider.setEndOnlineTime(min);
            ride.addGotOnRide(removedRider); // instructions make it seem like I should use same rider?
            toBeProcessed -= 1;
          } else if (ride.getNormalLineSize() > 0) {
            NormalRider removedRider = ride.removeRiderNormalLine();
            removedRider.setEndOnlineTime(min);
            ride.addGotOnRide(removedRider); // instructions make it seem like I should use same rider?
            toBeProcessed -= 1;
          }
        }
      }
      
    }
    
  }
  public void printParkStatistics(PrintWriter writer) throws IOException {

    writer.println("The Statistics for " + parkName);
    writer.println("The Total Gate for Fast Riders is " + FastRider.getTotalGate());
    writer.println("The Total Gate for Fast Riders is " + NormalRider.getTotalGate());

    int counter = 1;
    
    for (Attraction ride : attractionList) {
      writer.println("The Number of Fast Riders still On Line For RIDE" + counter + " is " + ride.getFastLineSize());
      writer.println("The Number of Normal Riders still On Line For RIDE" + counter + " is " + ride.getNormalLineSize());
      counter += 1;
    }

    writer.printf("%-8s %-13s %-8s %-15s %-8s%n", 
      "ATTRACTION", "FAST RIDERS", "WAIT AVG", "NORMAL RIDERS", "WAIT AVG");
    writer.println("------------------------------------------------------------");

    counter = 1;
    for (Attraction ride : attractionList) {
      writer.printf("%-8s %-13d %-6.2f %-6d %-15.2f %-6d%n", 
          "RIDE" + counter, 
          ride.getFastLineSize(), 
          (60.0 / ride.getGotOnRideSize()) * 3, 
          ride.getNormalLineSize(), 
          60.0 / ride.getGotOnRideSize(), 
          ride.getGotOnRideSize()
      );
      counter += 1;
    }

    writer.close();
  }
}

