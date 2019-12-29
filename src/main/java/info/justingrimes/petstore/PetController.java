package info.justingrimes.petstore;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    private final PetRepository petRepository;

    PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @GetMapping
    List<Pet> all() {
        return petRepository.findAll();
    }

    @PostMapping
    Pet addPet(@RequestBody Pet newPet){
        return petRepository.save(newPet);
    }

    @GetMapping("{id}")
    Pet getPet(@PathVariable Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));
    }

    //@DeleteMapping("/pets/{id}")
    @DeleteMapping("{id}")
    void delPet(@PathVariable Long id) {
        petRepository.deleteById(id);
    }

}
