package info.justingrimes.petstore;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {
    private final PetRepository petRepository;

    PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @GetMapping("/pets")
    List<Pet> all() {
        return petRepository.findAll();
    }

    @PostMapping("/pets")
    Pet addPet(@RequestBody Pet newPet){
        return petRepository.save(newPet);
    }

    @GetMapping("/pets/{id}")
    Pet getPet(@PathVariable Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));
    }

    @DeleteMapping("/pets/{id}")
    void delPet(@PathVariable Long id) {
        petRepository.deleteById(id);
    }

}
