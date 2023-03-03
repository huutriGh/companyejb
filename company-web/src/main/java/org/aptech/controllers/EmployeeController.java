package org.aptech.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import org.aptech.EmployeeBean;
import org.aptech.Enums.Action;
import org.aptech.entities.Address;
import org.aptech.entities.Employee;

import javax.ejb.EJB;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "EmployeeController", value = "/employee")
public class EmployeeController extends HttpServlet {

    @EJB
    EmployeeBean employeeBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/AddEmployee.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (Action.ADD.toString().equalsIgnoreCase(action)) {
            Employee employee = getEmployee(request);
            employeeBean.addEmployee(employee);
            response.getWriter().write("Create Employeee Success");

        }
    }

    private static Employee getEmployee(HttpServletRequest request) {
        String name = request.getParameter("fullName");
        String birthday = request.getParameter("birthday");
        String street = request.getParameter("street");
        String ward = request.getParameter("ward");
        String district = request.getParameter("district");
        String city = request.getParameter("city");

        Employee employee = new Employee();
        employee.setFullName(name);
        LocalDate date = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        employee.setBirthday(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        Address address = new Address();
        address.setStreet(street);
        address.setWard(ward);
        address.setDistrict(district);
        address.setCity(city);
        address.setEmployee(employee);
        employee.setAddress(address);
        return employee;
    }
}
