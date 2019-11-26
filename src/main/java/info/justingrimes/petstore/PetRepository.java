package info.justingrimes.petstore;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetRepository extends PagingAndSortingRepository<Pet,Long> {
    List<Pet> findAllByName(@Param("name") String name);
}
