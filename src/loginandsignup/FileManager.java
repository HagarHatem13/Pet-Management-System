/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.loginandsignup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */


public class FileManager {
    
     
/**
/ Method to read data from a file
    public static void readFromFile(
            String fileName,
            List<Adopter> adopters,
            List<shelterImplementation> shelters
    ) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            shelterImplementation currentShelter = null;

            while ((line = reader.readLine()) != null) {
                // Parse Adopter data
                if (line.startsWith("Adopters:")) {
                    while ((line = reader.readLine()) != null && !line.isBlank()) {
                        String[] parts = line.split(", ");
                        String username = getValueFromString(parts[0]);
                        String password = getValueFromString(parts[1]);
                        String role = getValueFromString(parts[2]);
                        int id = Integer.parseInt(getValueFromString(parts[3]));
                        String name = getValueFromString(parts[4]);
                        String location = getValueFromString(parts[5]);
                        int age = Integer.parseInt(getValueFromString(parts[6]));

                        Adopter adopter = new Adopter(username, password, role, id, name, location, age, null, new ArrayList<>());
                        adopters.add(adopter);
                    }
                } 
                // Parse Shelter data
                else if (line.startsWith("Shelter Name:")) {
                    String name = getValueFromString(line);
                    currentShelter = new shelterImplementation(0, name, "", "", "");
                    shelters.add(currentShelter);
                } 
                // Parse Pets for the shelter
                else if (line.startsWith("Pet ID:") && currentShelter != null) {
                    String[] petDetails = line.split(", ");
                    int id = Integer.parseInt(getValueFromString(petDetails[0]));
                    String name = getValueFromString(petDetails[1]);
                    String species = getValueFromString(petDetails[2]);

                    Pet pet = new Pet(id, name, species, "", 0, "", true);
                    currentShelter.getPets().add(pet);
                }
                // Parse Shelter attributes in CSV format
                else if (line.startsWith("Shelters:")) {
                    continue;  // Skip or handle if needed
                }
            }
        }
    }
    * */

    // Helper method to extract value from a string (after the ": ")
    private static String getValueFromString(String str) {
        return str.split(": ")[1];
    }

    // Method to write data to a file
    public static void writeToFile(
            String fileName,
            List<Adopter> adopters,
            List<shelterImplementation> shelters
    ) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Writing Adopters data
            writer.write("Adopters:");
            writer.newLine();
            for (Adopter adopter : adopters) {
                writer.write("Username: " + adopter.getUsername() + ", Password: " + adopter.getPassword() +
                             ", Role: " + adopter.getRole() + ", ID: " + adopter.getID() + ", Name: " +
                             adopter.getName() + ", Location: " + adopter.getLocation() + ", Age: " + adopter.getAge());
                writer.newLine();
            }
            writer.newLine();

            // Writing Shelter and Pet data
            writer.write("Shelters and their pets:");
            writer.newLine();
            for (shelterImplementation shelter : shelters) {
                writer.write("Shelter Name: " + shelter.getName());
                writer.newLine();
                for (Pet pet : shelter.getPets()) {
                    writer.write("Pet ID: " + pet.getId() + ", Name: " + pet.getName() + ", Species: " + pet.getSpecies());
                    writer.newLine();
                }
                writer.newLine();
            }

            // Writing Shelter attributes in CSV format
            writer.write("Shelters:");
            writer.newLine();
            for (shelterImplementation shelter : shelters) {
                writer.write(shelter.getId() + "," +
                             shelter.getName() + "," +
                             shelter.getE_mail() + "," +
                             shelter.getPhoneNumber() + "," +
                             shelter.getLocation());
                writer.newLine(); // Add a new line for the next shelter
            }

            // Ensure the data is actually written to the file
            writer.flush();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
    // Read data from file
    public static void readFromFile(String fileName, List<shelterImplementation> shelters, List<Adopter> adopters) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            shelterImplementation currentShelter = null;

