package be.Projects.model;


import java.sql.Date;
import java.time.LocalDate;

public class Employee {

    private int empid;
    private String firstname;
    private String lastname;
    private String emergencynumber;
    private Date dob;
    private int sal;

    public String getSingleLine() {
        return "Employee{" +
                "empid=" + empid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", emergencynumber=" + emergencynumber +
                ", dob=" + dob +
                ", sal=" + sal +
                '}';
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {

        if(sal <0)
            System.out.println(" Please enter Salary in a +ve number");
        else
        this.sal = sal;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmergencynumber() {
        return emergencynumber;
    }

    public void setEmergencynumber(String emergencynumber) {
        if(emergencynumber.length()!=9)
            System.out.println("Enter Valid PhoneNumber");
        else
        this.emergencynumber = emergencynumber;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

}
