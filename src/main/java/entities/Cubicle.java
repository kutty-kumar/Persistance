package entities;

import javax.persistence.Embeddable;

@Embeddable
public class Cubicle {
  private String cubicleNumber;
  private int floorNumber;


  public String getCubicleNumber() {
    return cubicleNumber;
  }

  public void setCubicleNumber(String cubicleNumber) {
    this.cubicleNumber = cubicleNumber;
  }

  public int getFloorNumber() {
    return floorNumber;
  }

  public void setFloorNumber(int floorNumber) {
    this.floorNumber = floorNumber;
  }

}
