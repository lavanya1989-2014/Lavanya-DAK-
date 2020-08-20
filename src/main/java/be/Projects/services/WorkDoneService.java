package be.Projects.services;

import be.Projects.data.ConnectionFactory;
import be.Projects.data.EmployeeDAO;
import be.Projects.data.WorkDoneDAO;
import be.Projects.model.Employee;
import be.Projects.model.ProjDetails;
import be.Projects.model.WorkDone;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.now;

public class WorkDoneService {
    private WorkDoneDAO workDoneDAO = new WorkDoneDAO();

    public void addRecord(WorkDone workDone) throws SQLException {
        if ((now().isAfter(workDone.getDate()))) {
            workDoneDAO.addRecord(workDone);
        }
    }

    public void updateWorkDone(WorkDone workDone) throws SQLException {
        workDoneDAO.updateWorkDone(workDone);
    }

    public void deleteWorkDone(int empid, int projid) throws SQLException {
        workDoneDAO.deleteWorkDone(empid, projid);
    }

    public List<WorkDone> whichEmponwhichProj() throws SQLException {
        return workDoneDAO.whichEmponwhichProj();
    }

    public List<WorkDone> workDoneList() throws SQLException {
        return workDoneDAO.workDoneList();
    }

    public List<ProjDetails> priceOfProject(int projid) throws SQLException {
        return workDoneDAO.priceOfProject(projid);
    }

    public List<WorkDone> topEmponeachProj(int projid) throws SQLException {
        return workDoneDAO.topEmponeachProj(projid);
    }

    public List<WorkDone> employeeWorkingHours(int projid) throws SQLException {
        return workDoneDAO.employeeWorkingHours(projid);
    }

  /* public int profitOfProject (int projid) throws SQLException {

        ProjDetails projDetails = new ProjDetails();
        int profit = projDetails.getPrice() - workDoneDAO.totalCostOfProj(projid);
        return  profit;

    }*/

    public int hourlyWages(int empid) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee emp = employeeDAO.getEmployee(empid);
        int salary = emp.getSal();
        int salPerDay = salary / 22;
        int salPerHour = salPerDay / 8;
        return salPerHour;

    }


    public double totalCostOfProj(int projid) throws SQLException {


        double totalCost = 0.0;
        String sql = "SELECT empid from WorkDone WHERE projid = " + projid;
        Connection con = ConnectionFactory.getConnection();
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(sql);
        List<WorkDone> result = new ArrayList<>();
        List<Integer> allemployees = new ArrayList<>();
        while (resultSet.next()) {
            //  WorkDone workDone = new WorkDone();
            allemployees.add(resultSet.getInt("projid"));
        }

        for (int i : allemployees) {
            double wage = hourlyWages(i);
            double hours = workDoneDAO.employeeWorkingHours(i, projid);
            totalCost += (hours * wage);
        }
return totalCost;
    }
}


