package be.Projects.model;

import java.time.LocalDate;
import java.sql.Date;


public class ProjDetails {

    private  int projid;
    private LocalDate startingdate;
    private String description;
    private int price;
    private LocalDate endingdate;

    public int getProjid() {
        return projid;
    }

    public void setProjid(int projid) {
        this.projid = projid;
    }

    public LocalDate getStartingdate() { return startingdate; }

    public void setStartingdate(LocalDate startingdate) { this.startingdate = startingdate; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getPrice() { return price; }

    public void setPrice(int price) {
        if(price<0)
            System.out.println("Enter  Valid Price");
        else
        this.price = price;
    }

    public LocalDate getEndingdate() {
        //ending dates are not before starting dates

        return endingdate;
    }

    public void setEndingdate(LocalDate endingdate) {

        this.endingdate = endingdate;
    }

    @Override
    public String toString() {
        return "ProjDetails{" +
                "projid=" + projid +
                ", startingdate=" + startingdate +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", endingdate=" + endingdate +
                '}';
    }
}
