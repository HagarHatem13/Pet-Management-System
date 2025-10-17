/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.loginandsignup;


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author admin
 */
abstract public class Users {
    
    protected String username;
    protected String password;
    protected String role;
    protected Adopter currentAdopter;
    
   

    public Adopter getCurrentAdopter() {
        return currentAdopter;
    }

    public void setCurrentAdopter(Adopter currentAdopter) {
        this.currentAdopter = currentAdopter;
    }

    
    
    

    
    
   
    Scanner in = new Scanner(System.in);
    
    protected static final Menu menu = new Menu();

    public Users() {
    }
    
    

   
    
    public Users(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    
    
    
    // Modified SignUp method
   abstract public void SignUp();/* {
    System.out.println("Enter username, password, and role for sign-up");
    System.out.print("Username: ");
    username = in.nextLine();
    System.out.print("Password: ");
    password = in.nextLine();
    System.out.print("Role: ");
    role = in.nextLine();

    // Check if user already exists
    if (userAdopterExists(username)) {
        System.out.println("User already exists. Please login.");
        menu.SignUpandLoginMenu(this); // Re-invoke SignUp and Login menu to log in
    } else {
        // Handle admin role signup
        if (role.equalsIgnoreCase("Admin")) {
            System.out.println("Admin signed up successfully!");
            menu.SignUpandLoginMenu(this); // Re-invoke SignUp and Login menu to log in
        } else if (role.equalsIgnoreCase("Adopter")) {
            // Create a new adopter and add to adopters list
            Adopter adopter = new Adopter(username, password, role);
            addUserAdopter(adopter);
            
            System.out.println("Adopter signed up successfully!");
            menu.SignUpandLoginMenu(this); // Re-invoke SignUp and Login menu to log in
        } else {
            System.out.println("Invalid role! Please enter Admin or Adopter.");
            menu.SignUpandLoginMenu(this); // If role is invalid, prompt again
        }
    
*/

public void logout(){
    
    
}
    
  // Modified Login method
 public abstract void Login(); /*{
    System.out.println("Enter username, password, and role (Admin / Adopter) for login");
    System.out.print("Username: ");
    username = in.nextLine();
    System.out.print("Password: ");
    password = in.nextLine();
    System.out.print("Role: ");
    role = in.nextLine();

    if (role.equalsIgnoreCase("Admin")) {
        // Validate admin login
        if (validateLogin(username, password, role)) {
            System.out.println("Login Successful for Admin");
            menu.AdminMenu(admin);
        } else {
            System.out.println("Invalid Admin login credentials.");
            menu.SignUpandLoginMenu(this); // Re-prompt login/signup
        }
    } else if (role.equalsIgnoreCase("Adopter")) {
        // Validate adopter login
        if (validateLogin(username, password, role)) {
            System.out.println("Login Successful for Adopter");

            // Find the adopter from the list
            for (Adopter adopter : adopters) {
                if (adopter.getUsername().equals(username)) {
                    currentAdopter = adopter;
                    setCurrentAdopter(currentAdopter); // Set the current adopter
                    break;
                }
            }

            if (currentAdopter != null) {
                menu.AdopterMenu(currentAdopter, admin); // Redirect to Adopter Menu after login
            } else {
                System.out.println("Adopter not found!");
                menu.SignUpandLoginMenu(this); // Prompt to login/signup again if adopter not found
            }
        } else {
            System.out.println("Invalid Adopter login credentials.");
            menu.SignUpandLoginMenu(this); // Re-prompt login/signup
        }
    } else {
        System.out.println("Invalid role entered.");
        menu.SignUpandLoginMenu(this); // If invalid role, prompt again
    }
}

*/



   protected boolean validateLogin(String username, String password, String role) {
    if (role.equalsIgnoreCase("admin")) {
        // Validate admin login
        return menu.admin.getUsername().equals(username) && menu.admin.getPassword().equals(password) && menu.admin.getRole().equals(role);
    } else if (role.equalsIgnoreCase("adopter")) {
        // Validate adopter login
        for (Adopter adopter : Menu.getPrivateadopters()) {
            if (adopter.username.equals(username) &&
                adopter.password.equals(password) &&
                adopter.role.equalsIgnoreCase(role)) {
                currentAdopter = adopter; // Assign currentAdopter
                return true;
            }
        }
    }
    return false; // Return false if no match is found
}
protected boolean userAdopterExists(String username){
//       for(Adopter adopter: Men){
//           if(username.equals(adopter.username))
//               return true;
//       }
//       return false;
//   }

    
//    public void addUserAdopter(Adopter adopter){
//        adopters.add(adopter);
//    }
    
//   protected boolean userAdopterExists(String username){
//       for(Adopter adopter: Men){
//           if(username.equals(adopter.username))
//               return true;
//       }
//       return false;
//   }
    
    //protected void addUser(Adopter adopter){};
        return false;
//       for(Adopter adopter: Men){
//           if(username.equals(adopter.username))
//               return true;
//       }
//       return false;
//   }

    
//    public void addUserAdopter(Adopter adopter){
//        adopters.add(adopter);
//    }
    
//   protected boolean userAdopterExists(String username){
//       for(Adopter adopter: Men){
//           if(username.equals(adopter.username))
//               return true;
//       }
//       return false;
//   }
    
    //protected void addUser(Adopter adopter){};
}
   public String getUsername() {
      return username;
   }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public ArrayList<Adopter> getAdopters() {
//        return adopters;
//    }
//
//    public void setAdopters(ArrayList<Adopter> adopters) {
//        this.adopters = adopters;
//    }

    


    
    
            

  
    
}
