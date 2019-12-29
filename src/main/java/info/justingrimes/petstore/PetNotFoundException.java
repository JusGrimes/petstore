package info.justingrimes.petstore;

public class PetNotFoundException extends RuntimeException {
    public PetNotFoundException(Long id) {
        super("Could not find pet #" + id);
    }
}
