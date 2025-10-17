/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.loginandsignup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class Adoption {
    private Adopter adopter;
    private Request adoptionRequest;
    private int adoptionID;
    private static int adoptionCounter = 0;
    public static List<Adoption> adoptions = new ArrayList<>();
    
    
    

    public Adoption(Adopter adopter)
    {   
        this.adopter = adopter;
        adoptionCounter++;
        adoptionID = adoptionCounter;
        this.adoptionRequest = adopter.getAdopterRequest();
        sendRequestToAdmin(Menu.admin);
        
    } 
    
    public void sendRequestToAdmin(Admin admin) {
        admin.managerequest(adoptionRequest, adopter);
        sendRequestToAdopter();
    }
    
    public boolean receiveRequestStatus() {
        return adoptionRequest.isStatus();
    }

    public void sendRequestToAdopter() {
        if (adoptionRequest.isStatus()) {
            adopter.setAdoptioncount();
            /**
            Adoption newAdoption = new Adoption();
            newAdoption.adopter = this.adopter;
            newAdoption.pet = pet;
            newAdoption.requestStatus = this.requestStatus;
            newAdoption.adoptionRequest = this.adoptionRequest;
            newAdoption.adoptionID = adoptionCounter;
            adoptions.add(newAdoption);
            * */
            Date currentDate = new Date();
            AdoptionHistory adoptHistory = new AdoptionHistory(adoptionID, adoptionRequest.getPetspecies(),adoptionRequest.getPetbreed(), currentDate, adoptionRequest.isStatus(), 100);
            adopter.adoptionHistory.add(adoptHistory);
            System.out.println("Adoption successful!");
        }
        else
            System.out.println ("Adoption request denied.");
    } 
    
    public static void displayAllAdoptions(){
        System.out.println("The total number of adoptions is: " + adoptionCounter);
        System.out.println("All Adoptions that have occured: ");
        System.out.println(adoptions);
    }
}


