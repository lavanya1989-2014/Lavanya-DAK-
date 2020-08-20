package be.Projects.data;

import be.Projects.model.Employee;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.now;


public class EmployeeDAO {
    public List<Employee> showAllEmployees() throws SQLException {

        Connection connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Employee");
        List<Employee> result = new ArrayList<>();

        while (resultSet.next()) {

            Employee employee = new Employee();
            employee.setEmpid(resultSet.getInt("empId"));
            employee.setFirstname(resultSet.getString("firstname"));
            employee.setLastname(resultSet.getString("lastname"));
            employee.setEmergencynumber(resultSet.getString("emergencynumber"));
            employee.setDob(resultSet.getDate("dob").toLocalDate());
            employee.setSal(resultSet.getInt("sal"));
            result.add(employee);

        }
        return result;
    }

    public Employee getEmployee( int id) throws  SQLException
    {
        Connection connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Employee where empid = "+ id);

        List<Employee> result = new ArrayList<>();
        Employee employee = new Employee();

        while (resultSet.next()) {


            employee.setEmpid(resultSet.getInt("empId"));
            employee.setFirstname(resultSet.getString("firstname"));
            employee.setLastname(resultSet.getString("lastname"));
            employee.setEmergencynumber(resultSet.getString("emergencynumber"));
            employee.setDob(resultSet.getDate("dob").toLocalDate());
            employee.setSal(resultSet.getInt("sal"));

        }
        return employee;
    }

    public List<Employee> employeeSecurityCheck(String name) throws SQLException {
        try {
            Connection connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM Employee Where firstname LIKE ? OR lastname LIKE ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, name);
            ResultSet resultSet = ps.getResultSet();

            List<Employee> result = new ArrayList<>();

            while (resultSet.next()) {

                Employee employees = new Employee();
                employees.setFirstname(resultSet.getString("firstname"));
                employees.setLastname(resultSet.getString("lastname"));
                result.add(employees);

            }

            if(result.isEmpty())
                System.out.println("There are no Employees with that name");
            else
            return result;
        }catch (Exception e) {
            System.out.println(e);
        }
       return null;
        }



    public void addEmployee(Employee employee) throws SQLException {

        try {

            String sql = "INSERT into Employee VALUES(?,?,?,?,?,?,?)";
            Connection connection = ConnectionFactory.getConnection();

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, employee.getEmpid());
            ps.setString(2, employee.getFirstname());
            ps.setString(3, employee.getLastname());
            ps.setString(4, employee.getPhonenumber());
            ps.setString(5, employee.getEmergencynumber());
            ps.setDate(6, Date.valueOf(employee.getDob()));
            ps.setFloat(7, employee.getSal());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);

            System.out.println("Record is inserted into Employee table for Employee : " + employee.getFirstname());

        }
    }

    public void updateEmployee(int empid, int sal) throws SQLException {
        try {

            String sql = "UPDATE Employee SET sal= ? WHERE empid= ?";
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,sal);
            ps.setInt(2,empid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);

        }
        System.out.println("Record is updated into Employee table where empid : "
                +empid);


    }

    public void deleteEmployee(int empid) throws SQLException {
        try {
            String sql = "DELETE FROM Employee WHERE Empid=" + empid;
            Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            System.out.println("Record is deleted into Employee table where empid : "
                    + empid);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Employee> getBirthday() throws SQLException {
        String sql = "SELECT * FROM Employee WHERE MONTH(dob)= ? AND DAY(dob)=?";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,now().getMonthValue());
        ps.setInt(2,now().getDayOfMonth());
        ResultSet rs = ps.executeQuery();
        List<Employee> result = new ArrayList<>();

        while (rs.next()) {
            Employee employee = new Employee();
            employee.setEmpid(rs.getInt("empId"));
            employee.setFirstname(rs.getString("firstname"));
            employee.setLastname(rs.getString("lastname"));
            employee.setEmergencynumber(rs.getString("emergencynumber"));
            employee.setDob(rs.getDate("dob").toLocalDate());
            employee.setSal(rs.getInt("sal"));
            result.add(employee);

        }
        return result;
    }

    public List<Employee> birthdaysInNext7days() throws SQLException {
        String sql = "SELECT *  FROM Employee where DAY(dob) BETWEEN ? AND ? AND where MONTH(dob)= ? ";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, now().getDayOfMonth());
        ps.setInt(2,now().getDayOfMonth()+7);
        ps.setInt(3,now().getMonthValue());
        ResultSet rs = ps.executeQuery();
        List<Employee> result = new ArrayList<>();

        while (rs.next()) {
            Employee employee = new Employee();
            employee.setEmpid(rs.getInt("empId"));
            employee.setFirstname(rs.getString("firstname"));
            employee.setLastname(rs.getString("lastname"));
            employee.setEmergencynumber(rs.getString("emergencynumber"));
            employee.setDob(rs.getDate("dob").toLocalDate());
            employee.setSal(rs.getInt("sal"));
            result.add(employee);

        }
        return result;
    }
}
