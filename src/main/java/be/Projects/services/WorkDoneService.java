package be.Projects.services;

import be.Projects.data.WorkDoneDAO;
import be.Projects.model.ProjDetails;
import be.Projects.model.WorkDone;

import java.sql.SQLException;
import java.util.List;

import static java.time.LocalDate.now;

public class WorkDoneService {
    private WorkDoneDAO workDoneDAO = new WorkDoneDAO();

    public void addRecord(WorkDone workDone) throws SQLException {
      if((now().isAfter(workDone.getDate())))
        {
            workDoneDAO.addRecord(workDone);
        }
    }

    public void updateWorkDone(WorkDone workDone) throws SQLException {
        workDoneDAO.updateWorkDone(workDone);
    }

    public void deleteWorkDone(int empid , int projid) throws SQLException {
        workDoneDAO.deleteWorkDone(empid,projid);
    }

    public  List<WorkDone> whichEmponwhichProj() throws SQLException {
       return workDoneDAO.whichEmponwhichProj();
    }

    public List<WorkDone> workDoneList () throws SQLException {
        return workDoneDAO.workDoneList();
    }

    public List<ProjDetails> priceOfProject(int projid) throws SQLException {
        return workDoneDAO.priceOfProject(projid);
    }

    public List<WorkDone> topEmponeachProj (int projid) throws SQLException {
        return workDoneDAO.topEmponeachProj(projid);
    }

    public List<WorkDone> employeeWorkingHours(int projid) throws SQLException {
        return workDoneDAO.employeeWorkingHours(projid);
    }

   public int profitOfProject (int projid) throws SQLException {

        ProjDetails projDetails = new ProjDetails();
        int profit = projDetails.getPrice() - workDoneDAO.totalCostOfProj(projid);
        return  profit;

    }


}


