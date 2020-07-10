package be.Projects.model;

import java.sql.Date;
import java.time.LocalDate;

public class WorkDone {

    private int empid;
    private int projid;
    private LocalDate date;
    private int hours;
    private String remarks;

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public int getProjid() {
        return projid;
    }

    public void setProjid(int projid) {
        this.projid = projid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "WorkDone{" +
                "empid=" + empid +
                ", projid=" + projid +
                ", date=" + date +
                ", hours=" + hours +
                ", remarks='" + remarks + '\'' +
                '}';
    }

}
