package main;

import model.Employee;
import services.CredentialService;

import java.util.Scanner;

public class Driver {

    public static void main(String []args){
        CredentialService credentialService =new CredentialService();
        Employee employee=new Employee("Mangesh","Kore");

        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to the IT Admin page");
        System.out.println();

        int option=0;
        do{
            System.out.println("Please enter the department from the following");
            System.out.println("1. Technical");
            System.out.println("2. Admin");
            System.out.println("3. Human Resource");
            System.out.println("4. Legal");
            System.out.println("0. Log Out");
            option=sc.nextInt();
            switch (option){
                case 0:
                    option=0;
                    credentialService.logOut();
                    break;
                case 1:
                    option=1;
                    employee.setDepartment("tech");
                    break;
                case 2:
                    option=2;
                    employee.setDepartment("admin");
                    break;
                case 3:
                    option=3;
                    employee.setDepartment("hr");
                    break;
                case 4:
                    option=4;
                    employee.setDepartment("legal");
                    break;
            }
            if(option!=0) {
                credentialService.generateEmailAddress(employee);
                credentialService.generatePassword(employee);
                credentialService.showCredentials(employee);
            }

        }while (option!=0);
    }
}
