package info.justingrimes.petstore;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Owner {
    @Id @GeneratedValue
    private Long id;

    private String name;
    @OneToMany(mappedBy = "owner")
    Set<Pet> pets;
}
