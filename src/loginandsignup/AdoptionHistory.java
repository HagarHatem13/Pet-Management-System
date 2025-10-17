/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.loginandsignup;
import java.util.Date;

/**
 *
 * @author admin
 */
public class AdoptionHistory {
    
            private int adoptionID;
	    private String petName;            
	    private String petType; 
	    private Date adoptionDate;         
	    private boolean adoptionStatus;    
	    private double adoptionFee;        
	    
	    
	 
	  
	    public AdoptionHistory(int adoptionID, String petName, String petType,Date adoptionDate, boolean adoptionStatus, double adoptionFee) {
			this.adoptionID = adoptionID;
			this.petName = petName;
			this.petType = petType;
			this.adoptionDate = adoptionDate;
			this.adoptionStatus = adoptionStatus;
			this.adoptionFee = adoptionFee;
		}

		public int getAdoptionID() {
	        return adoptionID;
	    }

		public void setAdoptionID(int adoptionID) {
	        this.adoptionID = adoptionID;
	    }

	    public String getPetName() {
	        return petName;
	    }

	    public void setPetName(String petName) {
	        this.petName = petName;
	    }

	    public String getPetType() {
	        return petType;
	    }

	    public void setPetType(String petType) {
	        this.petType = petType;
	    }

	    public Date getAdoptionDate() {
	        return adoptionDate;
	    }

	    public void setAdoptionDate(Date adoptionDate) {
	        this.adoptionDate = adoptionDate;
	    }

            public boolean isAdoptionStatus() {
                return adoptionStatus;
            }

            public void setAdoptionStatus(boolean adoptionStatus) {
                this.adoptionStatus = adoptionStatus;
            }

	    

	    public double getAdoptionFee() {
	        return adoptionFee;
	    }

	    public void setAdoptionFee(double adoptionFee) {
	        this.adoptionFee = adoptionFee;
	    }

	    
	    public void displayAdoptionDetails() {
	        System.out.println("Adoption ID: " + adoptionID);
	        System.out.println("Pet Name: " + petName);
	        System.out.println("Pet Type: " + petType);
	        System.out.println("Adoption Date: " + adoptionDate);
	        System.out.println("Adoption Status: " + adoptionStatus);
	        System.out.println("Adoption Fee: $" + adoptionFee);
	    }
    
}
