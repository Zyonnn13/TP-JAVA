# Portfolio d'Exercices Java - Architecture MVC

## 📁 Structure du Projet

```
ProjetExercices/
│
├── src/
│   ├── Main.java                    # Point d'entrée de l'application
│   │
│   ├── model/                       # Couche Model (logique métier)
│   │   ├── FibonacciModel.java      # Calcul Fibonacci avec mémoïsation
│   │   ├── AllumettesModel.java     # Logique du jeu des allumettes
│   │   ├── CarteModel.java          # Modèle de carte à jouer
│   │   ├── JoueurModel.java         # Modèle de joueur
│   │   └── ResultatModel.java       # Modèle de résultat
│   │
│   ├── view/                        # Couche View (interface graphique)
│   │   ├── MainFrame.java           # Fenêtre principale avec onglets
│   │   ├── FibonacciPanel.java      # Interface Fibonacci
│   │   ├── NombreDOrPanel.java      # Interface nombre d'or
│   │   ├── AllumettesPanel.java     # Interface jeu allumettes
│   │   ├── CartesPanel.java         # Interface cartes
│   │   ├── JoueurPanel.java         # Interface test joueur
│   │   ├── SimpleSwingPanel.java    # Interface Swing simple
│   │   ├── ButtonTestPanel.java     # Test de styles de boutons
│   │   └── RadioButtonPanel.java    # Test de RadioButtons
│   │
│   ├── controller/                  # Couche Controller (à étendre)
│   │   └── (classes contrôleur si nécessaire)
│   │
│   └── resources/                   # Ressources du projet
│       ├── images/
│       │   ├── allumettes/          # Images d'allumettes
│       │   │   └── istockphoto-1480287344-612x612.jpg
│       │   └── cartes/              # Images des 52 cartes
│       │       ├── pique_1.png ... pique_13.png
│       │       ├── coeur_1.png ... coeur_13.png
│       │       ├── carreau_1.png ... carreau_13.png
│       │       └── trefle_1.png ... trefle_13.png
│       └── icons/
│           └── app-icon.png         # Icône de l'application (optionnel)
│
├── bin/                             # Classes compilées (généré automatiquement)
├── compile.bat                      # Script de compilation Windows
├── run.bat                          # Script d'exécution Windows
└── README.md                        # Ce fichier
```

## 🎯 Exercices Inclus

### 1. 📊 Fibonacci avec Mémoïsation
- Calcul optimisé avec cache HashMap
- Support jusqu'à F(92) avec type `long`
- SwingWorker pour éviter le blocage de l'UI
- Affichage des performances et taille du cache

### 2. 🔢 Nombre d'Or
- Calcul du ratio O(n) = F(n+1) / F(n)
- Démonstration de la convergence vers φ (phi)
- Comparaison avec la valeur théorique (1 + √5) / 2

### 3. 🔥 Jeu des Allumettes
- Jeu à 2 joueurs avec interface graphique
- Affichage visuel des allumettes
- Détection automatique du gagnant
- Bouton "Nouvelle Partie"

### 4. 🃏 Cartes à Jouer
- Tirage aléatoire de 3 cartes
- Support des 4 couleurs (Pique, Coeur, Carreau, Trèfle)
- Chargement d'images ou rendu simplifié
- Interface style table de jeu

### 5. 👤 Classe Joueur
- Gestion des informations du joueur (nom, prénom, pseudo)
- Composition avec ResultatModel (relation 1-1)
- Interface pour créer et modifier un joueur
- Affichage formaté des informations

### 6. 🎯 Swing Simple
- Fenêtre avec bouton et label interactifs
- Démonstration des événements de base
- Changement dynamique de couleurs
- Animation simple au clic

### 7. 🎨 Test de Boutons
- 5 styles de boutons différents
- Bouton simple, coloré, moderne, fantaisie avec dégradé
- Toggle button avec état ON/OFF
- Journal des événements avec horodatage

### 8. 🔘 RadioButtons
- Modification du style de texte en temps réel
- 4 styles: Normal, Gras, Italique, Gras+Italique
- 4 tailles de police: 12pt, 16pt, 20pt, 24pt
- Zone de texte éditable pour tester

## 🏗️ Architecture MVC

### Model (Logique Métier)
- **FibonacciModel**: Gère le calcul et le cache
- **AllumettesModel**: Gère les règles du jeu
- **CarteModel**: Représente une carte avec enum Couleur

### View (Interface Graphique)
- Tous les panels héritent de `JPanel`
- Chaque exercice a son propre panel indépendant
- Navigation via `JTabbedPane` dans `MainFrame`

### Controller
- Pour ce projet simple, la logique de contrôle est intégrée dans les Views
- Pour des projets plus complexes, créez des classes Controller séparées

## ⚡ Optimisations Implémentées

### 1. **SwingWorker pour Fibonacci**
- Évite le blocage de l'interface lors de calculs longs
- Barre de progression pendant le calcul
- Calcul en arrière-plan avec mise à jour de l'UI

