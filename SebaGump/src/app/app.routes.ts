import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () => import('./features/home/pages/home/home.component').then((m) => m.HomeComponent)
  },
  {
    path: 'home',
    loadComponent: () => import('./features/home/pages/home/home.component').then((m) => m.HomeComponent)
  },
  {
    path: 'about',
    loadComponent: () => import('./features/about/pages/about/about.component').then((m) => m.AboutComponent)
  },
  {
    path: 'recipe',
    loadComponent: () => import('./features/recipe/pages/recipe/recipe.component').then((m) => m.RecipeComponent)
  },
  {
    path: 'shrimp',
    loadComponent: () => import('./features/shrimp/pages/shrimp/shrimp.component').then((m) => m.ShrimpComponent)
  },
  {
    path: 'contact',
    loadComponent: () => import('./features/contact/pages/contact/contact.component').then((m) => m.ContactComponent)
  }

];
