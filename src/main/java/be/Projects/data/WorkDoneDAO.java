package be.Projects.data;

import be.Projects.model.Employee;
import be.Projects.model.ProjDetails;
import be.Projects.model.WorkDone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkDoneDAO {


public  void addRecord(WorkDone workDone) throws SQLException {

    String sql = "INSERT INTO WorkDone VALUES(?,?,?,?,?)";
    Connection connection = ConnectionFactory.getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement(sql);
    preparedStatement.setInt(1,workDone.getEmpid());
    preparedStatement.setInt(2,workDone.getProjid());
    preparedStatement.setDate(3,Date.valueOf(workDone.getDate()));
    preparedStatement.setInt(4,workDone.getHours());
    preparedStatement.setString(5,workDone.getRemarks());
    preparedStatement.executeUpdate();

    System.out.println("Record is inserted into Employee table for Employee : "
            + workDone.getEmpid() + " Project : " + workDone.getProjid());

}

    public void updateWorkDone(WorkDone workDone) throws SQLException {
    String sql = "UPDATE Employee SET hours= ?  WHERE empid = ? AND projid = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,workDone.getHours());
        ps.setInt(2,workDone.getEmpid());
        ps.setInt(3,workDone.getProjid());
        ps.executeUpdate();

        System.out.println("Record is updated in Workdone table where empid : "
                + workDone.getEmpid()+ " and Projid : " + workDone.getProjid());

    }

    public void deleteWorkDone(int empid,int projid) throws SQLException {
    String sql= "DELETE FROM WorkDone WHERE  empid = ? AND projid=?" ;
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,empid);
        ps.setInt(2,projid);
        ps.executeUpdate();

        System.out.println("Record is deleted in WorkDone where empid : "
                + empid + "  and Projid : " + projid);

    }

    public List<WorkDone> whichEmponwhichProj() throws SQLException {
        String sql = "SELECT empid,projid,date FROM WorkDone ";
        Connection connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<WorkDone> result = new ArrayList<>();

        while (resultSet.next()) {
            WorkDone workDone = new WorkDone();
            workDone.setEmpid(resultSet.getInt("empid"));
            workDone.setEmpid(resultSet.getInt("projid"));
            workDone.setDate(resultSet.getDate("date").toLocalDate());
            result.add(workDone);
        }
        return  result;
    }

    public List<WorkDone> workDoneList () throws SQLException {
        String sql = "SELECT * FROM WorkDone";
        Connection con = null;
        con = ConnectionFactory.getConnection();
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(sql);
        List<WorkDone> result = new ArrayList<>();

        while (resultSet.next()) {

            WorkDone workDone = new WorkDone();
            workDone.setEmpid(resultSet.getInt("empid"));
            workDone.setProjid(resultSet.getInt("projid"));
            workDone.setDate(resultSet.getDate("date").toLocalDate());
            workDone.setHours(resultSet.getInt("hours"));
            workDone.setRemarks(resultSet.getString("remarks"));

            result.add(workDone);

        }
        return result;
    }

    public List<ProjDetails> priceOfProject(int projid) throws SQLException {
    String sql = "SELECT price FROM ProjDetails Where projd = " + projid;
    Connection con = ConnectionFactory.getConnection();
    Statement st = con.createStatement();
    ResultSet resultSet = st.executeQuery(sql);
    List<ProjDetails> result = new ArrayList<>();

    while (resultSet.next()) {
        ProjDetails projDetails = new ProjDetails();
        projDetails.setPrice(resultSet.getInt("price"));
        result.add(projDetails);
    }
        return result;
    }

    public List<WorkDone> topEmponeachProj (int projid) throws SQLException {
    String sql = "SELECT projid,empid,hours FROM WorkDone WHERE projid = ? ORDER BY hours DESC LIMIT 3";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,projid);
        ResultSet resultSet = ps.executeQuery(sql);
        List<WorkDone> result = new ArrayList<>();

        while (resultSet.next()) {
            WorkDone workDone = new WorkDone();
            workDone.setEmpid(resultSet.getInt("projid"));
            workDone.setProjid(resultSet.getInt("empid"));
            workDone.setHours(resultSet.getInt("hours"));
            result.add(workDone);

         }
         return  result;

    }

    public List<WorkDone> employeeWorkingHours(int projid) throws SQLException {
    String sql = "SELECT projid,empid,hours FROM WorkDone WHERE projid = ? ORDER BY hours DESC";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,projid);
        ResultSet resultSet = ps.executeQuery(sql);
        List<WorkDone> result = new ArrayList<>();

        while (resultSet.next()) {
            WorkDone workDone = new WorkDone();
            workDone.setEmpid(resultSet.getInt("projid"));
            workDone.setProjid(resultSet.getInt("empid"));
            workDone.setHours(resultSet.getInt("hours"));
            result.add(workDone);

        }
        return  result;

    }


    public int hourlyWages( int empid) {

    Employee emp = new Employee();
     int salary = emp.getSal();
     int salPerDay = salary/22;
     int salPerHour = salPerDay/8;
     return salPerHour;

    }


    public int totalCostOfProj (int projid )throws SQLException {
        WorkDone workDone = new WorkDone();
     int cost = hourlyWages(workDone.getEmpid()) * workDone.getHours();
     return cost;
   }



    }


