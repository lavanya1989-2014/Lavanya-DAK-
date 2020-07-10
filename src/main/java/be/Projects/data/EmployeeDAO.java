package be.Projects.data;

import be.Projects.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAO {
    public List<Employee> showAllEmployees() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery( "SELECT * FROM Employee");
        List<Employee> result= new ArrayList<>();
        while(resultSet.next()) {
            Employee employee = new Employee();
            employee.setEmpid(resultSet.getInt("empId"));
            employee.setFirstname(resultSet.getString("firstname"));
            employee.setLastname(resultSet.getString("lastname"));
            employee.setEmergencynumber(resultSet.getString("emergencynumber"));
            employee.setDob(resultSet.getDate("dob"));
            employee.setSal(resultSet.getInt("sal"));
            result.add(employee);

        }
        return result;
    }

    public List<Employee> employeeSecurityCheck(Employee employee) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        String sql= "SELECT * FROM Employee Where firstname=" + employee.getFirstname() + "||" + "lastname ="
                + employee.getLastname() +")";
        PreparedStatement statement=connection.prepareStatement(sql);
        ResultSet resultSet=statement.executeQuery( );
        List<Employee> result= new ArrayList<>();

        while(resultSet.next()) {
            Employee employees = new Employee();
            employees.setFirstname(resultSet.getString("firstname"));
            employees.setLastname(resultSet.getString("lastname"));
            result.add(employee);

        }
        return result;
    }



    public void addEmployee(Employee employee) throws SQLException {
        String sql="INSERT into Employee VALUES('" + employee.getEmpid() + "','" + employee.getFirstname() + "','" + employee.getLastname()
                + "','"+ employee.getEmergencynumber() + "','" + employee.getDob() + "','" + employee.getSal() + "')";
        Connection connection = ConnectionFactory.getConnection();
        Statement statement=connection.prepareStatement(sql);
        statement.executeUpdate(sql);

        System.out.println("Record is inserted into Employee table for Employee : "  + employee.getFirstname());

    }

    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "UPDATE Employee SET firstname=" + "'" + employee.getFirstname()
                      + "'" + "WHERE empid=" + employee.getEmpid();
        Connection connection = ConnectionFactory.getConnection();
        Statement statement=connection.prepareStatement(sql);
        statement.executeUpdate(sql);

        System.out.println("Record is updated into Employee table where empid : "
                                 + employee.getEmpid());


    }

    public void deleteEmployee(int empid) throws SQLException {
        String sql = "DELETE FROM Employee WHERE Empid=" + empid;
        Connection connection = ConnectionFactory.getConnection();
        Statement statement=connection.prepareStatement(sql);
        statement.executeUpdate(sql);

        System.out.println("Record is deleted into Employee table where empid : "
                + empid);
    }


    }

