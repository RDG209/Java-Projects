package pets;
import java.util.*;

interface PetMatcher {
    List<Pet> matchPet(Pet pet);

    default Pet firstPet(Pet pet) {
        int index = Pet.pets.indexOf(pet);
        if (index < 0) {
        	return null;
        }
        return Pet.pets.get(index);
    }
}
