package org.aptech.remoteinterface;


import org.aptech.entities.Employee;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface EmployeeRemote {
    boolean addEmployee(Employee employee);

    List<Employee> getAllEmployee();
}
