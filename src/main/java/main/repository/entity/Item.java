package main.repository.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "item")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Integer id;

    @NotBlank
    @Column(name ="name")
    private String name;

    @Min(10)  // aici hibernate valideaza practic inainte de a scrie query-ul in baza de date, valoarea trebuie sa fie minim 10
    @Column(name ="age")
    private Integer age;

}
