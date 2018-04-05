package entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "EMP_ID")
    private long id;

    @Column(name = "EMP_NAME")
    private String name;

    @Column(name = "EMP_SALARY")
    private long salary;

    @OneToOne
    @JoinColumn(name = "PARKING_SPACE_ID")
    private ParkingSpace parkingSpace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({@JoinColumn(name = "DEPT_ID"),@JoinColumn(name = "DEPT_NAME")})
    private Department department;

    @ElementCollection
    @CollectionTable(name = "EMP_CUBLICLES",joinColumns = @JoinColumn(name = "EMPLOYEE_ID"))
    @AttributeOverrides({@AttributeOverride(name = "cubicleNumber",column = @Column(name = "CUBICLE_NUMBER")),
                         @AttributeOverride(name = "floorNumber",column = @Column(name = "FLOOR"))})
    List<Cubicle> cubicles;


    @ManyToMany
    @JoinTable(name = "EMP_PROJECT",joinColumns = @JoinColumn(name = "EMP_ID"),inverseJoinColumns = @JoinColumn(name = "PROJECT_ID"))
    private List<Project> projects;

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Employee(){}

    public List<Cubicle> getCubicles() {
        return cubicles;
    }

    public void setCubicles(List<Cubicle> cubicles) {
        this.cubicles = cubicles;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;

    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee(long id){
        this.id=id;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
