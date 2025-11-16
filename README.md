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

[À compléter par le membre responsable]

### Module Interface (feature/ui)

[À compléter par le membre responsable]

### Module Base de données (feature/database)

[À compléter par le membre responsable]

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