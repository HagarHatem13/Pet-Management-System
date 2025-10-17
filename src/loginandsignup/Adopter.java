/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.loginandsignup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Adopter extends Users {

    private int ID;
    private String name;
    private String location;
    private int age;
    private ContactInformation contactinfo;
    public List<AdoptionHistory> adoptionHistory;
    private int adoptioncount;
    private static int counter = 0;
    private Request adopterRequest;
    private Adoption adoption;
   

    Scanner in = new Scanner(System.in);

    public Adopter(String username, String password, String role) {
        super(username, password, role);
        this.adoptionHistory = new ArrayList<>();
        ID = counter++;
         this.role = "adopter";
         this.adoptionHistory = new ArrayList<>();
    }
    public Adopter(){
        this.role = "adopter";
        ID = counter++;
        this.adoptionHistory = new ArrayList<>();
    } 
    public Adopter(String username, String password, String role, int ID, String name, String location, int age, ContactInformation contactinfo, List<AdoptionHistory> adoptionHistory) {
        super(username, password, role);
        this.ID = ID;
        this.name = name;
        this.location = location;
        this.age = age;
        this.contactinfo = contactinfo;
        this.adoptionHistory = new ArrayList<>();
             this.role = "adopter";
    }

    public Adopter(String u, String p, String r,int ID, String name, String location, int age, int adoptioncount) {
        this.username= u;
        this.password = p;
        this.role = "adopter";
        this.ID = ID;
        this.name = name;
        this.location = location;
        this.age = age;
        this.adoptioncount = adoptioncount;
        this.adoptionHistory = new ArrayList<>();
    }
    
    
    public void SignUp( ArrayList<Adopter>adopters){
        if (role.equalsIgnoreCase("Adopter")) {
            // Create a new adopter and add to adopters list
        System.out.println("Enter username, password");
        System.out.print("Username: ");
        username = in.nextLine();
        System.out.print("Password: ");
        password = in.nextLine();
       
            
            System.out.println("Adopter signed up successfully!");
            adopters.add(this);
            menu.SignUpandLoginMenu(); // Re-invoke SignUp and Login menu to log in
    }
    }
    
    public void Login(){
//         System.out.println("Enter username, password, and role (Admin / Adopter) for login");
//        System.out.print("Username: ");
//        username = in.nextLine();
//        System.out.print("Password: ");
//        password = in.nextLine();
//        
//        
//        if (role.equalsIgnoreCase("Adopter")) {
//        // Validate adopter login
//        if (super.validateLogin(username, password, role)) {
// 
//            System.out.println("Login Successful for Adopter");
//
//            // Find the adopter from the list
//            for (Adopter adopter : adopters) {
//                if (adopter.getUsername().equals(username)) {
//                    currentAdopter = adopter;
//                    setCurrentAdopter(currentAdopter); // Set the current adopter
//    }
//            }
//        }
//        }
        }

    public void displayPets(List<shelterImplementation> shelterList) {
        try {
            if (shelterList == null || shelterList.isEmpty()) {
                throw new IllegalArgumentException("Shelter list is empty or null.");
            }

            for (shelterImplementation shelter : shelterList) {
                System.out.println("Shelter " + shelter.getName() + " has these pets:");
                for (Pet pet : shelter.getPets()) {
                    System.out.println("Pet name: " + pet.getName());
                    System.out.println("Pet age: " + pet.getAge());
                    System.out.println("Pet species: " + pet.getSpecies());
                    System.out.println("Pet breed: " + pet.getBreed());
                    System.out.println("Pet health status: " + pet.getHealthStatus());
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error displaying pets: " + e.getMessage());
        }
    }

    public void sendrequest() {
        try {
            System.out.println("Choose a pet to adopt:");

            analytics a = new analytics();
            a.setPetsList();

            for (int i = 0; i < analytics.petsList.size(); i++) {
                System.out.printf("%d) %s\n", i + 1, analytics.petsList.get(i));
            }

            int i = in.nextInt();
            if (i < 1 || i > analytics.petsList.size()) {
                throw new IndexOutOfBoundsException("Choice out of range. Please select a valid pet.");
            }

            String species = "";
            String breed = "";
            switch (i) {
                case 1 -> {
                    species = "cat";
                    breed = "birman";
                }
                case 2 -> {
                    species = "cat";
                    breed = "sherazi";
                }
                case 3 -> {
                    species = "cat";
                    breed = "burmese";
                }
                case 4 -> {
                    species = "cat";
                    breed = "persian";
                }
                case 5 -> {
                    species = "dog";
                    breed = "german Shepherd";
                }
                case 6 -> {
                    species = "dog";
                    breed = "bulldog";
                }
                case 7 -> {
                    species = "dog";
                    breed = "golden";
                }
                case 8 -> {
                    species = "dog";
                    breed = "husky";
                }
                case 9 -> {
                    species = "monkey";
                    breed = "guenon";
                }
                case 10 -> {
                    species = "monkey";
                    breed = "spider";
                }
                case 11 -> {
                    species = "monkey";
                    breed = "baboon";
                }
                case 12 -> {
                    species = "monkey";
                    breed = "tamarin";
                }
                case 13 -> {
                    species = "bird";
                    breed = "canary";
                }
                case 14 -> {
                    species = "bird";
                    breed = "araucana";
                }
                case 15 -> {
                    species = "bird";
                    breed = "tippler";
                }
                case 16 -> {
                    species = "bird";
                    breed = "cockatiel";
                }
                default -> throw new IllegalArgumentException("Invalid selection.");
            }

            System.out.println("Please fill out information regarding the pet you want to adopt.");

            System.out.println("Enter the age of the pet:");
            int petAge = in.nextInt();
            if (petAge <= 0) {
                throw new IllegalArgumentException("Pet age must be a positive number.");
            }
            in.nextLine();

            System.out.println("Enter Shelter Location:");
            String location = in.nextLine();
            if (location.isEmpty()) {
                throw new IllegalArgumentException("Shelter location cannot be empty.");
            }

            adopterRequest = new Request(species, breed, location, false, petAge);
            adoption = new Adoption(this);

        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Selection error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error while sending request: " + e.getMessage());
        }
    }

    public Request getAdopterRequest() {
        try {
            if (adopterRequest == null) {
                throw new NullPointerException("Adopter request has not been created yet.");
            }
            return adopterRequest;
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public void displayRequestStatus() {
        try {
            if (this.adopterRequest == null) {
                throw new NullPointerException("No request has been made yet.");
            }
            System.out.println(this.adopterRequest.isStatus());
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
   public void editAdopterProfile() {
    boolean validChoice = false;

    while (!validChoice) {
        System.out.println("Please choose which profile detail you want to edit:");
        System.out.println("1. Name");
        System.out.println("2. Contact Information");
        System.out.println("3. Location");
        System.out.println("4. Age");

        int choice = in.nextInt();
        in.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.println("Please enter the new name:");
                String adopterName = in.nextLine();
                this.setName(adopterName);
                System.out.println("Your name has been updated successfully.");
                validChoice = true;
                break;

            case 2:
                if (this.contactinfo == null) {
                    this.contactinfo = new ContactInformation();
                    System.out.println("You haven't uploaded any contact information yet.");
                }
                boolean validContactChoice = false;
                while (!validContactChoice) {
                    System.out.println("Which contact information would you like to edit?");
                    System.out.println("1. Phone Number");
                    System.out.println("2. Email");

                    int contactChoice = in.nextInt();
                    in.nextLine(); // Consume newline

                    switch (contactChoice) {
                        case 1:
                            System.out.println("Enter your new phone number:");
                            String phoneNumber = in.nextLine();
                            while (!phoneNumber.matches("\\d+")) { // Validate phone number (digits only)
                                System.out.println("Invalid phone number. Please enter digits only:");
                                phoneNumber = in.nextLine();
                            }
                            this.contactinfo.setPhonenumber(phoneNumber);
                            System.out.println("Your phone number has been updated successfully.");
                            validContactChoice = true;
                            break;

                        case 2:
                            System.out.println("Enter your new email:");
                            String email = in.nextLine();
                            while (!email.contains("@") || !email.endsWith(".com")) { // Validate email format
                                System.out.println("Invalid email format! Please re-enter:");
                                email = in.nextLine();
                            }
                            this.contactinfo.setEmailaddress(email);
                            System.out.println("Your email has been updated successfully.");
                            validContactChoice = true;
                            break;

                        default:
                            System.out.println("Invalid choice. Please choose 1 or 2.");
                            break;
                    }
                }
                validChoice = true;
                break;

            case 3:
                System.out.println("Enter your new location:");
                String newLocation = in.nextLine();
                this.setLocation(newLocation);
                System.out.println("Your location has been updated successfully.");
                validChoice = true;
                break;

            case 4:
                System.out.println("Enter your new age:");
                int newAge = in.nextInt();
                in.nextLine(); // Consume newline
                this.setAge(newAge);
                System.out.println("Your age has been updated successfully.");
                validChoice = true;
                break;

            default:
                System.out.println("Invalid choice. Please choose 1, 2, 3, or 4.");
                break;
        }
    }
}

    
   

    
    public  void displayAdoptionHistory(){
        if(this.adoptionHistory == null){
            System.out.println("Your Adoption History is Empty, you haven't adopted any pets.");
        }else{
            for(AdoptionHistory history: adoptionHistory){
                history.displayAdoptionDetails();
            }
        }
    }
    
   
    
    public void displayAdopterProfileInfo(){
        System.out.println("Your profile Details:");
        System.out.println("Username: " + this.username);
        if(this.name == null){
            System.out.println("You haven't uploaded your full name yet.");
        }else
            System.out.println("Name: " + this.name);
        if(this.age == 0)
            System.out.println("You haven't uploaded your age yet.");
        else
            System.out.println("Age: " + this.age);
        if(this.location == null)
            System.out.println("You haven't uploaded your location yet.");
        else
            System.out.println("Location: " + this.location);
        if(this.contactinfo == null){
            System.out.println("You haven't uploaded your contact information yet.");
        }else{
            System.out.println("Contact Information: ");
            this.contactinfo.displayContactInformation();
        }
    }
    
    
        
       



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   

    public int getAdoptioncount() {
        return adoptioncount;
    }

    public void setAdoptioncount() {
        this.adoptioncount++;
    }

    public ContactInformation getContactinfo() {
        return contactinfo;
    }

    public void setContactinfo(ContactInformation contactinfo) {
        this.contactinfo = contactinfo;
    }

    public List<AdoptionHistory> getAdoptionHistory() {
        return adoptionHistory;
    }

    public void setAdoptionHistory(List<AdoptionHistory> adoptionHistory) {
        this.adoptionHistory = adoptionHistory;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void searchPets() {
        System.out.println("\n--- Search Pets ---");
        System.out.print("Enter search query (Name, Species, Breed, Age, or Health Status): ");
        Scanner in = new Scanner(System.in);
        String query = in.nextLine().toLowerCase();

        boolean resultsFound = false;
        for(shelterImplementation shelter: Menu.admin.getShelters())
        for (Pet pet : shelter.getPets()) {
            // Check if the query matches any of the pet's attributes
            if (
                pet.getName().toLowerCase().contains(query) ||
                pet.getSpecies().toLowerCase().contains(query) ||
                pet.getBreed().toLowerCase().contains(query) ||
                String.valueOf(pet.getAge()).contains(query) ||
                pet.getHealthStatus().toLowerCase().contains(query)) {

                // Print matching pet
               
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

    @Override
    public void SignUp() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
//    @Override
////    public void SignUp() {
////        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
////    }
//  
//    }
//    
    

   
    
        
    

