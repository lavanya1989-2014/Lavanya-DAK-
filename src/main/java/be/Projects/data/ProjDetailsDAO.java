package be.Projects.data;

import be.Projects.model.ProjDetails;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ProjDetailsDAO {

    public void addProject(ProjDetails projDetails) throws SQLException {

        String sql="INSERT into ProjDetails VALUES('" + projDetails.getProjid() + "','" + projDetails.getStartingdate() + "','"
                + projDetails.getDescription() + "','" + projDetails.getPrice() + "','" + projDetails.getEndingdate()  +"')"+
                 " WHERE " + "YEAR"+"("+ projDetails.getStartingdate()+")"+ "==" + "2020";

        System.out.println(sql);
        Connection connection = ConnectionFactory.getConnection();
        Statement statement=connection.prepareStatement(sql);
        statement.executeUpdate(sql);

        System.out.println("Record is inserted into Project table  : "  + projDetails.getDescription());

    }

    public void deleteProject(int projid) throws SQLException {
        String sql = "DELETE FROM ProjDetails WHERE projid=" + projid;
        Connection connection = ConnectionFactory.getConnection();
        Statement statement=connection.prepareStatement(sql);
        statement.executeUpdate(sql);

        System.out.println("Record is deleted into Project table where projid is : "
                + projid);
    }
}

