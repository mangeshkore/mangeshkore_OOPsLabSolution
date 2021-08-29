package services;

import model.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CredentialService {

    public void logOut() {
        System.out.println("====Thank you for using create credentials portal=======");
    }

    public void generateEmailAddress(Employee employee) {
        String generatedEmail;
        generatedEmail = employee.getFirstName() + employee.getLastName() + "." + employee.getDepartment() + "@" + "abc.com";
        employee.setEmail(generatedEmail);
    }


    public void generatePassword(Employee employee) {
        StringBuilder generatedString = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();

        map.put("capital", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        map.put("numbers", "0123456789");
        map.put("specialChar", "~!@#$%^&*()_+{}<>?:[]");
        map.put("small", "abcdefghijklmnopqrstuvxyz");

        for (Map.Entry<String, String> e : map.entrySet()) {
            Random random = new Random();
            int index = (int) (random.nextFloat() * e.getValue().length());
            generatedString.append(e.getValue().charAt(index));
            index = (int) (random.nextFloat() * e.getValue().length());
            generatedString.append(e.getValue().charAt(index));
        }

        employee.setPassword(generatedString.toString());
    }


    public void showCredentials(Employee employee) {
        System.out.println("Dear " + employee.getFirstName() + " your generated credentials are as follows");
        System.out.println("Email --> " + employee.getEmail());
        System.out.println("Password -->" + employee.getPassword());
    }

}
