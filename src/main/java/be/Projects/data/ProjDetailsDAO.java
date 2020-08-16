package be.Projects.data;

import be.Projects.model.Employee;
import be.Projects.model.ProjDetails;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProjDetailsDAO {

    public List<ProjDetails> showAllProjects() throws SQLException {


        Connection connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM ProjDetails");
        List<ProjDetails> result = new ArrayList<>();

        while (resultSet.next()) {

            ProjDetails projDetails = new ProjDetails();
            projDetails.setProjid(resultSet.getInt("projid"));
            projDetails.setStartingdate(resultSet.getDate("startingdate").toLocalDate());
            projDetails.setDescription(resultSet.getString("description"));
            projDetails.setPrice(resultSet.getInt("price"));
            projDetails.setEndingdate(resultSet.getDate("endingdate").toLocalDate());
            result.add(projDetails);

        }
        return result;
    }

    public void addProject(ProjDetails projDetails) throws SQLException {
try {
    String sql = "INSERT into ProjDetails VALUES(?,?,?,?,?,?)";
    System.out.println(sql);
    Connection connection = ConnectionFactory.getConnection();
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1, projDetails.getProjid());
    ps.setDate(2, Date.valueOf(projDetails.getStartingdate()));
    ps.setString(3, projDetails.getDescription());
    ps.setInt(4, projDetails.getPrice());
    ps.setDate(5, Date.valueOf(projDetails.getEndingdate()));
    }catch (Exception e ){
    System.out.println(e);
        }
        System.out.println("Record is inserted into Project table  : "  + projDetails.getDescription());

    }

    public void deleteProject(int projid) throws SQLException {

        String sql = "DELETE FROM ProjDetails WHERE projid=" + projid;
        Connection connection = ConnectionFactory.getConnection();
        Statement statement=connection.createStatement();
        statement.executeUpdate(sql);

        System.out.println("Record is deleted into Project table where projid is : "
                + projid);
    }

    public List<ProjDetails> onGoingProjects () {
        try {
            Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ProjDetails WHERE  CURDATE() BETWEEN startingdate  AND endingdate");

            List<ProjDetails> result = new ArrayList<>();

            while (resultSet.next()) {

                ProjDetails projDetails = new ProjDetails();
                projDetails.setProjid(resultSet.getInt("projid"));
                projDetails.setStartingdate(resultSet.getDate("startingdate").toLocalDate());
                projDetails.setDescription(resultSet.getString("description"));
                projDetails.setPrice(resultSet.getInt("price"));
                projDetails.setEndingdate(resultSet.getDate("endingdate").toLocalDate());
                result.add(projDetails);
            }
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return  null;
    }

    public List<ProjDetails> projectsStartToday () {
        try {
            Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ProjDetails WHERE  StartDate=CURDATE()");

            List<ProjDetails> result = new ArrayList<>();

            while (resultSet.next()) {

                ProjDetails projDetails = new ProjDetails();
                projDetails.setProjid(resultSet.getInt("projid"));
                projDetails.setStartingdate(resultSet.getDate("startingdate").toLocalDate());
                projDetails.setDescription(resultSet.getString("description"));
                projDetails.setPrice(resultSet.getInt("price"));
                projDetails.setEndingdate(resultSet.getDate("endingdate").toLocalDate());
                result.add(projDetails);
            }
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }



    }

