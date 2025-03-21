package org.seba.sebagumpback.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter @Getter
@EqualsAndHashCode @ToString
@NoArgsConstructor @AllArgsConstructor
public class Etape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int ordre;
    @Column(length = 5000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "recette_id")
    private Recette recette;

    public Etape(String s) {
        this.description = s;
    }
}