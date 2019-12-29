package info.justingrimes.petstore;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    OwnerRepository ownerRepository;

    OwnerController(OwnerRepository repository) {
        ownerRepository = repository;
    }


    @GetMapping
    List<Owner> all() {
        return ownerRepository.findAll();
    }

    @GetMapping("{id}")
    Owner one(@PathVariable Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new OwnerNotFoundException(id));
    }

    @PostMapping
    Owner addOne(@RequestBody Owner newOwner) {
        return ownerRepository.save(newOwner);
    }
}
