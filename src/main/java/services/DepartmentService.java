package services;

import entities.Address;
import entities.Department;
import entities.Employee;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DepartmentService extends PersistanceService{

  private static final Logger LOGGER = Logger.getLogger(DepartmentService.class);

  public DepartmentService(EntityManager entityManager){
    super(entityManager);
  }

  public Department createDepartment(String name, Address address){
    Department department = new Department();
    department.setAddress(address);
    department.setName(name);
    if(this.entityManager != null){
       entityManager.persist(department);
       return department;
    }else{
      LOGGER.error("Couldn't Persist Department Entity to Database since entity manager was null");
    }
    return null;
  }

  public Department findDepartmentByName(String departmentName){
    TypedQuery<Department> query= entityManager.createQuery(String.format("SELECT d FROM Department d WHERE d.name like \'%s\'",departmentName),Department.class);
    return query.getResultList().get(0);
  }
}
