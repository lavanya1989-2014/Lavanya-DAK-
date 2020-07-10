package be.Projects;

import be.Projects.model.Employee;
import be.Projects.model.ProjDetails;
import be.Projects.model.WorkDone;
import be.Projects.services.EmployeeService;
import be.Projects.services.ProjDetailsService;
import be.Projects.services.WorkDoneService;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        int mainChoice;
        int subChoice= -1;


        do {
            showMenu();
            mainChoice = requestIntInput(  0,   4);

            if (mainChoice != 0) {
                showSubMenu(mainChoice);
                subChoice = requestIntInput(  0,  4);

                handleUserChoice(mainChoice, subChoice);
            }
        }while (mainChoice != 0 && subChoice != 0);
    }


    private static void handleUserChoice(int mainChoice, int subChoice) throws SQLException {
        EmployeeService employeeService = new EmployeeService();
        ProjDetailsService projDetailsService = new ProjDetailsService();
        WorkDoneService workDoneService = new WorkDoneService();
        if (mainChoice == 1 ) {

            if (subChoice == 1) {
                List<Employee> employees= null;
                try {
                    employees = employeeService.showAllEmployees();
                    employees.forEach(e -> System.out.println(e.getSingleLine()));
                } catch (SQLException ignored) {
                    System.out.println("Problems with database...");
                    ignored.printStackTrace();
                }
            }

            if(subChoice == 2) {
                Employee employeeSrikanth = new Employee();
                employeeSrikanth.setEmpid(7);
                employeeSrikanth.setFirstname("Srikanth");
                employeeSrikanth.setLastname("Reddy");
                employeeSrikanth.setEmergencynumber("254681397");
                employeeSrikanth.setDob(Date.valueOf(LocalDate.ofEpochDay(1994-02-23)));
                employeeService.addEmployee(employeeSrikanth);
            }

            if(subChoice == 3) {
                Employee employeeLahari = new Employee();
                employeeLahari.setEmpid(1);
                employeeLahari.setFirstname("Lahari");
                employeeService.updateEmployee(employeeLahari);

            }

            if(subChoice == 4) {

                employeeService.deleteEmployee(3);
            }

        }

        if(mainChoice == 2) {
            if(subChoice == 1) {

                ProjDetails projectTransport = new ProjDetails();
                projectTransport.setProjid(2);
                projectTransport.setStartingdate(LocalDate.ofEpochDay(2014-02-25));
                projectTransport.setDescription("Transport");
                projectTransport.setPrice(300000);
                projectTransport.setEndingdate(LocalDate.ofEpochDay(2014-06-14)));
                projDetailsService.addProject(projectTransport);

            }

            if(subChoice == 2) {

                projDetailsService.deleteProject(2);

            }


        }

        if(mainChoice== 3) {
            if(subChoice == 1) {

                WorkDone workDone4 = new WorkDone();
                workDone4.setEmpid(4);
                workDone4.setProjid(2);
                workDone4.setDate(LocalDate.ofEpochDay(2014-03-15));
                workDone4.setHours(8);
                workDone4.setRemarks("He is a good Employee");
                workDoneService.addRecord(workDone4);

                WorkDone workDone5 = new WorkDone();
                workDone5.setEmpid(1);
                workDone5.setProjid(3);
                workDone5.setDate(LocalDate.ofEpochDay(2014-03-15));
                workDone5.setHours(6);
                workDone5.setRemarks("He is a good Employee");
                workDoneService.addRecord(workDone5);

                WorkDone workDone9 = new WorkDone();
                workDone9.setEmpid(1);
                workDone9.setProjid(2);
                workDone9.setDate(LocalDate.ofEpochDay(2014-03-12));
                workDone9.setHours(6);
                workDone9.setRemarks("He is a ok Employee");
                workDoneService.addRecord(workDone9);

                WorkDone workDone6 = new WorkDone();
                workDone6.setEmpid(3);
                workDone6.setProjid(2);
                workDone6.setDate(LocalDate.ofEpochDay(2014-04-15));
                workDone6.setHours(5);
                workDone6.setRemarks("He is a okEmployee");
                workDoneService.addRecord(workDone6);

                WorkDone workDone7 = new WorkDone();
                workDone7.setEmpid(1);
                workDone7.setProjid(5);
                workDone7.setDate(LocalDate.ofEpochDay(2014-03-04));
                workDone7.setHours(8);
                workDone7.setRemarks("He is a good Employee");
                workDoneService.addRecord(workDone7);

                WorkDone workDone8 = new WorkDone();
                workDone8.setEmpid(1);
                workDone8.setProjid(3);
                workDone8.setDate(LocalDate.ofEpochDay(2014-03-02));
                workDone8.setHours(6);
                workDone8.setRemarks("He is a good Employee");
                workDoneService.addRecord(workDone8);

                WorkDone workDone10 = new WorkDone();
                workDone10.setEmpid(10);
                workDone10.setProjid(7);
                workDone10.setDate(LocalDate.now());
                workDone10.setHours(0);
                workDone10.setRemarks("Has to see what kind of an Employee");
                workDoneService.addRecord(workDone10);

                WorkDone workDone11 = new WorkDone();
                workDone11.setEmpid(11);
                workDone11.setProjid(8);
                workDone11.setDate(LocalDate.ofYearDay(2019,03));
                workDone11.setHours(6);
                workDone11.setRemarks("He is a good Employee");
                workDoneService.addRecord(workDone11);

            }

            if (subChoice == 2) {
                WorkDone workDone5 = new WorkDone();
                workDone5.setEmpid(1);
                workDone5.setProjid(5);
                workDoneService.updateWorkDone(workDone5);
            }

            if(subChoice == 3) {
                workDoneService.deleteWorkDone(6);
            }

            if(subChoice == 4) {

                List<WorkDone> workDone = null;
                try {
                    workDone = workDoneService.onGoingProjects();
                    workDone.forEach(System.out::println);
                }catch (SQLException ignored) {
                    System.out.println("Problems with database...");
                    ignored.printStackTrace();
                }

            }

            if(subChoice == 5) {
                List<WorkDone> workDones = null;
                try {
                    workDones = workDoneService.projStartToday();
                    workDones.forEach(System.out::println);
                }catch (SQLException ignored) {
                    System.out.println("Problems with database...");
                    ignored.printStackTrace();
                }
                }
            }



        if(mainChoice == 4) {
            if(subChoice == 1) {
                List<Employee> employees= null;
                try {
                    Employee employeeLavanya = new Employee();
                    employeeLavanya.setFirstname("Lavanya");
                    employeeLavanya.setLastname("Gowdas");
                    employees = employeeService.employeeSecurityCheck(employeeLavanya);
                    employees.forEach( System.out::println);
                } catch (SQLException ignored) {
                    System.out.println("Problems with database...");
                    ignored.printStackTrace();
                }


            }
        }
    }

    private static void showMenu() {
        System.out.println("0. Exit");
        System.out.println("1. Employee");
        System.out.println("2. ProjDetails");
        System.out.println("3. WorkDone");
        System.out.println("4. EmployeeSecurityCheck");
        System.out.println("3. Profit per Project ");
    }

    private static void showSubMenu(int choice) {
        if(choice == 1) {
            System.out.println("0. Exit");
            System.out.println("1. Show all employees");
            System.out.println("2. Add a new employee");
            System.out.println("3. Update an employee");
            System.out.println("4. Remove an employee");
        }

        if(choice == 2) {
            System.out.println("0. Exit");
            System.out.println("1. Add a  Project");
            System.out.println("2. Remove a Project");
            System.out.println("3. Ongoing Projects ");
            System.out.println("4. Projects that starting today");
        }

        if(choice == 3) {
            System.out.println("0. Exit");
            System.out.println("1. Adding a Record");
            System.out.println("2. Update a Record");
            System.out.println("3. Remove a Record");
            System.out.println("4. Ongoing Projects");
            System.out.println("5. Projects that Starting today");
        }

        if(choice == 4) {
            System.out.println("0. Exit");
            System.out.println("1.Checking weather that Employee is Working in that Company");
        }

        if(choice == 5) {
            System.out.println("0. Exit");
            System.out.println("1. Find the price of a Project");
            System.out.println("2. Finding Employees working hours");
            System.out.println("3. Finding hourly wages of Employees");
            System.out.println("4. Finding coast of Project");
            System.out.println("5. Finding Profit of a Project");
            System.out.println("6. Finding top 3 Employees per Project");

        }
    }

    private static int requestIntInput(int lower, int upper) {
        Scanner scanner = new Scanner(System.in);
        int input= -1;
        do {
            try {
                System.out.println("Make a choice: ");
                input=scanner.nextInt();
            }catch (InputMismatchException e) {
                input = -1;
            }
            scanner.nextLine();
            if(input < lower || input > upper) System.out.println("That's not a valid number");
        }while (input < lower || input > upper);

        return input;
    }

    private static void printResults(List<String> result) {
        result.forEach(System.out::println);
    }
}
