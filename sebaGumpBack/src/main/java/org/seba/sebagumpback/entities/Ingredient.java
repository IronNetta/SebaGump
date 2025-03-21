package org.seba.sebagumpback.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter @Getter
@EqualsAndHashCode @ToString
@NoArgsConstructor @AllArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String quantite;

    @ManyToOne
    @JoinColumn(name = "recette_id")
    private Recette recette;

    public Ingredient(String crevettes, String s) {
        this.nom = crevettes;
        this.quantite = s;
    }
}