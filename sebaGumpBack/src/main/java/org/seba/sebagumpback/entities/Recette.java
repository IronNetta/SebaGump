package org.seba.sebagumpback.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter @Getter
@EqualsAndHashCode @ToString
@NoArgsConstructor @AllArgsConstructor
public class Recette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    @Column(length = 5000)
    private String description;
    @Column(length = 5000)
    private String imageUrl;

    @OneToMany(mappedBy = "recette", cascade = CascadeType.ALL)
    private List<Ingredient> ingredients = new ArrayList<>();

    @OneToMany(mappedBy = "recette", cascade = CascadeType.ALL)
    private List<Etape> etapes = new ArrayList<>();

}
