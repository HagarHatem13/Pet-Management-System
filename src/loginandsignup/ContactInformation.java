/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.loginandsignup;

/**
 *
 * @author admin
 */
public class ContactInformation {
    
    private String phonenumber;
    private String emailaddress;
   

    public ContactInformation() {
    }
    
    
                
    public ContactInformation(String phonenumber, String emailaddress) {
        this.phonenumber = phonenumber;
        this.emailaddress = emailaddress;
		
	}
    
   public void setContactInformation(String phonenumber, String emailaddress) {
        this.phonenumber = phonenumber;
        this.emailaddress = emailaddress;	
   }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

   

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

   
    
		
     public void displayContactInformation(){
        System.out.println("Phone number: " + this.phonenumber);
        System.out.println("Email Address: " + this.emailaddress);
    }
    
}
