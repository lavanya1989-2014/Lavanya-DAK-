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

    public List<Employee> employeeSecurityCheck(Employee employee) throws SQLException {
        return employeeDAO.employeeSecurityCheck(employee);
    }

    public void addEmployee(Employee employee) throws SQLException {
        employeeDAO.addEmployee(employee);
    }

    public void updateEmployee(Employee employee) throws SQLException {
        employeeDAO.updateEmployee(employee);
    }

    public void deleteEmployee(int empid) throws SQLException {
        employeeDAO.deleteEmployee(empid);
    }
}
