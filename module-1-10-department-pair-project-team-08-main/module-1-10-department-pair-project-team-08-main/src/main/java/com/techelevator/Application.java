package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static List<Department> departments = new ArrayList<>();
    public static List<Employee> employees = new ArrayList<>();
    public static List<Employee> engEmployees = new ArrayList<>();
    public static List<Employee> marEmployees = new ArrayList<>();
    public static List<Employee>salEmployees = new ArrayList<>();
    public static Map<String, Project> projects = new HashMap();


    /**
     * The main entry point in the application
     * @param args
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!

        // print all employees
        printEmployees();

        // create the Teams project
        createTeamsProject();

        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();
    }

    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {
        Department marketing = new Department(1, "Marketing");
        Department sales = new Department(2, "Sales");
        Department engineering = new Department(3, "Engineering");
        departments.add(marketing);
        departments.add(sales);
        departments.add(engineering);
    }


    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        for(int i = 0; i < departments.size(); i++){
            System.out.println(departments.get(i).getDepartmentName());
        }
    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {
        Employee DJ = new Employee();
        DJ.setFirstName("Dean");
        DJ.setLastName("Johnson");
        DJ.setDepartment(departments.get(2));


        Employee AS = new Employee (2, "Angie", "Smith", "asmith@teams.com", departments.get(2), "08/21/2020" );
        Employee MT = new Employee (3, "Margaret", "Thompson", "mthompson@teams.com", departments.get(0), "08/21/2020");
        AS.raiseSalary(10);

        employees.add(DJ);
        employees.add(AS);
        employees.add(MT);
        //add all to list

        engEmployees.add(DJ);

        engEmployees.add(AS);
        marEmployees.add(MT);


       // marEmployees.add(MT);
    }


    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");

        for(int i = 0; i < employees.size(); i++){
            System.out.println(employees.get(i).getFullName() + " (" + employees.get(i).getSalary() + ") " + employees.get(i).getDepartment().getDepartmentName());
        }
    }

    /**
     * Create the 'Teams' project.
     */
    private void createTeamsProject() {
        Project teams = new Project("Teams", "Project Management Software", "10/10/2020", "11/10/2020");
        teams.setTeamMembers(engEmployees);
        projects.put("0", teams);
    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {

    Project landingPage = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing", "10/10/2020", "10/17/2020");
    landingPage.setTeamMembers(marEmployees);
    projects.put("1", landingPage);
    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");


            System.out.println("Marketing Landing Page: " + marEmployees.size());
            System.out.println("TEams: " + engEmployees.size());
        }



    }


