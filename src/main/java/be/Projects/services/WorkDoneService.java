package be.Projects.services;

import be.Projects.data.WorkDoneDAO;
import be.Projects.model.Employee;
import be.Projects.model.WorkDone;

import java.sql.SQLException;
import java.util.List;

public class WorkDoneService {
    private WorkDoneDAO workDoneDAO = new WorkDoneDAO();

    public void addRecord(WorkDone workDone) throws SQLException {
        workDoneDAO.addRecord(workDone);
    }

    public void updateWorkDone(WorkDone workDone) throws SQLException {
        workDoneDAO.updateWorkDone(workDone);
    }

    public void deleteWorkDone(int projid) throws SQLException {
        workDoneDAO.deleteWorkDone(projid);
    }


    public List<WorkDone> onGoingProjects() throws SQLException {
        return  workDoneDAO.onGoingProjects();
    }

    public List<WorkDone> projStartToday() throws SQLException {
        return  workDoneDAO.projStartToday();
    }

}


