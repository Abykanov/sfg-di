package learning.springframework.pets;

public class PetServiceFactory {
    public PetService getPetService(String petType) {
        switch (petType) {
            case "dog":
                return new DogPetService();
            default:
                return new CatPetService();
        }
    }
}
