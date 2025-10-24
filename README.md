# SAE 5.01 - Application Mobile de Reconnaissance d'Objets avec IA

## Contexte du Projet

Dans le cadre de la SAE 5.01 "Développement avancé" à l'IUT de Metz, 
je développe avec mon groupe une application Android de reconnaissance de types de véhicules (voitures, camions, vélos, utilitaires, etc.)
Je suis chargé de l'acquisition d'images et vidéos `feature/camera`.
Ce choix de travailler sur nos branches git respectives (IA, caméra, interface utilisateur, base de données) va nous permettre d'avancer en parallèle tout en facilitant l'intégration finale des différents composants.

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


*Dernière mise à jour : 24 octobre 2025*