### 2. **Mémoïsation**
- Cache HashMap pour éviter les recalculs
- Amélioration drastique des performances
- Réutilisation des résultats précédents

### 3. **Gestion des Ressources**
- Chargement lazy des images
- Fallback vers des représentations simples si images manquantes
- Pas de blocage si ressources introuvables

### 4. **Event Dispatch Thread**
- Toute l'UI lancée sur l'EDT avec `SwingUtilities.invokeLater()`
- Respect des bonnes pratiques Swing

## 🚀 Compilation et Exécution

### Windows

#### Compilation:
```batch
cd ProjetExercices\src
javac -encoding UTF-8 -d ..\bin Main.java model\*.java view\*.java
```

Ou utilisez le script fourni:
```batch
compile.bat
```

#### Exécution:
```batch
cd ProjetExercices
java -cp bin Main
```

Ou utilisez:
```batch
run.bat
```

### Linux / macOS

#### Compilation:
```bash
cd ProjetExercices/src
javac -encoding UTF-8 -d ../bin Main.java model/*.java view/*.java
```

#### Exécution:
```bash
cd ProjetExercices
java -cp bin Main
```

## 📦 Installation des Ressources

### Images d'Allumettes
Copiez votre image d'allumette dans:
```
ProjetExercices/src/resources/images/allumettes/istockphoto-1480287344-612x612.jpg
```

### Images de Cartes
Format attendu: `{couleur}_{valeur}.png`
- Exemples: `pique_1.png`, `coeur_13.png`, `carreau_7.png`
- Total: 52 images (4 couleurs × 13 valeurs)

Placez-les dans:
```
ProjetExercices/src/resources/images/cartes/
```

**Note:** Si les images sont absentes, l'application génère des représentations simples automatiquement.

## 🔧 Extension du Projet

### Ajouter un Nouvel Exercice

1. **Créer le Model** (si nécessaire):
```java
package model;

public class MonNouvelExerciceModel {
    // Logique métier
}
```

2. **Créer le Panel**:
```java
package view;

import javax.swing.*;
import model.MonNouvelExerciceModel;

public class MonNouvelExercicePanel extends JPanel {
    private MonNouvelExerciceModel model;
    
    public MonNouvelExercicePanel() {
        this.model = new MonNouvelExerciceModel();
        // Initialiser l'interface
    }
}
```

3. **Ajouter dans MainFrame.java**:
```java
tabbedPane.addTab("🎯 Mon Exercice", 
    createIconForTab(new Color(100, 200, 100)),
    new MonNouvelExercicePanel(), 
    "Description de l'exercice");
```

## 📋 Bonnes Pratiques Utilisées

✅ **Séparation des responsabilités** (MVC)  
✅ **Encapsulation** (attributs privés, getters/setters)  
✅ **Gestion des erreurs** (try-catch, validation des entrées)  
✅ **Thread-safety** (SwingUtilities.invokeLater, SwingWorker)  
✅ **Performance** (mémoïsation, lazy loading)  
✅ **Extensibilité** (facile d'ajouter de nouveaux exercices)  
✅ **Documentation** (Javadoc, commentaires clairs)  
✅ **Robustesse** (fallbacks pour ressources manquantes)  
✅ **UX/UI** (feedback visuel, animations, validation)  
✅ **Composition** (JoueurModel utilise ResultatModel)  

## 🐛 Dépannage

### Problème: Images ne s'affichent pas
**Solution**: Vérifiez que les chemins dans `resources/images/` sont corrects. L'application fonctionne avec ou sans images.

### Problème: Erreur de compilation "package does not exist"
**Solution**: Assurez-vous de compiler depuis le dossier `src/` avec l'option `-d ../bin`

### Problème: Caractères accentués mal affichés
**Solution**: Utilisez `-encoding UTF-8` lors de la compilation

### Problème: Interface bloquée pendant le calcul Fibonacci
**Solution**: Vérifiez que `SwingWorker` est bien utilisé (déjà implémenté)

## 📝 Version

**Version actuelle**: 1.0  
**Date**: 18 Novembre 2025  
**Auteur**: Projet Ynov  

## 🎓 Concepts Pédagogiques

Ce projet démontre:
- Architecture MVC en Java Swing
- Programmation événementielle
- Mémoïsation et optimisation algorithmique
- Multi-threading avec SwingWorker
- Gestion des ressources
- Composition et agrégation d'objets
- Validation des entrées utilisateur
- Gestion de l'état de l'application
- Personnalisation avancée de composants Swing
- Bonnes pratiques de développement Java

## 📊 Statistiques du Projet

- **9 exercices** complets et fonctionnels
- **5 classes Model** (logique métier)
- **8 panels View** (interfaces graphiques)
- **1 MainFrame** (navigation avec onglets)
- **Architecture MVC** complète
- **Support images** avec fallback
- **SwingWorker** pour performances
- **100% Java Swing** (pas de frameworks externes)

---

**Bon développement! 🚀**
