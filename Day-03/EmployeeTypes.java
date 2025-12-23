//Develop a Java program using nested switch-case to determine employee roles and designations based on department selection.


import java.util.Scanner;

public class SwitchRole {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Department:");
        System.out.println("1. IT");
        System.out.println("2. HR");
        System.out.println("3. Finance");
        System.out.println("4. Operations");
        System.out.print("Enter choice: ");
        int dept = sc.nextInt();

        switch (dept) {
            case 1: // IT
                System.out.println("\nIT Roles:");
                System.out.println("1. Developer");
                System.out.println("2. Tester");
                System.out.println("3. Devops");
                System.out.print("Select role: ");
                int itRole = sc.nextInt();

                switch (itRole) {
                    case 1:
                        System.out.println("Role: Developer");
                        System.out.println("Designation: Software Engineer");
                        break;
                    case 2:
                        System.out.println("Role: Tester");
                        System.out.println("Designation: QA Engineer");
                        break;
                    case 3:
                        System.out.println("Role: Devops");
                        System.out.println("Designation: Devops Engineer");
                        break;
                    default:
                        System.out.println("Invalid IT role selection");
                }
                break;
            case 2:
                System.out.println("\nHR Roles:");
                System.out.println("1. Recruiter");
                System.out.println("2. HR Executive");
                System.out.print("Select role: ");
                int hrRole = sc.nextInt();

                switch (hrRole) {
                    case 1:
                        System.out.println("Role: Recruiter");
                        System.out.println("Designation: Talent Acquisition Specialist");
                        break;
                    case 2:
                        System.out.println("Role: HR Executive");
                        System.out.println("Designation: Human Resources Officer");
                        break;
                    default:
                        System.out.println("Invalid HR role selection");
                }
                break;

            case 3:
                System.out.println("\nFinance Roles:");
                System.out.println("1. Accountant");
                System.out.println("2. Financial Analyst");
                System.out.print("Select role: ");
                int finRole = sc.nextInt();

                switch (finRole) {
                    case 1:
                        System.out.println("Role: Accountant");
                        System.out.println("Designation: Accounts Executive");
                        break;
                    case 2:
                        System.out.println("Role: Financial Analyst");
                        System.out.println("Designation: Finance Analyst");
                        break;
                    default:
                        System.out.println("Invalid Finance role selection");
                }
                break;

            case 4:
                System.out.println("\nOperations Roles:");
                System.out.println("1. Operations Executive");
                System.out.println("2. Manager");
                System.out.print("Select role: ");
                int opRole = sc.nextInt();

                switch (opRole) {
                    case 1:
                        System.out.println("Role: Operations Executive");
                        System.out.println("Designation: Operations Officer");
                        break;
                    case 2:
                        System.out.println("Role: Manager");
                        System.out.println("Designation: Operations Manager");
                        break;
                    default:
                        System.out.println("Invalid Operations role selection");
                }
                break;

            default:
                System.out.println("Invalid department selection");
        }

        sc.close();
    }
}
