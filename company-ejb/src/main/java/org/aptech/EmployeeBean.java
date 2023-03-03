package org.aptech;

import org.aptech.entities.Employee;
import org.aptech.remoteinterface.EmployeeRemote;
import org.aptech.services.EmployeeService;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless(name = "EmployeeEJB")
@LocalBean
public class EmployeeBean implements EmployeeRemote {



    @Inject
    EmployeeService service;

    public EmployeeBean() {
    }


    @Override
    public boolean addEmployee(Employee employee) {
        return service.addEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return service.getAllEmployee();
    }

}
