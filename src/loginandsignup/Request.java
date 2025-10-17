/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.loginandsignup;

/**
 *
 * @author admin
 */
public class Request {
    
    
    private String petspecies;
    private String petbreed;
    private String shelterLocation;
    private boolean status;
    private int petAge;

    

    
   
    public Request( String petspecies, String petbreed,String shelterLocation, boolean status, int petAge) {
               
		this.petspecies = petspecies;
		this.petbreed = petbreed;
                this.shelterLocation = shelterLocation;
		this.status = status;
		this.petAge = petAge;
	}


	public String getPetspecies() {
        return petspecies;
    }

    public void setPetspecies(String petspecies) {
        this.petspecies = petspecies;
    }

    
    public String getPetbreed() {
        return petbreed;
    }

    public void setPetbreed(String petbreed) {
        this.petbreed = petbreed;
    }

    
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

   
    public int getPetAge() {
        return petAge;
    }

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    

    public String getShelterLocation() {
        return shelterLocation;
    }

    public void setShelterLocation(String shelterLocation) {
        this.shelterLocation = shelterLocation;
    }
	   
     

    
}

