package org.aptech.services;

import org.aptech.entities.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployee();

    public Employee getEmployeeById(String id);

    public boolean addEmployee(Employee employee);

    public boolean updateEmployee(Employee employee);

    public boolean deleteEmployee(String id);

}
