package pets;
import java.util.*;

public class PlayfulPets {

    public static void main(String[] args) {
        // Add Pets to the static list
        Pet.pets.add(new Pet("Scruffy", "dog", "poodle", "brown", 895.00));
        Pet.pets.add(new Pet("Meow", "cat", "siamese", "white", 740.25));
        Pet.pets.add(new Pet("Max", "dog", "poodle", "black", 540.50));
        Pet.pets.add(new Pet("Cuddles", "dog", "pug", "black", 1282.75));
        Pet.pets.add(new Pet("HotDog", "dog", "dachsund", "brown", 621.75));
        Pet.pets.add(new Pet("Slider", "snake", "garden", "brown", 320.00));

        PetMatcher breedMatcher = (myPet) -> {
            List<Pet> matchedPets = new ArrayList<>();
            for (Pet p: Pet.pets) {
                if (p.getBreed().equals(myPet.getBreed())) {
                    matchedPets.add(p);
                }
            }
            return matchedPets;
        };

        PetMatcher priceMatcher = new PetMatcher() {
            public List<Pet> matchPet(Pet pet) {
                List<Pet> matchedPets = new ArrayList<>();
                for (Pet p : Pet.pets) {
                    if (p.getPrice() <= pet.getPrice()) {
                        matchedPets.add(p);
                    }
                }
                return matchedPets;
            }

            public Pet firstPet(Pet pet) {
                for (Pet p : Pet.pets) {
                    if (p.getPrice() <= pet.getPrice()) {
                        return p;
                    }
                }
                return null;
            }
        };

        PetMatcher colorMatcher = new PetMatcher() {
            public List<Pet> matchPet(Pet pet) {
                List<Pet> matchedPets = new ArrayList<>();
                for (Pet p : Pet.pets) {
                    if (p.getColor().equals(pet.getColor())) {
                        matchedPets.add(p);
                    }
                }
                return matchedPets;
            }

            public Pet firstPet(Pet pet) {
                for (Pet p : Pet.pets) {
                    if (p.getColor().equals(pet.getColor())) {
                        return p;
                    }
                }
                return null;
            }
        };

        matchPetsFromTheList("Pugs", breedMatcher, new Pet(null, "dog", "pug", null, 0.0));
        matchPetsFromTheList("Pets for $650 or less", priceMatcher, new Pet(null, null, null, null, 650.0));
        matchPetsFromTheList("Pets that are brown", colorMatcher, new Pet(null, null, null, "brown", 0.0));
    }

    public static void matchPetsFromTheList(String criteria, PetMatcher matcher, Pet myPet) {
        System.out.println(criteria + ":");
        Pet firstMatch = matcher.firstPet(myPet);
        if (firstMatch != null) {
            System.out.println("First: " + firstMatch);
        } else {
            System.out.println("First: No match found");
        }

        List<Pet> allMatches = matcher.matchPet(myPet);
        System.out.println("All matches:");
        for (Pet pet : allMatches) {
            System.out.println(pet);
        }
        System.out.println();
    }
}