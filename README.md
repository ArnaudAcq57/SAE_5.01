# SAE 5.01 - Application Mobile de Reconnaissance d'Objets avec IA

## Contexte du Projet

Dans le cadre de la SAE 5.01 "Développement avancé" à l'IUT de Metz,
je développe avec mon groupe une application Android de reconnaissance de types de véhicules (voitures, camions, vélos, utilitaires, etc.)
Ma responsabilité porte sur l'intégration du modèle d'intelligence artificielle que je réalise via la branche `feature/ia-model`.
Ce choix de travailler sur nos branches git respectives (IA, caméra, interface utilisateur, base de données) va nous permettre d'avancer en parallèle tout en facilitant l'intégration finale des différents composants.

## Objectifs

Mon travail consiste à concevoir une architecture logicielle robuste permettant l'intégration de modèles d'apprentissage profond via TensorFlow Lite,
en répondant aux contraintes spécifiques de l'architecture mobile' : performances optimisées, mémoire limitée, et traitement en temps réel.

### Module IA (feature/ia-model) :
**Rôle :** Intégration du modèle d'IA et optimisation mobile

## Avancement - Semaine 1 (17 octobre 2025)

### Réalisations techniques

**Configuration de l'environnement**  
Mise en place du projet Android Studio en Kotlin (SDK minimum API 24),
avec l'intégration de TensorFlow Lite 2.14.0 et de ses bibliothèques de support pour le traitement d'images.

**Architecture logicielle**  
J'ai structuré le module IA autour de trois composants principaux :

- **Classification.kt** : Data class encapsulant les résultats de détection avec des méthodes utilitaires pour la conversion des scores de confiance
- **ObjectDetector.kt** : Gestionnaire du cycle de vie du modèle TensorFlow Lite, avec prétraitement optimisé pour MobileNet (224x224 pixels)
- **ImageProcessor.kt** : Utilitaires pour les transformations d'images (redimensionnement, rotation, recadrage)

**Choix techniques**  
Kotlin facilite le développement grâce à sa syntaxe concise pour la gestion des données et sa prévention automatique des erreurs courantes.
Les fonctionnalités de traitement asynchrone permettront d'analyser les images sans ralentir l'interface utilisateur.

## Avancement - Semaine 2 (24 octobre 2025)

### Réalisations

**Ajout du modèle et des catégories**  
J'ai téléchargé et intégré un modèle MobileNet dans le projet.
C'est un modèle léger qui fonctionne bien sur mobile.
J'ai aussi créé une liste de 8 catégories de véhicules (voiture, camion, vélo, moto, bus, utilitaire, trottinette, vélo électrique) pour adapter le modèle à notre projet.

## Avancement - Semaine 3 (6 novembre 2025)

**Fusion des branches et intégration**  
Cette semaine a été consacrée à la fusion de toutes les branches du projet dans la branche principale `main`. J'ai mergé ma branche `feature/ia-model` avec le travail des autres membres de l'équipe (caméra, interface utilisateur, base de données).

**Résolution des conflits**  
Lors de la fusion, plusieurs conflits sont apparus, notamment sur les fichiers de configuration et certains fichiers partagés. J'ai résolu ces conflits en coordination avec l'équipe pour s'assurer que toutes les fonctionnalités restent opérationnelles. Le projet est maintenant unifié sur la branche `main`.

**Préparation de l'intégration**  
Le module IA est maintenant prêt à être connecté avec les autres modules. La structure du code permet une intégration progressive avec le module caméra pour la reconnaissance en temps réel.

### Difficultés rencontrées

J'ai eu quelques problèmes avec les versions des bibliothèques Android qui ne sont pas totalement compatibles entre elles.
Ça génère des avertissements mais ça n'empêche pas l'application de fonctionner. Il faudra corriger ça plus tard.


### Module Caméra (feature/camera)

## Objectifs

Mon travail consiste à intégrer l'acquisition d'image en temps réel ou bien d'importer une image depuis la galerie pour ensuite pouvoir la traiter avec le modèle d'apprentissage.

## Avancement - Semaine 1 (17 octobre 2025)

### Réalisations techniques

**Configuration de l'environnement**
- Mise en place du projet Android Studio en Kotlin (SDK minimum API 24).
- **Gestion des permissions :** Ajout des permissions `CAMERA` et `READ_EXTERNAL_STORAGE` dans `AndroidManifest.xml`.
- **Intégration de CameraX :** Mise en place de la bibliothèque CameraX pour un accès moderne à la caméra, incluant l'affichage de l'aperçu en temps réel, la capture de photo, l'importation depuis la galerie et la préparation à l'analyse vidéo avec `ImageAnalysis`.


## Informations Techniques

**Technologies** : Kotlin, Android (API 24+), CameraX, ViewBinding.

**Bibliothèque d'IA (prévue)** : TensorFlow Lite

**Rôle** : Acquisition d'image via la caméra/galerie.

---

## Avancement - Semaine 2 (24 octobre 2025)

### Réalisations techniques

**Refactorisation :**
- **Création d'un `CameraManager` :** Toute la logique complexe liée à CameraX (démarrage, capture, analyse) a été extraite de la `MainActivity` et encapsulée dans une classe dédiée `CameraManager` dans un nouveau package `camera`.
- **Séparation des responsabilités :** La `MainActivity` agit maintenant comme un "chef d'orchestre", gérant l'interface utilisateur et les permissions, tandis que le `CameraManager` gère toute la complexité technique de la caméra. Cette séparation rend le code plus lisible, maintenable et facilite grandement la collaboration.

**Modernisation du code :**
- **Gestion des permissions (permissionsLauncher) avec `ActivityResultLauncher` :** La gestion des permissions a été mise à jour pour utiliser les API modernes `registerForActivityResult`, remplaçant l'ancienne méthode `onRequestPermissionsResult`. Le code de l'activité est ainsi plus simple et aligné avec les meilleures pratiques Android.

---

## Avancement - Semaine 3 (Semaine du 07/11/2025)

### Réalisations techniques
- **Merge et résolution de conflicts + fusion de fichiers de la branche `feature/camera -> main`**

### Module Interface (feature/ui)

mise en place de la base f application,
mise en place des menu de navigation (camera, résultat et paramètre),
developpement des écrans en cours
### Module Base de données (feature/database)

Lors de la semaine (13/10/2025 - 17/10/2025), j'ai installé Android Studio ainsi que créé une branche Git pour la fonctionalité dont je suis chargé de faire. J'ai également conçu un projet de type Empty Activity. Enfin, j'ai créé deux Entity: Category et Image.

Lors de la semaine (20/10/2025 - 24/10/2025), j'ai créé les fichiers CategoryDAO.kt, ImageDAO.kt, Converters.kt, ImageRepository.kt, TrainingData.kt et AppDatabase.kt.

Lors de la semaine (3/11/2025 - 7/11/2025), j'ai résolu les conflits entre les différents fichiers lors du merge des différentes features faites par les différents membres du groupe.

## Prochaines Étapes

- Intégration du module caméra avec le module IA
- Tests avec images réelles de véhicules
- Développement de l'interface utilisateur complète
- Mise en place du système de stockage
- Optimisation des performances globales

## Informations Techniques

**Langage :** Kotlin  
**Frameworks :** TensorFlow Lite 2.14.0  
**Plateforme :** Android (API 24+)  
**Outils :** Android Studio, Git, GitHub

---

*Dernière mise à jour : 6 novembre 2025*
