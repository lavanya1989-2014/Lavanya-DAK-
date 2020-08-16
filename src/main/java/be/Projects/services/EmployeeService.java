package be.Projects.services;

import be.Projects.data.EmployeeDAO;
import be.Projects.model.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAO();


    public List<Employee> showAllEmployees() throws SQLException {
        return  employeeDAO.showAllEmployees();
    }

    public List<Employee> employeeSecurityCheck(String name) throws SQLException {
        return employeeDAO.employeeSecurityCheck(name);
    }

    public void addEmployee(Employee employee) throws SQLException {
        employeeDAO.addEmployee(employee);
    }

    public void updateEmployee(int empid,int sal) throws SQLException {
        employeeDAO.updateEmployee(empid,sal);
    }

    public void deleteEmployee(int empid) throws SQLException {
        employeeDAO.deleteEmployee(empid);
    }

    public List<Employee> getBirthday() throws SQLException {
        return  employeeDAO.getBirthday();
    }

    public  List<Employee> birthdaysInNext7days() throws SQLException {
        return employeeDAO.birthdaysInNext7days();
    }

    public void greet(EmployeeService employeeService) throws  SQLException {
        List<Employee> result = employeeService.getBirthday();
        if (result.isEmpty()) {
            System.out.println("No employee celebrates his birthday today");
        } else
            System.out.println("Today don't forget to wish happy birthday to :");
        result.forEach(System.out :: println);
    }
}
