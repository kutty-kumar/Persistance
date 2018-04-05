package services;

import entities.Department;
import entities.Employee;
import org.apache.log4j.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeService extends PersistanceService{

    private static final Logger LOGGER = Logger.getLogger(EmployeeService.class);

    public EmployeeService(EntityManager em){
        super(em);
    }


    public Employee createEmployee(Long id,String name,long salary, Department department){
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setSalary(salary);
        employee.setDepartment(department);
        entityManager.persist(department);
        entityManager.persist(employee);
        return employee;
    }

    public Employee findEmployee(long id){
        return entityManager.find(Employee.class,id);
    }


    public List<Employee> findAllEmployees(){
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e from EMPLOYEE e",Employee.class);
        return query.getResultList();
    }

    public Employee raiseEmployeeSalary(long id,long salary){
        Employee employee = findEmployee(id);
        if(employee!=null) {
            employee.setSalary(employee.getSalary() + salary);
        }
        return employee;
    }

    public void deleteEmployee(long id){
        Employee employee = findEmployee(id);
        if(employee!=null){
            entityManager.remove(employee);
        }
    }
}
