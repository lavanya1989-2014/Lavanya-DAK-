package be.Projects;

import be.Projects.model.Employee;
import be.Projects.model.ProjDetails;
import be.Projects.model.WorkDone;
import be.Projects.services.EmployeeService;
import be.Projects.services.ProjDetailsService;
import be.Projects.services.WorkDoneService;

import java.sql.*;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws SQLException {
        int mainChoice;
        int subChoice = -1;


        do {
            showMenu();
            mainChoice = requestIntInput(0, 3);

            if (mainChoice != 0) {
                showSubMenu(mainChoice);
                subChoice = requestIntInput(0, 10);

                handleUserChoice(mainChoice, subChoice);
            }
        } while (mainChoice != 0 && subChoice != 0);
    }


    private static void handleUserChoice(int mainChoice, int subChoice) throws SQLException {
        EmployeeService employeeService = new EmployeeService();
        ProjDetailsService projDetailsService = new ProjDetailsService();
        WorkDoneService workDoneService = new WorkDoneService();
        if (mainChoice == 1) { //Employee table

            if (subChoice == 1) {
                // Showing all Employees
                List<Employee> employees = null;
                try {
                    employees = employeeService.showAllEmployees();
                    employees.forEach(e -> System.out.println(e.getSingleLine()));
                } catch (SQLException ignored) {
                    System.out.println("Problems with database...");
                    ignored.printStackTrace();
                }
            }

            if (subChoice == 2) {
                //adding Employee
                Employee employee = new Employee();
                Scanner keyboard = new Scanner(System.in);

                System.out.println("Enter employee details \n");
                System.out.println("EmpId:");
                employee.setEmpid(keyboard.nextInt());

                System.out.println("FirstName: ");
                employee.setFirstname(keyboard.next());
                System.out.println("LastName: ");
                employee.setLastname(keyboard.next());
                System.out.println("PhoneNumber(10-digit,starts with 0:)");
                String phoneNumber = keyboard.next();
                employee.setPhonenumber(phoneNumber);

                System.out.println("phoneNumberICE(10-digit,starts with 0:)");
                String phoneNumberICE = keyboard.next();
                employee.setEmergencynumber(phoneNumberICE);
                System.out.println("DateOfBirth(yyyy-MM-dd):");
                employee.setDob(LocalDate.parse(keyboard.next()));
                System.out.println("Salary:");
                employee.setSal(keyboard.nextInt());

                employeeService.addEmployee(employee);

            }

            if (subChoice == 3) {
                //Security checking
                System.out.println("Enter employees  first or last name:");
                Scanner keyboard = new Scanner(System.in);
                String name = keyboard.next();
                List<Employee> employeesByname = employeeService.employeeSecurityCheck(name);
                employeesByname.forEach(System.out::println);

            }

            if (subChoice == 4) {
                //update
                System.out.print("enter the details of emp whose salary you want to update:");
                System.out.println("employee id");
                Scanner keyboard = new Scanner(System.in);
                int empId = keyboard.nextInt();
                System.out.println("Salary:");
                int salary = keyboard.nextInt();
                employeeService.updateEmployee(empId, salary);

            }

            if (subChoice == 5) {
                //Birthday wish
                System.out.println("employees celebtating their birthday today:");
                employeeService.greet(employeeService);

            }

            if (subChoice == 6) {
                //list of birthdays with in 1 week
                System.out.println("employees celebtating their birthday in coming 7 days");
                List<Employee> birthdaybuddies = employeeService.birthdaysInNext7days();
                birthdaybuddies.forEach(System.out::println);

            }

            if (subChoice == 7) {
                //delete
                System.out.println("Enter the employeeID to be deleted:");
                Scanner scanner = new Scanner(System.in);
                int empIdToDelete = scanner.nextInt();
                employeeService.deleteEmployee(empIdToDelete);

            }
        }

        if (mainChoice == 2) { //Project table
            if (subChoice == 1) {

                // show all projects
                List<ProjDetails> projects = null;
                projects = projDetailsService.showAllProjects();
                projects.forEach(System.out::println);

            }

            if (subChoice == 2) {

                //adding Project
                ProjDetails projDetails = new ProjDetails();
                Scanner scan = new Scanner(System.in);
                System.out.println("ProjectID:");
                projDetails.setProjid(scan.nextInt());
                System.out.println("description:");
                projDetails.setDescription(scan.next());
                System.out.println("startdate:");
                projDetails.setStartingdate(LocalDate.parse(scan.next()));

                System.out.println("Price:");
                projDetails.setPrice(scan.nextInt());
                System.out.println("Expected end date:");
                projDetails.setEndingdate(LocalDate.parse(scan.next()));

                projDetailsService.addProject(projDetails);

            }

            if (subChoice == 3) {
                // projects start today
                List<ProjDetails> projDetails = projDetailsService.projectsStartToday();
                projDetails.forEach(System.out::println);
            }

            if (subChoice == 4) {
                //ongoing projects
                List<ProjDetails> projDetails = projDetailsService.onGoingProjects();
                projDetails.forEach(System.out::println);
            }

            if (subChoice == 5) {
                //delete
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter ProjectID(1-digit)");
                int projectId = scanner.nextInt();
                projDetailsService.deleteProject(projectId);

            }

        }

        if (mainChoice == 3) { //Workdone table

            if (subChoice == 1) {
                //showing all records
                List<WorkDone> workDones = workDoneService.workDoneList();
                workDones.forEach(System.out::println);
            }

            if (subChoice == 2) {
                //adding record in Workdone table
                WorkDone workDone = new WorkDone();
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter employee project details ");
                System.out.println("EmpId:");
                workDone.setEmpid(scanner.nextInt());
                System.out.println("ProjectId:");
                workDone.setProjid(scanner.nextInt());
                System.out.println("Date:");
                workDone.setDate(LocalDate.parse(scanner.next()));
                System.out.println("Hours WORKED:");
                workDone.setHours(scanner.nextInt());
                System.out.println("Description:");
                workDone.setRemarks(scanner.next());

                workDoneService.addRecord(workDone);

            }

            if (subChoice == 3) {
                //Update
                WorkDone workDone = new WorkDone();
                Scanner scanner = new Scanner(System.in);
                System.out.println("give details to  update:");
                System.out.println("EMPID:");
                workDone.setEmpid(scanner.nextInt());
                System.out.println("no of hours worked:");
                workDone.setHours(scanner.nextInt());
                System.out.println("Projid");
                workDone.setProjid(scanner.nextInt());

                workDoneService.updateWorkDone(workDone);

            }

            if (subChoice == 4) {
                //delete
                WorkDone workDone = new WorkDone();
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter ProjectID(1-digit)");
                int projectId = scanner.nextInt();
                System.out.println("Enter EmployeeID(2digit)");
                int empId = scanner.nextInt();
                workDoneService.deleteWorkDone(empId, projectId);


            }

            if (subChoice == 5) {
                //list of each project with profits
            }

            if (subChoice == 6) {
                //list of top 3 Employees per project
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter ProjectID(1-digit)");
                int projectId = scanner.nextInt();
                List<WorkDone> workDones = workDoneService.topEmponeachProj(projectId);
                workDones.forEach(System.out::println);

            }

            if (subChoice == 7) {
                //List of which employees on which projects
                List<WorkDone> workDones = workDoneService.whichEmponwhichProj();
                workDones.forEach(System.out::println);
            }

            if (subChoice == 8) {
                //profit of a project
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter ProjectID(1-digit)");
                int projectId = scanner.nextInt();
                int profit = workDoneService.profitOfProject(projectId);
                System.out.println("PRofit of " + projectId + " is " + profit);
            }

            if (subChoice == 9) {
                //number of hours each employee worked on each project
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter ProjectID(1-digit)");
                int projectId = scanner.nextInt();
                List<WorkDone> workDones = workDoneService.employeeWorkingHours(projectId);
                workDones.forEach(System.out::println);
            }

        }
    }


        private static void showMenu () {

            System.out.println("0. Exit");
            System.out.println("1. Employee");
            System.out.println("2. ProjDetails");
            System.out.println("3. WorkDone");

        }

        private static void showSubMenu ( int choice){
            if (choice == 1) {
                System.out.println("0. Exit");
                System.out.println("1. Show all employees");
                System.out.println("2. Add a new employee");
                System.out.println("3. Employee Security check");
                System.out.println("4. Updating Employee Salary");
                System.out.println("5. CHECK whose birthday is today and wish them");
                System.out.println("6. CHECK WHOSE BIRTHDAY IS IN upcoming 7 days");
                System.out.println("7. Deleting an Employee Record");

            }

            if (choice == 2) {
                System.out.println("0. Exit");
                System.out.println("1. Show all Projects");
                System.out.println("2. Add Project");
                System.out.println("3. Show all projects that are starting today ");
                System.out.println("4. See what projects are going on");
                System.out.println("5. Deleting a Record from Project");
            }

            if (choice == 3) {
                System.out.println("0. Exit");
                System.out.println("1. Adding a Record");
                System.out.println("2. Update a Record");
                System.out.println("3. Remove a Record");
                System.out.println("4. Ongoing Projects");
                System.out.println("5. Projects that Starting today");
            }

            if (choice == 4) {
                System.out.println("0. Exit");
                System.out.println("1. Show workdone table");
                System.out.println("2. Add");
                System.out.println("3. Update");
                System.out.println("4. DELETE");
                System.out.println("5. LIST OF all projects WITH PROFITABILITY");
                System.out.println("6. LIST OF TOP 3 EMPLOYEES FOR A SPECIFIC PROJECT");
                System.out.println("7. Which employee worked at which project and when");
                System.out.println("8. Knowing Profit of a Project ");
                System.out.println("9. Knowing number of hours each employee worked on each product");
            }


        }

        private static int requestIntInput ( int lower, int upper){
            Scanner scanner = new Scanner(System.in);
            int input = -1;
            do {
                try {
                    System.out.println("Make a choice: ");
                    input = scanner.nextInt();
                } catch (InputMismatchException e) {
                    input = -1;
                }
                scanner.nextLine();
                if (input < lower || input > upper) System.out.println("That's not a valid number");
            } while (input < lower || input > upper);

            return input;
        }

    }

