package info.justingrimes.petstore;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Pet {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private PetType petType;
    private double price;
    @ManyToOne
    private Owner owner;
}