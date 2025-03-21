package org.seba.sebagumpback.repository;

import org.seba.sebagumpback.entities.Recette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetteRepository extends JpaRepository<Recette, Long> { }