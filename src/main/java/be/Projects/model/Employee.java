package be.Projects.model;

import static java.time.LocalDate.now;
import java.time.LocalDate;

public class Employee {

    private int empid;
    private String firstname;
    private String lastname;
    private String phonenumber;
    private String emergencynumber;
    private LocalDate dob;
    private int sal;

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", emergencynumber=" + emergencynumber +
                ", dob=" + dob +
                ", sal=" + sal +
                '}';
    }

    public String getSingleLine() {
        return  "Employee{" +
                    "empid=" + empid +
                    ", firstname='" + firstname + '\'' +
                    ", lastname='" + lastname + '\'' +
                    '}';
    }

    public String getPhonenumber() { return phonenumber; }

    public void setPhonenumber(String phonenumber) {
        if(phonenumber.length()!=9)
            System.out.println("Enter Valid PhoneNumber");
        else
            this.phonenumber = phonenumber;
    }

    public int getSal() { return sal; }

    public void setSal(int sal) {

        if(sal <0)
            System.out.println(" Please enter Salary in a +ve number");
        else
        this.sal = sal;
    }

    public String getEmergencynumber() { return emergencynumber; }

    public void setEmergencynumber(String emergencynumber) {
        if(emergencynumber.length()!=9)
            System.out.println("Enter Valid PhoneNumber");
        else
        this.emergencynumber = emergencynumber;
    }

    public LocalDate getDob() { return dob; }

    public void setDob(LocalDate dob) {
        if (getDob().plusYears(18).isBefore(now()))
            this.dob = dob;
        else
            System.out.println("Hire People above age 18");
        }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public int getEmpid() { return empid; }

    public void setEmpid(int empid) { this.empid = empid; }

}
