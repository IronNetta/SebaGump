import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  imports: [
    FormsModule
  ],
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent {
  formulaire = {
    nom: '',
    email: '',
    message: '',
    prendreRdv: false,
    dateRdv: ''
  };

  afficherDate = false;

  envoyerFormulaire(): void {
    console.log('Formulaire envoyé :', this.formulaire);
    alert('Votre message a été envoyé avec succès !');

    // Réinitialisation du formulaire après envoi
    this.formulaire = {
      nom: '',
      email: '',
      message: '',
      prendreRdv: false,
      dateRdv: ''
    };
    this.afficherDate = false;
  }

  toggleDateRdv(): void {
    if (!this.formulaire.prendreRdv) {
      this.formulaire.dateRdv = '';
    }
    this.afficherDate = this.formulaire.prendreRdv;
  }
}
