/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.loginandsignup;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class shelterImplementation {

  
    Duration duration ;
    private final int id;
    private String name;
    private String e_mail;
    private String phoneNumber;
    private String location;
    // private List<shelterImplementation>shelters=new ArrayList<>(); 

    /**
     *
     */
    public  List<Pet>pets;
    private int num_of_adoptions;

    public shelterImplementation(int id, String name, String e_mail, String phoneNumber, String location) {
        this.id = id;
        this.name = name;
        this.e_mail = e_mail;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.pets = new ArrayList<>();
        this.num_of_adoptions = 0;
        duration = Duration.ZERO;
        
        
    }

    public shelterImplementation( int id, String name, String e_mail, String phoneNumber, String location, List<Pet> pets, int num_of_adoptions) {
        
        this.id = id;
        this.name = name;
        this.e_mail = e_mail;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.pets = new ArrayList<>();
        this.num_of_adoptions = 0;
        duration = Duration.ZERO;
        
    }
    
    
    
    

    public shelterImplementation(int id) {
        this.id=id;
        this.pets=new ArrayList<>();
        num_of_adoptions=0;
        duration = Duration.ZERO;
    }

    public Duration getDuration() {
        try{
            return duration;
        } catch(NullPointerException e){
            System.out.println("Average duration is currently unavailable, not enough data has been collected yet.");
            duration = Duration.ZERO;
            return duration;
        }
     
    }


    public int getNum_of_adoptions() {
        
        return num_of_adoptions;
    }


    public void set_duration(LocalDateTime start, LocalDateTime end){
        duration = duration.plus(Duration.between(start, end));
    }
    public void setNum_of_adoptions(int num_of_adoptions) {
    this.num_of_adoptions = num_of_adoptions;
}

    
     public void addShelter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter shelter name");
        name = scanner.nextLine();
        System.out.println("enter the email of shelter");
        e_mail=scanner.nextLine();
        while (e_mail.isEmpty() || !e_mail.contains("@")) {
          System.out.println("Invalid email. Please enter again:");
          e_mail = scanner.nextLine();
      }
        System.out.println("enter phoneNumber");
        phoneNumber = scanner.nextLine();
        System.out.println("where is the location of shelter");
        location=scanner.nextLine();
     }
       
    //  public void editShelter(int shelterId, shelterImplementation updatedShelter) {
    //    for (shelterImplementation shelter : shelters) {
    //        if (shelter.getId() == shelterId) {
    //            shelter.setName(updatedShelter.getName());
    //            shelter.setLocation(updatedShelter.getLocation());
    //        }
    //    }
    public void editShelter(String what,String change){
    switch (what) {
        case "name" :
        name=change;
          break;
        case "location":
        location=change;
          break;
        case "phone":
        phoneNumber=change;
          break;
        case "email":
        e_mail=change;
        default:
        System.out.println("invalid input");
          break;
      }
    }
   

    public static boolean deleteShelterById(int shelterId, List<shelterImplementation> shelterList) {
        for (int i = 0; i < shelterList.size(); i++) {
            if (shelterList.get(i).getId() == shelterId) {
                shelterList.remove(i); // Remove the shelter by index
                System.out.println("Shelter with ID " + shelterId + " has been deleted.");
                return true; // Deletion successful
            }
        }
        System.out.println("Shelter with ID " + shelterId + " not found.");
        return false; // Deletion failed
    }


   
   public void addpet(Pet pet){
       pets.add(pet);
   }

   public void removepet(int id) {
    boolean found = false;
    for (Pet pet : pets) {
        if (pet.getId() == id) {
            Pet.delete(id, pets);
            found = true;
            break;
        }
    }
    if (!found) {
        throw new NoSuchElementException("Pet with ID " + id + " not found.");
    }
}

       
   public  List<Pet> getAvailablePets(){
   return pets;
   //to return copy of list of pet 
   }

   public int getId() {
       return id;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   public String getE_mail() {
       return e_mail;
   }

   public void setE_mail(String e_mail) {
       this.e_mail = e_mail;
   }

   public String getPhoneNumber() {
       return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
       this.phoneNumber = phoneNumber;
   }

   public String getLocation() {
       return location;
   }

   public void setLocation(String location) {
       this.location = location;
   }

//    public List<shelterImplementation> getShelters() {
//        return shelters;
//    }

//    public void setShelters(List<shelterImplementation> shelters) {
//        this.shelters = shelters;
//    }

   public List<Pet> getPets() {
       return pets;
   }

   public void setPets(List<Pet> pets) {
       this.pets = pets;
   }
   
      
}
