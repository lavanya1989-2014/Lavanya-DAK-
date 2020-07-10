package be.Projects.services;

import be.Projects.data.ProjDetailsDAO;
import be.Projects.model.ProjDetails;

import java.sql.SQLException;

public class ProjDetailsService {
    private ProjDetailsDAO projDetailsDAO = new ProjDetailsDAO();

    public void addProject(ProjDetails projDetails) throws SQLException {
    projDetailsDAO.addProject(projDetails);
    }


    public void deleteProject(int projid) throws SQLException {
        projDetailsDAO.deleteProject(projid);
    }
}