            while ((line = br.readLine()) != null) {
                if (line.startsWith("Shelters:")) {
                    continue; // Skip the header
                } else if (line.startsWith("Adopters:")) {
                    break; // Switch to adopters section
                } else if (line.startsWith("ShelterID")) {
                    // Parse shelter details
                    String[] shelterData = line.split(", ");
                    currentShelter = new shelterImplementation(
                            Integer.parseInt(shelterData[0]),
                            shelterData[1],
                            shelterData[2],
                            shelterData[3],
                            shelterData[4],
                            Integer.parseInt(shelterData[5])
                    );
                    shelters.add(currentShelter);
                } else if (!line.trim().isEmpty() && currentShelter != null) {
                    // Parse pet details
                    String[] petData = line.split(", ");
                    Pet pet = new Pet(
                            Integer.parseInt(petData[0]),
                            petData[1],
                            petData[2],
                            petData[3],
                            Integer.parseInt(petData[4]),
                            petData[5]
                    );
                    currentShelter.getPets().add(pet); // Assuming a getPets() method exists
                } else if (!line.trim().isEmpty()) {
                    // Parse adopter details
                    String[] adopterData = line.split(", ");
                    Adopter adopter = new Adopter(
                            adopterData[0],
                            adopterData[1],
                            adopterData[2],
                            Integer.parseInt(adopterData[3]),
                            adopterData[4],
                            adopterData[5],
                            Integer.parseInt(adopterData[6]),
                            Integer.parseInt(adopterData[7])
                    );
                    adopters.add(adopter);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Write data to file
    public static void writeToFile(String fileName, List<shelterImplementation> shelters, List<Adopter> adopters) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            // Write shelters and pets
            bw.write("Shelters:\n");
            for (shelterImplementation shelter : shelters) {
                bw.write(String.format("ShelterID: %d, Name: %s, Email: %s, Phone: %s, Location: %s, Adoptions: %d\n",
                        shelter.getId(), shelter.getName(), shelter.getE_mail(), shelter.getPhoneNumber(),
                        shelter.getLocation(), shelter.getNum_of_adoptions()));
                for (Pet pet : shelter.getPets()) { // Assuming a getPets() method exists
                    bw.write(String.format("%d, %s, %s, %s, %d, %s\n",
                            pet.getId(), pet.getName(), pet.getSpecies(), pet.getBreed(),
                            pet.getAge(), pet.getHealthStatus()));
                }
            }

            // Write adopters
            bw.write("Adopters:\n");
            for (Adopter adopter : adopters) {
                bw.write(String.format("%s, %s, %s, %d, %s, %s, %d, %d\n",
                        adopter.getUsername(), adopter.getPassword(), adopter.getRole(),
                        adopter.getID(), adopter.getName(), adopter.getLocation(),
                        adopter.getAge(), adopter.getAdoptioncount()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
/**
    // Method to write adopters and shelters to a file
    public void writeToFile(String fileName, List<Adopter> adopters, List<shelterImplementation> shelters, File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(adopters);
            oos.writeObject(shelters);
            System.out.println("Data successfully written to file");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read adopters and shelters from a file
    public static void readFromFile(String fileName, List<Adopter> adopters, List<shelterImplementation> shelters) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("output.dat"))) {
            adopters.clear();
            shelters.clear();

            adopters.addAll((List<Adopter>) ois.readObject());
            shelters.addAll((List<shelterImplementation>) ois.readObject());
            System.out.println("Data successfully read from file");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: ");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}
* 
* /

//public class FileManager {
    
    /**
    // Method to read data from a file
public static void readFromFile(
    String fileName,
    List<Adopter> adopters,
    List<shelterImplementation> shelters
) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        String line;
        shelterImplementation currentShelter = null;
        
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Adopters:")) {
                while ((line = reader.readLine()) != null && !line.isBlank()) {
                    String[] parts = line.split(", ");
                    String username = parts[0].split(": ")[1];
                    String password = parts[1].split(": ")[1];
                    String role = parts[2].split(": ")[1];
                    int id = Integer.parseInt(parts[3].split(": ")[1]);
                    String name = parts[4].split(": ")[1];
                    String location = parts[5].split(": ")[1];
                    int age = Integer.parseInt(parts[6].split(": ")[1]);
                    adopters.add(new Adopter(username, password, role, id, name, location, age, null, new ArrayList<>()));
                }
            } else if (line.startsWith("Shelter Name:")) {
                String[] parts = line.split(": ");
                currentShelter = new shelterImplementation(0, parts[1], "", "", "");
                shelters.add(currentShelter);
            } else if (line.startsWith("Pet ID:") && currentShelter != null) {
                String[] petDetails = line.split(", ");
                int id = Integer.parseInt(petDetails[0].split(": ")[1]);
                String name = petDetails[1].split(": ")[1];
                String species = petDetails[2].split(": ")[1];
                String breed = petDetails[3].split(": ")[1];
                int age = Integer.parseInt(petDetails[4].split(": ")[1]);
                String healthStatus = petDetails[5].split(": ")[1];

                // Create a new Pet object with all required fields
                Pet pet = new Pet(id, name, species, breed, age, healthStatus);
                currentShelter.getPets().add(pet);
            } else if (line.startsWith("Shelters:")) {
                // Continue parsing shelter attributes
                String[] attributes = line.split(",");
                if (attributes.length == 5) { // Ensure all attributes are present
                    int id = Integer.parseInt(attributes[0]);
                    String name = attributes[1];
                    String email = attributes[2];
                    String phoneNumber = attributes[3];
                    String location = attributes[4];
                    shelterImplementation shelter = new shelterImplementation(id, name, email, phoneNumber, location);
                    shelters.add(shelter);
                }
            }
        }
    }
}
**
// Method to write data to a file
public static void writeToFile(
    String fileName,
    List<Adopter> adopters,
    List<shelterImplementation> shelters
) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
        // Writing Adopters data
        writer.write("Adopters:");
        writer.newLine();
        for (Adopter adopter : adopters) {
            writer.write("Username: " + adopter.getUsername() + ", Password: " + adopter.getPassword() + ", Role: " + adopter.getRole()
                    + ", ID: " + adopter.getID() + ", Name: " + adopter.getName() + ", Location: " + adopter.getLocation() + ", Age: " + adopter.getAge());
            writer.newLine();
        }
        writer.newLine();
        
        // Writing Shelter and Pet data
        for (shelterImplementation shelter : shelters) {
            writer.write("Shelter Name: " + shelter.getName());
            writer.newLine();
            for (Pet pet : shelter.getPets()) {
                writer.write("Pet ID: " + pet.getId() + ", Name: " + pet.getName() + ", Species: " + pet.getSpecies());
                writer.newLine();
            }
            writer.newLine();
        }

        // Writing Shelter details in CSV format
        for (shelterImplementation shelter : shelters) {
            writer.write(shelter.getId() + "," +
                         shelter.getName() + "," +
                         shelter.getE_mail() + "," +
                         shelter.getPhoneNumber() + "," +
                         shelter.getLocation());
            writer.newLine(); // Add a new line for the next shelter
        }
    }
}
**/
    
    /**
    // Method to read data from a file
    public static void readFromFile(
            String fileName,
            List<Adopter> adopters,
            List<shelterImplementation> shelters
    ) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            shelterImplementation currentShelter = null;

            while ((line = reader.readLine()) != null) {
                // Parse Adopter data
                if (line.startsWith("Adopters:")) {
                    while ((line = reader.readLine()) != null && !line.isBlank()) {
                        String[] parts = line.split(", ");
                        String username = getValueFromString(parts[0]);
                        String password = getValueFromString(parts[1]);
                        String role = getValueFromString(parts[2]);
                        int id = Integer.parseInt(getValueFromString(parts[3]));
                        String name = getValueFromString(parts[4]);
                        String location = getValueFromString(parts[5]);
                        int age = Integer.parseInt(getValueFromString(parts[6]));

                        Adopter adopter = new Adopter(username, password, role, id, name, location, age, null, new ArrayList<>());
                        adopters.add(adopter);
                    }
                } 
                // Parse Shelter data
                else if (line.startsWith("Shelter Name:")) {
                    String name = getValueFromString(line);
                    String[] shelterDetails = line.split(",");
                    int id = Integer.parseInt(getValueFromString(shelterDetails[0]));
                    String location = getValueFromString(shelterDetails[2]);
                    currentShelter = new shelterImplementation(id, name, location, "", "");
                    shelters.add(currentShelter);
                } 
                // Parse Pets for the shelter
                else if (line.startsWith("Pet ID:") && currentShelter != null) {
                    String[] petDetails = line.split(", ");
                    int id = Integer.parseInt(getValueFromString(petDetails[0]));
                    String name = getValueFromString(petDetails[1]);
                    String species = getValueFromString(petDetails[2]);

                    Pet pet = new Pet(id, name, species, "", 0, "", true);
                    currentShelter.getPets().add(pet);
                }
                // Parse Shelter attributes in CSV format
                else if (line.startsWith("Shelters:")) {
                    continue;  // Skip or handle if needed
                }
            }
        }
    }

    // Helper method to extract value from a string (after the ": ")
    private static String getValueFromString(String str) {
        return str.split(": ")[1];
    }

    // Method to write data to a file
    public static void writeToFile(
            String fileName,
            List<Adopter> adopters,
            List<shelterImplementation> shelters
    ) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Writing Adopters data
            writer.write("Adopters:");
            writer.newLine();
            for (Adopter adopter : adopters) {
                writer.write("Username: " + adopter.getUsername() + ", Password: " + adopter.getPassword() +
                             ", Role: " + adopter.getRole() + ", ID: " + adopter.getID() + ", Name: " +
                             adopter.getName() + ", Location: " + adopter.getLocation() + ", Age: " + adopter.getAge());
                writer.newLine();
            }
            writer.newLine();

            // Writing Shelter and Pet data
            writer.write("Shelters and their pets:");
            writer.newLine();
            for (shelterImplementation shelter : shelters) {
                writer.write("Shelter Name: " + shelter.getName());
                writer.newLine();
                for (Pet pet : shelter.getPets()) {
                    writer.write("Pet ID: " + pet.getId() + ", Name: " + pet.getName() + ", Species: " + pet.getSpecies());
                    writer.newLine();
                }
                writer.newLine();
            }

            // Writing Shelter attributes in CSV format
            writer.write("Shelters:");
            writer.newLine();
            for (shelterImplementation shelter : shelters) {
                writer.write(shelter.getId() + "," +
                             shelter.getName() + "," +
                             shelter.getE_mail() + "," +
                             shelter.getPhoneNumber() + "," +
                             shelter.getLocation());
                writer.newLine(); // Add a new line for the next shelter
            }

            // Ensure the data is actually written to the file
            writer.flush();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    * */
   
    /**
    // Method to read data from a file
    public static void readFromFile(
            String fileName,
            List<Adopter> adopters,
            List<shelterImplementation> shelters
    ) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            shelterImplementation currentShelter = null;

            while ((line = reader.readLine()) != null) {
                // Parse Adopter data
                if (line.startsWith("Adopters:")) {
                    while ((line = reader.readLine()) != null && !line.isBlank()) {
                        String[] parts = line.split(", ");
                        String username = getValueFromString(parts[0]);
                        String password = getValueFromString(parts[1]);
                        String role = getValueFromString(parts[2]);
                        int id = Integer.parseInt(getValueFromString(parts[3]));
                        String name = getValueFromString(parts[4]);
                        String location = getValueFromString(parts[5]);
                        int age = Integer.parseInt(getValueFromString(parts[6]));

                        Adopter adopter = new Adopter(username, password, role, id, name, location, age, null, new ArrayList<>());
                        adopters.add(adopter);
                    }
                } 
                // Parse Shelter data
                else if (line.startsWith("Shelter Name:")) {
                    String name = getValueFromString(line);
                    currentShelter = new shelterImplementation(0, name, "", "", "");
                    shelters.add(currentShelter);
                } 
                // Parse Pets for the shelter
                else if (line.startsWith("Pet ID:") && currentShelter != null) {
                    String[] petDetails = line.split(", ");
                    int id = Integer.parseInt(getValueFromString(petDetails[0]));
                    String name = getValueFromString(petDetails[1]);
                    String species = getValueFromString(petDetails[2]);

                    Pet pet = new Pet(id, name, species, "", 0, "", true);
                    currentShelter.getPets().add(pet);
                }
                // Parse Shelter attributes in CSV format
                else if (line.startsWith("Shelters:")) {
                    continue;  // Skip or handle if needed
                }
            }
        }
    }

    // Helper method to extract value from a string (after the ": ")
    private static String getValueFromString(String str) {
        return str.split(": ")[1];
    }

    // Method to write data to a file
    public static void writeToFile(
            String fileName,
            List<Adopter> adopters,
            List<shelterImplementation> shelters
    ) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Writing Adopters data
            writer.write("Adopters:");
            writer.newLine();
            for (Adopter adopter : adopters) {
                writer.write("Username: " + adopter.getUsername() + ", Password: " + adopter.getPassword() +
                             ", Role: " + adopter.getRole() + ", ID: " + adopter.getID() + ", Name: " +
                             adopter.getName() + ", Location: " + adopter.getLocation() + ", Age: " + adopter.getAge());
                writer.newLine();
            }
            writer.newLine();

            // Writing Shelter and Pet data
            writer.write("Shelters and their pets:");
            for (shelterImplementation shelter : shelters) {
                writer.write("Shelter Name: " + shelter.getName());
                writer.newLine();
                for (Pet pet : shelter.getPets()) {
                    writer.write("Pet ID: " + pet.getId() + ", Name: " + pet.getName() + ", Species: " + pet.getSpecies());
                    writer.newLine();
                }
                writer.newLine();
            }

            writer.write("Shelters:");
            for (shelterImplementation shelter : shelters) {
                writer.write(shelter.getId() + "," +
                             shelter.getName() + "," +
                             shelter.getE_mail() + "," +
                             shelter.getPhoneNumber() + "," +
                             shelter.getLocation());
                writer.newLine(); // Add a new line for the next shelter
            }
        }
    }
    
   
 **/  
        
        
      // Method to read data from a file

  //  }
}

