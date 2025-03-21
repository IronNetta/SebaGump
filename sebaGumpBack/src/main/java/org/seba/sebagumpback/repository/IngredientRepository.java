package org.seba.sebagumpback.repository;

import org.seba.sebagumpback.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
