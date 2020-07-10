package be.Projects.data;

import be.Projects.model.Employee;
import be.Projects.model.ProjDetails;
import be.Projects.model.WorkDone;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WorkDoneDAO {


public  void addRecord(WorkDone workDone) throws SQLException {

    String sql = "INSERT INTO WorkDone VALUES('" + workDone.getEmpid() + "','"+ workDone.getProjid() +
             "','" + workDone.getDate() + "','" + workDone.getDate() + "','" + workDone.getHours() + "','"
                     + workDone.getRemarks() + "')";
    Connection connection = ConnectionFactory.getConnection();
    Statement statement=connection.prepareStatement(sql);
    statement.executeUpdate(sql);

    System.out.println("Record is inserted into Employee table for Employee : "  + workDone.getEmpid());

}

    public void updateWorkDone(WorkDone workDone) throws SQLException {
    String sql = "UPDATE Employee SET projid=" + "'" + workDone.getProjid()
            + "'" + "WHERE empid=" +workDone.getEmpid();
        Connection connection = ConnectionFactory.getConnection();
        Statement statement=connection.prepareStatement(sql);
        statement.executeUpdate(sql);

        System.out.println("Record is updated into Employee table where empid : "
                + workDone.getEmpid());

    }

    public void deleteWorkDone(int projid) throws SQLException {
    String sql= "DELETE FROM WorkDone WHERE projid=" + projid;
        Connection connection = ConnectionFactory.getConnection();
        Statement statement=connection.prepareStatement(sql);
        statement.executeUpdate(sql);

        System.out.println("Record is deleted into Employee table where empid : "
                + projid);

    }

    public List<WorkDone> onGoingProjects() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        Statement statement=connection.createStatement();
        String sql = "SELECT projid FROM WorkDone,ProjDetails WHERE ProjDetails.endingdate=' NULL' AND WorkDone.projid == ProjDetails.projid ";
        ResultSet resultSet=statement.executeQuery(sql);
                List<WorkDone> reult = new ArrayList<>();
        while(resultSet.next()) {
            WorkDone workDone = new WorkDone();
            workDone.setProjid(resultSet.getInt("projid"));
            reult.add(workDone);
        }
        return reult;
    }

    public List<WorkDone> projStartToday() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        Statement statement=connection.createStatement();
        String sql = "SELECT projid FROM WorkDone,ProjDetails WHERE WorkDone.projid == ProjDetails.projid AND ProjDetails.startingdate=" + LocalDate.now();
        ResultSet resultSet=statement.executeQuery(sql);
        List<WorkDone> reult = new ArrayList<>();
        while(resultSet.next()) {
            WorkDone workDone = new WorkDone();
            workDone.setProjid(resultSet.getInt("projid"));
            reult.add(workDone);
        }
        return reult;


    }

}