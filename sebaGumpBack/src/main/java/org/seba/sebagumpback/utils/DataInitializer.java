package org.seba.sebagumpback.utils;

import jakarta.transaction.Transactional;
import org.seba.sebagumpback.entities.Etape;
import org.seba.sebagumpback.entities.Ingredient;
import org.seba.sebagumpback.entities.Recette;
import org.seba.sebagumpback.repository.RecetteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RecetteRepository recetteRepository;

    public DataInitializer(RecetteRepository recetteRepository) {
        this.recetteRepository = recetteRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (recetteRepository.count() == 0) {
            System.out.println("📌 Initialisation de la base de données avec des recettes...");

            Recette recette1 = new Recette();
            recette1.setTitre("Risotto aux Crevettes");
            recette1.setDescription("Un délicieux risotto crémeux aux crevettes.");
            recette1.setImageUrl("https://www.iterroir.fr/images/photos-recettes/recette-risotto-curry-scampis.jpg");
            recette1.setIngredients(List.of(
                    new Ingredient("Crevettes", "200g"),
                    new Ingredient("Riz Arborio", "150g"),
                    new Ingredient("Bouillon de volaille", "500ml"),
                    new Ingredient("Parmesan", "50g")
            ));
            recette1.setEtapes(List.of(
                    new Etape("Faire revenir les crevettes dans du beurre."),
                    new Etape("Ajouter le riz et le nacrer 2 minutes."),
                    new Etape("Incorporer le bouillon progressivement."),
                    new Etape("Ajouter le parmesan et mélanger.")
            ));

            Recette recette2 = new Recette();
            recette2.setTitre("Tacos aux Crevettes");
            recette2.setDescription("Des tacos croustillants garnis de crevettes épicées.");
            recette2.setImageUrl("https://i0.wp.com/bonpourtoi.ca/app/uploads/2021/10/tacos-crevettes-1178px-tinyjpg.jpg");
            recette2.setIngredients(List.of(
                    new Ingredient("Tortillas", "4"),
                    new Ingredient("Crevettes", "250g"),
                    new Ingredient("Chou rouge", "100g"),
                    new Ingredient("Sauce épicée", "50ml")
            ));
            recette2.setEtapes(List.of(
                    new Etape("Cuire les crevettes avec la sauce épicée."),
                    new Etape("Chauffer les tortillas."),
                    new Etape("Garnir avec les crevettes et le chou rouge."),
                    new Etape("Servir avec une sauce au citron.")
            ));

            Recette recette3 = new Recette();
            recette1.setTitre("Risotto aux Crevettes");
            recette1.setDescription("Un délicieux risotto crémeux aux crevettes.");
            recette1.setImageUrl("https://www.iterroir.fr/images/photos-recettes/recette-risotto-curry-scampis.jpg");
            recette1.setIngredients(List.of(
                    new Ingredient("Crevettes", "200g"),
                    new Ingredient("Riz Arborio", "150g"),
                    new Ingredient("Bouillon de volaille", "500ml"),
                    new Ingredient("Parmesan", "50g")
            ));
            recette1.setEtapes(List.of(
                    new Etape("Faire revenir les crevettes dans du beurre."),
                    new Etape("Ajouter le riz et le nacrer 2 minutes."),
                    new Etape("Incorporer le bouillon progressivement."),
                    new Etape("Ajouter le parmesan et mélanger.")
            ));


            recetteRepository.saveAll(List.of(recette1, recette2, recette3));

            System.out.println("✅ Base de données peuplée avec succès !");
        }
    }
}
