package src.loginandsignup;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends Users {

    private analytics report = new analytics();
    public List<shelterImplementation> shelters;
    private Duration duration_per_shelter;
    private int id;
    public boolean RequestManager;
    private static int shelterCounter = 0;

    public List<shelterImplementation> getShelters() {
        return shelters;
    }

    public void setShelters(List<shelterImplementation> shelters) {
        this.shelters = shelters;
    }
 public Admin(){
     shelters = new ArrayList<>();
       
   
     
   
 }
    public Admin(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        shelters = new ArrayList<>();
        
    }
    
    @Override
    public void SignUp(){
        role="admin";
         System.out.println("Enter username, password");
        System.out.print("Username: ");
        username = in.nextLine();
        System.out.print("Password: ");
        password = in.nextLine();
         menu.SignUpandLoginMenu(); 
   

    }
    
    @Override
    public void Login(){
         System.out.println("Enter username, password, and role (Admin / Adopter) for login");
    System.out.print("Username: ");
    username = in.nextLine();
    System.out.print("Password: ");
    password = in.nextLine();

     
        // Validate admin login
        
        if (super.validateLogin(username, password, role)) {
            System.out.println("Login Successful for Admin");
            menu.AdminMenu(this);
        } else{
            System.out.println("Invalid Admin login credentials.");
            menu.SignUpandLoginMenu(); // Re-prompt login/signup
    
        }
    
    }

    private shelterImplementation get_shelter_with_least() {
        if (shelters.isEmpty()) {
            System.out.println("There are no shelters. Add one first.");
            addShelter();
            return shelters.get(0);
        }

        int min = Integer.MAX_VALUE, index_of_shelter = 0;
        for (int i = 0; i < shelters.size(); i++) {
            if (shelters.get(i).getAvailablePets().size() < min) {
                index_of_shelter = i;
                min = shelters.get(i).getAvailablePets().size();
            }
        }
        return shelters.get(index_of_shelter);
    }

    public void add_pet_to_shelter() {
        Scanner scanner = new Scanner(System.in);
        try {
            shelterImplementation shelterWithLeast = get_shelter_with_least();
            boolean idExists;
            System.out.println("Enter Pet ID: ");
            do {
                idExists = false;
                id = scanner.nextInt();
                scanner.nextLine();
                for (Pet p : shelterWithLeast.getAvailablePets()) {
                    if (p.getId() == id) {
                        System.out.println("ID already exists, enter another one:");
                        idExists = true;
                        break;
                    }
                }
            } while (idExists);

            Pet pet = new Pet(id);
            pet.addPet();
            shelterWithLeast.getAvailablePets().add(pet);
        } catch (Exception e) {
            System.out.println("An error occurred while adding a pet: " + e.getMessage());
        }
    }

    public void addShelter() {
        Scanner scanner = new Scanner(System.in);
        try {
            boolean doubleId;
            System.out.println("Enter ID:");
            do {
                doubleId = false;
                id = scanner.nextInt();
                scanner.nextLine();
                for (shelterImplementation i : shelters) {
                    if (i.getId() == id) {
                        doubleId = true;
                        System.out.println("ID already exists, enter another one:");
                        break;
                    }
                }
            } while (doubleId);

            shelterImplementation s = new shelterImplementation(id);
            s.addShelter();
            shelters.add(s);
        } catch (Exception e) {
            System.out.println("An error occurred while adding a shelter: " + e.getMessage());
        }
    }

    public void edit_shelter(String what, String change) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the shelter's ID:");
            id = scanner.nextInt();
            scanner.nextLine();
            boolean noFoundID = true;

            for (shelterImplementation element : shelters) {
                if (element.getId() == id) {
                    element.editShelter(what, change);
                    noFoundID = false;
                    break;
                }
            }
            if (noFoundID) {
                System.out.println("No shelter exists with the entered ID.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while editing a shelter: " + e.getMessage());
        }
    }

    public void delete_shelter(int id) {
        try {
            if (shelters.isEmpty()) {
                System.out.println("There are no shelters to remove.");
                return;
            }

            shelters.removeIf(element -> element.getId() == id);
        } catch (Exception e) {
            System.out.println("An error occurred while deleting a shelter: " + e.getMessage());
        }
    }

    public void print_shelters() {
        try {
            if (shelters.isEmpty()) {
                System.out.println("There are no shelters. Add one first.");
                addShelter();
            }

            for (shelterImplementation element : shelters) {
                System.out.println("Shelter with ID: " + element.getId() + ", Name: " + element.getName());
                System.out.println("Available pets: " + element.getAvailablePets());
            }
        } catch (Exception e) {
            System.out.println("An error occurred while printing shelters: " + e.getMessage());
        }
    }
             public boolean managerequest(Request request, Adopter a) {
        try {
            request.setStatus(false);
            report.setNumOfRequests();
            boolean petNotFound = false;

            for (shelterImplementation element : shelters) {
                if (element.getLocation().equals(request.getShelterLocation())) {
                    if (element.getAvailablePets().isEmpty()) {
                        System.out.println("No pets available in this location.");
                        return request.isStatus();
                    }

                    for (Pet pet : element.getAvailablePets()) {
                        if (pet.getSpecies().equalsIgnoreCase(request.getPetspecies()) &&
                            pet.getBreed().equalsIgnoreCase(request.getPetbreed()) &&
                            pet.getAge() == request.getPetAge()) {
                            report.set_adopted_pets(pet.getBreed()+" "+pet.getSpecies());
                            request.setStatus(true);
                            pet.setEnd();
                            element.set_duration(pet.getStart(), pet.getEnd());
                            element.removepet(pet.getId());
                            report.setNum_of_adoptions_shelters(element);
                            a.setAdoptioncount();
                            displayAnalytics(shelters);
                            return request.isStatus();
                        }
                    }

                    petNotFound = true;
                }
            }

            if (petNotFound) {
                System.out.println("Sorry, we did not find a pet you want.");
            } else {
                System.out.println("No shelters available right now. Come back later.");
            }
            return request.isStatus();
        } catch (Exception e) {
            System.out.println("An error occurred while managing the request: " + e.getMessage());
            return false;
        }
    }

