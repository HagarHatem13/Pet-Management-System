/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.loginandsignup;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Pet {
    
    private LocalDateTime start;
    private LocalDateTime end;
    private final int id;
    private String name;
    private String species;
    private String breed;
    private int age;
    private String healthStatus;
    private boolean isAvailable = true;

    public Pet(int id, String name, String species, String breed, int age, String healthStatus, boolean isAvailable) {
        this.start = LocalDateTime.now();
        this.id = id;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.healthStatus = healthStatus;
        this.isAvailable = isAvailable;
    }

    public Pet(int id, String name, String species, String breed, int age, String healthStatus) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.healthStatus = healthStatus;
        this.start = LocalDateTime.now();
    }
    
    

    
   
    
    

    
     public Pet(int id) {
       this.id=id;
       start=LocalDateTime.now();
    }
     
    protected void addPet(){
         Scanner scanner = new Scanner(System.in);
         System.out.println("enter pet name");
          name=scanner.nextLine().toLowerCase();
          System.out.println("enter pet species");
          species=scanner.nextLine().toLowerCase();
          System.out.println("enter "+species+" breed");
          breed =scanner.nextLine().toLowerCase();
          System.out.println("enter the "+breed+" "+species+" age");
          age = scanner.nextInt();
          scanner.nextLine();
          System.out.println("Enter health status: ");
          healthStatus = scanner.nextLine();
          
          
          System.out.println("Pet has been added successfully !");
          
          
    }
    
    public static boolean delete(int petId, List<Pet> petList) {
        for (int i = 0; i < petList.size(); i++) {
            if (petList.get(i).getId() == petId) {
                petList.remove(i); // Remove the pet by index
                System.out.println("Pet with ID " + petId + " has been deleted.");
                return true; // Deletion successful
            }
        }
        System.out.println("Pet with ID " + petId + " not found.");
        return false; // Deletion failed
}
     
     
        protected static void editPet(Pet pet, String choice, String updatedFeature) {
            // Edit the in-memory pet object
            switch (choice.toLowerCase()) {
                case "name":
                    pet.setName(updatedFeature);
                    break;

                case "age":
                    try {
                        int updatedAge = Integer.parseInt(updatedFeature);
                        pet.setAge(updatedAge);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age format.");
                    }
                    break;

                case "healthstatus":
                    pet.setHealthStatus(updatedFeature);
                    break;

                case "availability":
                     if (updatedFeature.equalsIgnoreCase("yes")) {
                    pet.setAvailable(true);
                    break;
                }else if (updatedFeature.equalsIgnoreCase("no")) {
                    pet.setAvailable(false);
                    break;
                }

                default:
                    System.out.println("Invalid option.");
                    
            }
            

        }
        
        
        
   
    /**private void updatePetsFile() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(Pets))) {
        for (Pet pet : pets) {
            writer.write(pet.getId() + "," + pet.getName() + "," + pet.getSpecies() + "," + pet.getBreed() + "," + pet.getAge() + "," + pet.getHealthStatus() + "," + (pet.isAvailable() ? "Yes" : "No"));
            writer.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
  }**/
        
       /** protected void addPet(String id, String name, String species, String breed, int age, String healthStatus){
        Pet pet = new Pet(id,name,species,breed,age,healthStatus);
        pets.add(pet);
        
         try (BufferedWriter writer = new BufferedWriter(new FileWriter(Pets, true))) {
            writer.write(id + "," + name + "," + species + "," + breed + "," + age + "," + healthStatus + ",Yes");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
     * @return }**/
    
    // Getters and Setters
    public LocalDateTime getStart() {
        return start;
    }
    

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd() {
        end=LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Species: " + species +
                ", Breed: " + breed + ", Age: " + age +
                ", Health Status: " + healthStatus +
                ", Available: " + (isAvailable ? "Yes" : "No");
    }
}

