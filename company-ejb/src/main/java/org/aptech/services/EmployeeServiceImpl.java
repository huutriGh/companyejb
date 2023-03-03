package org.aptech.services;

import org.aptech.entities.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.*;
import java.util.List;


@ApplicationScoped
public class EmployeeServiceImpl implements EmployeeService {




    private final EntityManager entityManager;



    public EmployeeServiceImpl() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("companyPersistenceUnit");
        this.entityManager = entityManagerFactory.createEntityManager();
    }




    @Override
    public List<Employee> getAllEmployee() {
        return entityManager.createQuery("Select e from Employee e", Employee.class).getResultList();
    }

    @Override
    public Employee getEmployeeById(String id) {
        return null;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        try {

            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();

            return true;
        } catch (Exception exception) {

            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        try {

            entityManager.getTransaction().begin();
            entityManager.merge(employee);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteEmployee(String id) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(getEmployeeById(id));
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
