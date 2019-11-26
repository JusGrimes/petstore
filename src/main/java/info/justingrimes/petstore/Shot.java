package info.justingrimes.petstore;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Shot {
    private String name;
    private LocalDate date;
}
