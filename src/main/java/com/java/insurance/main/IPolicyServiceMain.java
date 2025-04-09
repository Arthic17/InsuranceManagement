package com.java.insurance.main;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Scanner;

import com.java.insurance.dao.IPolicyServiceDao;
import com.java.insurance.dao.IPolicyServiceDaoImpl;
import com.java.insurance.exceptions.PolicyNotFoundException;

public class IPolicyServiceMain {

    static Scanner sc = new Scanner(System.in);
    static IPolicyServiceDao policyService;

    static {
        try {
            policyService = new IPolicyServiceDaoImpl();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error initializing policy service: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Policy Management ---");
            System.out.println("1. Create Policy");
            System.out.println("2. Get Policy by Client ID");
            System.out.println("3. View All Policies");
            System.out.println("4. Update Policy");
            System.out.println("5. Delete Policy");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createPolicyMain();
                    break;
                case 2:
                    getPolicyMain();
                    break;
                case 3:
                    viewAllPoliciesMain();
                    break;
                case 4:
                    updatePolicyMain();
                    break;
                case 5:
                    deletePolicyMain();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }


    
    
    private static void createPolicyMain() {
        try {
            sc.nextLine(); 
            System.out.print("Enter Client ID: ");
            int clientId = sc.nextInt(); sc.nextLine();
            System.out.print("Enter Client Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Contact Info: ");
            String contact = sc.nextLine();
            System.out.print("Enter Policy Name: ");
            String policy = sc.nextLine();

            boolean result = policyService.createPolicy(clientId, name, contact, policy);
            System.out.println(result ? " Policy Created" : " Failed to create policy");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    private static void getPolicyMain() {
        try {
            System.out.print("Enter Client ID: ");
            int clientId = sc.nextInt();
            String policy = policyService.getPolicy(clientId);
            if (policy == null) {
                throw new PolicyNotFoundException("No policy found for client ID: " + clientId);
            }
            System.out.println("Policy for Client ID " + clientId + ": " + policy);
        } catch (SQLException | PolicyNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewAllPoliciesMain() {
        try {
            Collection<String> policies = policyService.getAllPolicies();
            if (policies.isEmpty()) {
                System.out.println(" No policies found.");
            } else {
                System.out.println("Policies:");
                for (String p : policies) {
                    System.out.println("- " + p);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void updatePolicyMain() {
        try {
            System.out.print("Enter Client ID to update: ");
            int clientId = sc.nextInt(); sc.nextLine();
            System.out.print("Enter New Policy Name: ");
            String newPolicy = sc.nextLine();

            boolean updated = policyService.updatePolicy(clientId, newPolicy);
            System.out.println(updated ? "Policy Updated" : " Failed to update policy");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deletePolicyMain() {
        try {
            System.out.print("Enter Client ID to delete policy: ");
            int clientId = sc.nextInt();
            boolean deleted = policyService.deletePolicy(clientId);
            if (!deleted) {
                throw new PolicyNotFoundException("No policy found for client ID: " + clientId);
            }
            System.out.println("Policy deleted.");
        } catch (SQLException | PolicyNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
