package pets;
import java.util.*;

public class Pet {
	private String name;
    private String animal;
    private String breed;
    private String color;
    private double price;

    // Static list of pets
    public static List<Pet> pets = new ArrayList<Pet>();

    // Default constructor
    public Pet() {}

    // Constructor with parameters
    public Pet(String name, String animal, String breed, String color, double price) {
        this.setName(name);
        this.setAnimal(animal);
        this.setBreed(breed);
        this.setColor(color);
        this.setPrice(price);
    }

    // Getters and Setters
    public String getName() { 
    	return name; 
    }
    public void setName(String name) { 
    	this.name = name; 
    }

    public String getAnimal() { 
    	return animal; 
    }
    public void setAnimal(String animal) { 
    	this.animal = animal; 
    }

    public String getBreed() { 
    	return breed; 
    }
    public void setBreed(String breed) { 
    	this.breed = breed; 
    }

    public String getColor() { 
    	return color; 
    }
    public void setColor(String color) { 
    	this.color = color; 
    }

    public double getPrice() { 
    	return price; 
    }
    public void setPrice(double price) { 
    	this.price = price; 
    }

    public String toString() {
        return String.format("%s: a %s %s %s purchased for $%.2f", name, color, breed, animal, price);
    }
    public boolean equals(Object obj) {
    	if (obj instanceof Pet) {
    		Pet newPet = (Pet) obj;
    		return this.animal.equals(newPet.animal) && this.breed.equals(newPet.breed);
    	} else {
    		return false;
    	}
    	
    }
}
