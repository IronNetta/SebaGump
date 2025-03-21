import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {NgForOf} from '@angular/common';

interface Ingredient {
  nom: string;
  quantite: string;
}

interface Etape {
  description: string;
}

interface Recette {
  id?: number;
  titre: string;
  description: string;
  imageUrl: string;
  ingredients: Ingredient[];
  etapes: Etape[];
}

@Component({
  selector: 'app-recipe',
  templateUrl: './recipe.component.html',
  imports: [
    FormsModule,
    NgForOf
  ],
  styleUrls: ['./recipe.component.scss']
})
export class RecipeComponent implements OnInit {
  recettes: Recette[] = [];
  nouvelleRecette: Recette = this.getRecetteVide();

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.chargerRecettes();
  }

  chargerRecettes(): void {
    this.http.get<Recette[]>('http://localhost:8080/api/recettes')
      .subscribe(data => this.recettes = data);
  }

  ajouterRecette(): void {
    this.http.post<Recette>('http://localhost:8080/api/recettes', this.nouvelleRecette)
      .subscribe(data => {
        this.recettes.push(data);
        this.nouvelleRecette = this.getRecetteVide();
      });
  }

  ajouterIngredient(): void {
    this.nouvelleRecette.ingredients.push({ nom: '', quantite: '' });
  }

  supprimerIngredient(index: number): void {
    this.nouvelleRecette.ingredients.splice(index, 1);
  }


  ajouterEtape(): void {
    this.nouvelleRecette.etapes.push({ description: '' });
  }


  supprimerEtape(index: number): void {
    this.nouvelleRecette.etapes.splice(index, 1);
  }

  voirDetails(recette: Recette): void {
    console.log('Afficher les détails de :', recette);
  }

  private getRecetteVide(): Recette {
    return {
      titre: '',
      description: '',
      imageUrl: '',
      ingredients: [],
      etapes: []
    };
  }
}
