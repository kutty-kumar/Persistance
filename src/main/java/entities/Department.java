package entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table(name = "DEPARTMENT")
@IdClass(DepartmentCompositeKey.class)
public class Department {

  @Id
  @Column(name = "DEPT_ID")
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long id;

  @Id
  @Column(name = "DEPT_NAME")
  private String name;

  @Embedded
  private Address address;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @OneToMany(mappedBy = "department")
  private List<Employee> employees;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }
}
