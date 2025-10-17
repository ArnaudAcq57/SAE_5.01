# SAE 5.01 - Application Mobile de Reconnaissance d'Objets avec IA

## Contexte du Projet

Dans le cadre de la SAE 5.01 "Développement avancé" à l'IUT de Metz, 
je développe avec mon groupe une application Android de reconnaissance de types de véhicules (voitures, camions, vélos, utilitaires, etc.)
Je suis chargé de l'acquisition d'images et vidéos `feature/camera`.
Ce choix de travailler sur nos branches git respectives (IA, caméra, interface utilisateur, base de données) va nous permettre d'avancer en parallèle tout en facilitant l'intégration finale des différents composants.

## Objectifs

Mon travail consiste à intégrer l'acquisition d'image en temps réel ou bien d'importer une image depuis la galerie pour ensuite pouvoir la traiter avec le modèle d'apprentissage.

## Avancement - Semaine 1 (17 octobre 2025)

Réalisations techniques

**Configuration de l'environnement** 
- Mise en place du projet Android Studio en Kotlin (SDK minimum API 24).
- Gestion des permissions : Ajout des permissions CAMERA et READ_EXTERNAL_STORAGE dans AndroidManifest.xml.
- Intégration de CameraX : Mise en place de la bibliothèque CameraX pour un accès moderne à la caméra, incluant : L'affichage de l'aperçu en temps réel dans l'application. La fonctionnalité de capture de photo avec sauvegarde dans la galerie. La fonctionnalité d'importation d'une image depuis la galerie.
La préparation à l'analyse vidéo avec ImageAnalysis pour le traitement en temps réel par le modèle d'IA.


## Informations Techniques

**Technologies** : Kotlin, Android (API 24+), CameraX, ViewBinding. Bibliothèque d'IA (prévue) : TensorFlow Lite 2.14.0

**Rôle** : Acquisition d'image via la caméra/galerie.

---

Prévue: Refactoring pour + de lisibilité et facilité de maintenance et gestion des images en prévision du traitement avec l'IA

*Dernière mise à jour : 17 octobre 2025*
