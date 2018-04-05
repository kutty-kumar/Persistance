package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "PARKING_SPACE")
public class ParkingSpace {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "PARKING_SPACE_ID")
  private Long id;

  @Column(name = "PARKING_LOCATION_NUMBER")
  private String locationNumber;

  @OneToOne(mappedBy = "parkingSpace")
  private Employee employee;

  public String getLocationNumber() {
    return locationNumber;
  }

  public void setLocationNumber(String locationNumber) {
    this.locationNumber = locationNumber;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

}
