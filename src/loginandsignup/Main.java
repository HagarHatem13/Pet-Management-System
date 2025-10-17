/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package src.loginandsignup;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class Main {
    
    public static void main(String[] args) throws IOException {
        
        
         // Initialize the Admin object
        // MainAdmin = new Admin("admin", "123", "admin");
        

        // Initialize the Users object with the MainAdmin
        //Users user = new Users(MainAdmin);

        // Initialize the Menu object
        Menu displayMenu = new Menu();
        
        
                
        // Call the SignUpandLoginMenu method, passing the 'user' object to manage user login/signup
         
       
         
           
        // Write data to file
       // writeToFile();

        // Read data from file
       

    

        
         displayMenu.SignUpandLoginMenu();

    
    




        /**
         try {
            //Read from the file
            FileManager.readFromFile("AdoptionSystem.txt",user.getAdopters(),user.admin.getShelters());

            
            displayMenu.SignUpandLoginMenu();
            // Write back to the file
            FileManager.writeToFile("AdoptionSystem.txt",user.getAdopters(), user.admin.getShelters());

            System.out.println("File operations completed successfully.");
        } catch (IOException e){
            System.err.println("An error occurred during file operations: " + e.getMessage());
            e.printStackTrace();
        }
        
    
    
    }
    */
}
      
        
       
    

    
/**
    
        public void searchPets() {
        System.out.println("\n--- Search Pets ---");
        System.out.print("Enter search query (ID, Name, Species, Breed, Age, or Health Status): ");
        Scanner in = new Scanner(System.in);
        String query = in.nextLine().toLowerCase();

        boolean resultsFound = false;
        for(shelterImplementation shelter: Admin.getShelters())
        for (Pet pet : shelter.getPets()) {
            // Check if the query matches any of the pet's attributes
            if (String.valueOf(pet.getId()).contains(query) ||
                pet.getName().toLowerCase().contains(query) ||
                pet.getSpecies().toLowerCase().contains(query) ||
                pet.getBreed().toLowerCase().contains(query) ||
                String.valueOf(pet.getAge()).contains(query) ||
                pet.getHealthStatus().toLowerCase().contains(query)) {

                // Print matching pet
                System.out.println("Pet ID: " + pet.getId());
                System.out.println("Name: " + pet.getName());
                System.out.println("Species: " + pet.getSpecies());
                System.out.println("Breed: " + pet.getBreed());
                System.out.println("Age: " + pet.getAge());
                System.out.println("Health Status: " + pet.getHealthStatus());
                System.out.println("--------------------------"); // Add a separator between pets
                resultsFound = true;
                
            }
        }
        }
        * */

   
    }

   


    
    
    
    


