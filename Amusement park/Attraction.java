import java.util.*;
import java.io.*;

public class Attraction {
  private static int attractionCounter;
  private String attractionID;
  private int ratePerMinute;
  private ArrayList<NormalRider> normalLine = new ArrayList<NormalRider>();
  private ArrayList<FastRider> fastLine = new ArrayList<FastRider>();
  private ArrayList<Rider> gotOnRide = new ArrayList<Rider>();

  public Attraction() {
    attractionID = "";
  }
  public Attraction(int rate) {
    setRatePerMinute(rate);
    setAttractionID();
  }
  public void setRatePerMinute(int rate) {
    ratePerMinute = rate;
  }
  public int getRatePerMinute() {
    return ratePerMinute;
  }
  public void setAttractionID() {
    attractionCounter += 1;
    attractionID = ("RIDE #" + attractionCounter );
  }
  public String getAttractionID() {
    return attractionID;
  }
  public void addRiderNormalLine(NormalRider newRider) {
    normalLine.add(newRider);
  }
  public void addRiderFastLine(FastRider newRider) {
    fastLine.add(newRider);
  }
  public NormalRider removeRiderNormalLine() { // remove first in line
    NormalRider finished = normalLine.get(0);
    normalLine.remove(0);
    return finished;
  }
  public FastRider removeRiderFastLine() { // remove first in line
    FastRider finished = fastLine.get(0);
    fastLine.remove(0);
    return finished;
  }
  public int getNormalLineSize() {
    return normalLine.size();
  }
  public int getFastLineSize() {
    return fastLine.size();
  }
  public void addGotOnRide(Rider newRider) {
    gotOnRide.add(newRider);
  }
  public Rider getGotOnRide(int index) { // get but dont remove
    return gotOnRide.get(index);
  }
  public int getGotOnRideSize() {
    return gotOnRide.size();
  }
}