//    public void delete_adopter(int id) {
//        try {
//            boolean removed =.removeIf(adopter -> adopter.getID() == id);
//            if (!removed) {
//                System.out.println("No adopter with such ID exists.");
//            }
//        } catch (Exception e) {
//            System.out.println("An error occurred while deleting an adopter: " + e.getMessage());
//        }
//    }

    public analytics getReport() {
        return report;
    }

    public void setReport(analytics report) {
        this.report = report;
    }

    public void displayAnalytics(List<shelterImplementation> shelters) {
        try {
            System.out.println("---- Analytics Report ----");
            System.out.println("Number of Adoptions per Shelter:");
            report.getNum_of_adoptions_shelters(shelters);

            System.out.println("\nMonthly Adoption Trends:");
            report.get_monthely_trinds();

            System.out.println("\nMost Adopted Pets:");
            report.get_most_adopted();

            System.out.println("\nNumber of Pets in Each Shelter:");
            report.num_of_pets_in_shelter(shelters);

            System.out.println("\nTotal Number of Requests: " + report.get_num_of_requests());

            System.out.println("\nAdoption Rates for Each Shelter:");
            for (shelterImplementation shelter : shelters) {
                System.out.printf("Shelter %s (ID: %d): %.2f%%\n",
                        shelter.getName(),
                        shelter.getId(),
                        report.adoption_rate(shelter) * 100);
            }

            System.out.println("\nAverage Time Spent in Each Shelter:");
            for (shelterImplementation shelter : shelters) {
                System.out.printf("Shelter %s (ID: %d): %.2f days\n",
                        shelter.getName(),
                        shelter.getId(),
                        report.avg(shelter));
            }

            System.out.println("--------------------------");
        } catch (Exception e) {
            System.out.println("An error occurred while displaying analytics: " + e.getMessage());
        }
    }
}

