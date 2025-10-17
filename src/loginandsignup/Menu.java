/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.loginandsignup;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Menu {

    private int choice;
    private static ArrayList<Adopter> adopters;

    public static ArrayList<Adopter> getPrivateadopters() {
        return adopters;
    }

    public static void setPrivateadopters(ArrayList<Adopter> privateadopters) {
        Menu.adopters = privateadopters;
    }
    
    static Admin admin;
    Scanner in = new Scanner(System.in);
    private char answer;
    private boolean validChoice = false;
    int id;
   // private String  Role;
    

//    public Menu(Users user) {
//        this.user = user;
//    }

    public Menu() {
      adopters= new ArrayList<>();
    }

    public void SignUpandLoginMenu() {
        
        System.out.println("Welcome to Adorapet!");

        System.out.println("Choose to login or sign-up.");
        System.out.println("/////////////////////////////");
        System.out.println("//////// 1. Sign-Up /////////");
        System.out.println("//////// 2. Login   /////////");
        System.out.println("/////////////////////////////");

        try {
            choice = in.nextInt();
            in.nextLine(); // Consume the newline
String Role ;
            switch (choice) {
                
                case 1: {//
                    validChoice = true;
                    System.out.println("Enter the Role:");
                    Role=in.nextLine();
                    if(Role.equalsIgnoreCase("admin"))
                        if(admin==null){//
                        admin = new Admin();
                        admin.SignUp();
                        }else{
                            System.out.print("alreadt exist pls log in");
                            admin.Login();
                        }
                    else if(Role.equalsIgnoreCase("adopter")){
                       Adopter a = new Adopter();
                       a.SignUp(adopters);//ok
                       
                    }
                         // Ensure SignUp manages its flow properly
                    break;
                }
                  case 2: {
                   validChoice = true;
                    System.out.println("Enter the Role:");
                    Role=in.nextLine();
                     if(Role.equalsIgnoreCase("admin")){
                          if(admin!=null){//
                      admin.Login();
                        }else{
                          System.out.println("admin does not exest sign up:");
                           admin = new Admin();
                        admin.SignUp();
                     }
                          
                  }else if(Role.equalsIgnoreCase("adopter")){
                  if(!adopters.isEmpty()){
                  System.out.println("Enter username, password, and role (Adopter) for login");
                   System.out.print("Username: ");
               String username = in.nextLine();
                 System.out.print("Password: ");
                   String password = in.nextLine();
                  for (Adopter adopter : adopters) {
                if (adopter.username.equals(username) &&
                adopter.password.equals(password)){
               this.AdopterMenu(adopter);
                  }
                  }
                  
                  }
                  else{System.out.println("no adopters");}
                  
                  } break;}
                default: {
                    System.out.println("Invalid choice entered. Please enter 1 or 2 for Sign-Up or Login.");
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a numeric value (1 or 2).");
            in.nextLine(); // Clear invalid input
        } 
    }

    public void AdminMenu(Admin MainAdmin) {
        do {
            try {
                System.out.println("//////////////////////////////////////////");
                System.out.println("/////     1. Add Shelter             /////");
                System.out.println("/////     2. Edit Shelter            /////");
                System.out.println("/////     3. Delete Shelter          /////");
                System.out.println("/////     4. Add Pets To Shelters    /////");
                System.out.println("/////     5. Print Shelter           /////");
                System.out.println("/////     6. Delete Adopter          /////");
                System.out.println("/////     7. View Analytics          /////");
                System.out.println("/////     8. Display Total Adoptions /////");
                 System.out.println("/////    9.log out /////");
               
               
                System.out.println("//////////////////////////////////////////");

                choice = in.nextInt();
                in.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1: {
                        MainAdmin.addShelter();
                        validChoice = true;
                        break;
                    }
                    case 2: {
                        System.out.println("Enter the shelter detail you want to change:");
                        String want = in.nextLine().toLowerCase();
                        System.out.println("Enter the updated detail:");
                        String change = in.nextLine().toLowerCase();
                        MainAdmin.edit_shelter(want, change);
                        validChoice = true;
                        break;
                    }
                    case 3: {
                        System.out.println("Enter Shelter id you want to delete: ");
                        int id = in.nextInt();
                        in.nextLine();
                        MainAdmin.delete_shelter(id);
                        validChoice = true;
                        break;
                    }
                    case 4: {
                        MainAdmin.add_pet_to_shelter();
                        validChoice = true;
                        break;
                    }
                    case 5: {
                        MainAdmin.print_shelters();
                        validChoice = true;
                        break;
                    }
                    case 6: {
                        System.out.println("Enter id of adopter you want to delete:");
                        id = in.nextInt();
                        in.nextLine();
                      //  MainAdmin.delete_adopter(id);
                        validChoice = true;
                        break;
                    }
                    case 7: {
                        MainAdmin.displayAnalytics(MainAdmin.getShelters());
                        validChoice = true;
                        break;
                    }
                    case 8: {
                        Adoption.displayAllAdoptions();
                        validChoice = true;
                        break;
                    }
                    case 9:{
                      this.SignUpandLoginMenu();
                    }
                    
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a numeric value between 1 and 8.");
                in.nextLine(); // Clear invalid input
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }

            System.out.print("Would you like to perform another operation? (y/n): ");
            answer = in.next().charAt(0);
            in.nextLine(); // Consume the newline

        } while (answer == 'y' || answer == 'Y');
    }

    public void AdopterMenu(Adopter adopter){
        do {
            try {
                System.out.println("///////////////////////////////////////");
                System.out.println("/////  1. Edit Personal Details    /////");
                System.out.println("/////  2. Display Profile Details  /////");
                System.out.println("/////  3. Send Adoption Request    /////");
                System.out.println("/////  4. Display Pets             /////");
                System.out.println("/////  5. Search for pets          /////");
                System.out.println("/////  6. Display Adoption History /////");
                System.out.println("/////  7. Display Request Status   /////");
                  System.out.println("/////    8.log out /////");
                System.out.println("////////////////////////////////////////");
                System.out.print("Enter your choice: ");

                choice = in.nextInt();
                in.nextLine(); // Consume the newline character after the choice

                switch (choice) {
                    case 1:
                        adopter.editAdopterProfile();
                        validChoice = true;
                        break;
                    case 2:
                        adopter.displayAdopterProfileInfo();
                        validChoice = true;
                        break;
                    case 3:
                        adopter.sendrequest();
                        validChoice = true;
                        break;
                    case 4: {
                        adopter.displayPets(admin.getShelters());
                        validChoice = true;
                        break;
                    }case 5:{
                    adopter.searchPets();}
                    case 6: {
                        adopter.displayAdoptionHistory();
                        validChoice = true;
                        break;
                    }
                    case 7: {
                        adopter.displayRequestStatus();
                        validChoice = true;
                        break;
                    }
                    case 8:{
                        this.SignUpandLoginMenu();
                        break;
                    }
                  
                    default:
                        System.out.println("Invalid choice entered. Please enter 1, 2, 3, 4, 5, 6, or 7.");
                        break;
                }

                if (validChoice) {
                    System.out.print("Would you like to perform another operation? (y/n): ");
                    answer = in.next().charAt(0);
                    in.nextLine();
                } else {
                    answer = 'n';
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a numeric value for your choice.");
                in.nextLine(); // Clear invalid input
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        } while (answer == 'y' || answer == 'Y');
    }
}