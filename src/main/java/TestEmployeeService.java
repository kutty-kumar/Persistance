import entities.Address;
import entities.Cubicle;
import entities.Department;
import entities.Employee;
import entities.ParkingSpace;
import entities.Project;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class TestEmployeeService {
    private static final Logger LOGGER = Logger.getLogger(TestEmployeeService.class);

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        if(emf!=null){
            EntityManager entityManager = emf.createEntityManager();
            entityManager.getTransaction().begin();

            Cubicle cubicle = new Cubicle();
            cubicle.setCubicleNumber("I28");
            cubicle.setFloorNumber(3);

            Cubicle cubicle1 = new Cubicle();
            cubicle1.setFloorNumber(1);
            cubicle1.setCubicleNumber("A08");
            List<Cubicle> cubicles = new ArrayList<>();
            cubicles.add(cubicle);
            cubicles.add(cubicle1);

            ParkingSpace parkingSpace = new ParkingSpace();
            parkingSpace.setLocationNumber("MEZANINE 10");
            entityManager.persist(parkingSpace);

            Address address = new Address();
            address.setBuildingNumber("#51");
            address.setStreet("7th Cross, SVG Layout, RKMN, DBC");
            address.setState("Karnataka");
            address.setCountry("India");
            address.setZipCode("543311");

            Department department = new Department();
            department.setName("ABC Software Development");
            department.setAddress(address);

            Project project = new Project();
            project.setProjectName("TMOBILE");

            Project project1 = new Project();
            project1.setProjectName("SIRONRCC");

            List<Project> projects = new ArrayList<>();
            projects.add(project);
            projects.add(project1);

            Employee employee = new Employee();
            employee.setName("TEMP 123");
            employee.setSalary(1000);
            employee.setDepartment(department);
            employee.setCubicles(cubicles);
            employee.setParkingSpace(parkingSpace);
            employee.setProjects(projects);
            entityManager.persist(employee);
            List<Employee> employees = new ArrayList<>();
            employees.add(employee);

            project.setEmployees(employees);
            project1.setEmployees(employees);

            department.setEmployees(employees);
            entityManager.persist(department);
            entityManager.persist(project);
            entityManager.persist(project1);
            entityManager.getTransaction().commit();
            entityManager.close();

        }else{
            LOGGER.error("Entity Manager factory instantiation was unsuccessful");
            System.exit(-1);
        }
        emf.close();
    }
}
