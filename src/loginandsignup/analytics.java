/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.loginandsignup;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



/**
 *
 * @author admin
 */
public class analytics {
    
    private LocalDateTime start;
    private LocalDateTime month;
    private int numOfRequests;
    int num_of_adoptions_shelters;
    HashMap<String, Integer> pets = new LinkedHashMap<>();
    public static List<String>petsList = new ArrayList<>();

    public analytics() {
        
        this.start = LocalDateTime.now();
        this.month = start.plusMonths(1);
        pets.put("birman cat", 0);
        pets.put("sherazi cat", 0);
        pets.put("burmese cat", 0);
        pets.put("persian cat", 0);
        pets.put("german Shepherd dog", 0);
        pets.put("bulldog dog", 0);
        pets.put("golden dog", 0);
        pets.put("husky dog", 0);
        pets.put("guenon monkey", 0);
        pets.put("spider monkey", 0);
        pets.put("baboon monkey", 0);
        pets.put("tamarin monkey", 0);
        pets.put("canary bird", 0);
        pets.put("araucana bird", 0);
        pets.put("tippler bird", 0);
        pets.put("cockatiel bird", 0);
    
        numOfRequests = 0;
    }
    
   

    private Map<String, Integer> sort_pets() {
        // Convert the map to a list of entries
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(pets.entrySet());

        // Sort the entries by value in descending order
        try{
        entries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
            // Create a LinkedHashMap to preserve the sorted order
            Map<String, Integer> sortedPets = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> entry : entries) {
                sortedPets.put(entry.getKey(), entry.getValue());
                
            }
            
             return sortedPets;
        }catch(NullPointerException e){
            System.out.println("There are no adopted pets yet.");
            return pets;
        }

        
    }

    // Number of adoptions per shelter.
    public void getNum_of_adoptions_shelters(List<shelterImplementation> s) {
        for (shelterImplementation elment : s) {
            System.out.printf("shelter with id %d and name %s have adopted %d", elment.getId(), elment.getName(), elment.getNum_of_adoptions());
        }
    }

    public void setNum_of_adoptions_shelters(shelterImplementation s) {
        num_of_adoptions_shelters = s.getNum_of_adoptions();
        s.setNum_of_adoptions(num_of_adoptions_shelters + 1);
    }

    // Monthly adoption trends.
    public void get_monthely_trinds() {
        if (LocalDateTime.now() == month) {
            System.out.println("this is the adopted pets this month from most to least");
            System.out.println(sort_pets());
            set_new_month();

        } else {
            System.out.println("did not complete a month yet");
        }
    }

    public void set_new_month() {
        month = LocalDateTime.now().plusMonths(1);
    }

    // Adopted pets
    public void set_adopted_pets(String pet_type) {
        if (pets.containsKey(pet_type)) {
            int n = pets.get(pet_type);
            n++;
            pets.put(pet_type, n);
        }
    }

    public void get_most_adopted() {
        System.out.println("this is the adopted pets from most to least");
        System.out.println(sort_pets());
    }

    // Average time in every shelter
    public float avg(shelterImplementation s) {
        float avg = (float) s.getDuration().toSeconds()/ s.getNum_of_adoptions();
        return avg;
    }

    // Number of pets available in each shelter
    public void num_of_pets_in_shelter(List<shelterImplementation> shelters) {
        if (shelters.isEmpty()) {
            System.out.println("there is no shelters add one first");
        } else {
            for (shelterImplementation element : shelters) {
                System.out.println("shelter with id: " + element.getId() + " and name --: " + element.getName() + " has ");
                System.out.println(element.getAvailablePets());
            }
        }
    }

    // Print number of requests
    public int get_num_of_requests() {
        return numOfRequests;
    }

    public void setNumOfRequests() {
        numOfRequests++;
    }

    // Adoption rate
    public float adoption_rate(shelterImplementation s) {
        float rate;
        rate = s.getNum_of_adoptions() / (float) (s.getAvailablePets().size() + s.getNum_of_adoptions());
        return rate;
    }

    public static List<String> getPetsList() {
        return petsList;
    }

    public void setPetsList() {
        for(String str: pets.keySet()){
           petsList.add(str);
        }
       
    }

    
    
    
    

}