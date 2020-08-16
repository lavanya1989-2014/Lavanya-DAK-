package be.Projects.services;

import be.Projects.data.ProjDetailsDAO;
import be.Projects.model.Employee;
import be.Projects.model.ProjDetails;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ProjDetailsService {
    private ProjDetailsDAO projDetailsDAO = new ProjDetailsDAO();

    public void addProject(ProjDetails projDetails) throws SQLException {
        boolean projects_started_past = projDetails.getStartingdate().isAfter(LocalDate.now());
        boolean proj_ends_before = projDetails.getEndingdate().isAfter(projDetails.getStartingdate());

        if(projects_started_past) {
            if(proj_ends_before) {
                projDetailsDAO.addProject(projDetails);
            }
            else {
                System.out.println("Enter valid end dates");
            }
        }
        else {
            System.out.println("Enter valid starting dates");
        }
        }

    public void deleteProject(int projid) throws SQLException {
        projDetailsDAO.deleteProject(projid);
    }

    public List<ProjDetails> projectsStartToday () throws SQLException {
        return  projDetailsDAO.projectsStartToday();
    }

    public List<ProjDetails> onGoingProjects () throws SQLException {
        return  projDetailsDAO.onGoingProjects();
    }

    public List<ProjDetails> showAllProjects() throws SQLException {
        return  projDetailsDAO.showAllProjects();
    }
}
