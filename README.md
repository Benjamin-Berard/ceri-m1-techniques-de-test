# UCE Génie Logiciel Avancé : Techniques de tests

**Berard Benjamin - Groupe 1**

## Badges

[![CircleCI](https://dl.circleci.com/status-badge/img/circleci/Q2JoH7tbPcB6HPzmCXXcH4/7hptH5Rhz3q7NUVoB6yYSH/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/circleci/Q2JoH7tbPcB6HPzmCXXcH4/7hptH5Rhz3q7NUVoB6yYSH/tree/master)
[![codecov](https://codecov.io/gh/Benjamin-Berard/ceri-m1-techniques-de-test/graph/badge.svg?token=BJRUHKY4FO)](https://codecov.io/gh/Benjamin-Berard/ceri-m1-techniques-de-test)
![Checkstyle](target/site/badges/checkstyle-result.svg)
[![Javadoc](https://img.shields.io/badge/Javadoc-Online-blue)](https://benjamin-berard.github.io/ceri-m1-techniques-de-test/apidocs/)


## Introduction

Vous allez à travers ces projets mettre en application une partie des aspects évoqués en cours vis à vis des techniques de tests.  
Pour cela nous allons réaliser un projet logiciel de petite taille, en suivant la roadmap suivante : 
- Setup du projet
- Mise en place des outils d’intégration continue
- Écriture des tests unitaires
- Écriture des mocks, et validation des tests
- Développement dirigé par les tests
- Documentation et conventions de style
- Test d'une implémentation donnée

Durant cette série de TPs, le gestionnaire de version Git sera utilisé à foison, à travers la plateforme GitHub. Si vous n’êtes pas à l’aise avec cet outil[^1], [voici](http://rogerdudler.github.io/git-guide/) un petit guide à garder sous la main.

## Sujets

L'ensemble des sujets de TPs peut être trouvé dans le dossier `TPs`.

Le dossier `src` contient la définition de l'ensemble des interfaces qui seront l'objet de vos travaux.

## Rapport

- Pour les tests, le seul qui n'a pas marché était celui qui devait retourner salamèche à l'index 0 (comme c'est un index inconnu dans notre rocketpokemonfactory il retourne missingno)

- Utilisation de hashmap pour mettre un nom sur un index (index 0 appartenant au nom MISSINGNO)

- La methode generateRadomStat est mauvaise : elle crée un nouveau random sur chaque itération ce qui ralentit le programme pour rien,
- le nombre d'itérations est ridiculement élevé, on pourrait facilement faire une boucle de 100 ou
(si on veut pousser les proportions à se rapprocher des 50%, faire 10000 itérations avec une division par 100)

- Le total va être la somme totale des randomint (chiffre entre 0 et 1) de chaque itération divisée par 10000.


- Pour la methode createPokemon, par defaut, si nous mettons un index autre que ceux que notre hash map connait, nous utiliserons MISSINGNO.
  Si index < 0 (dans notre cas ça ne correspond qu'à Ash's Pikachu), les stat d'attaque, defense et stamina seront mises à 1000 est l'iv à 0.
  Sinon, nous génèrerons pour les 3 stats des nombres aléatoires (3x 1000000 itérations) est l'iv sera à 1.
  Cette methode retournera le nouveau pokémon crée.



Les valeurs d'attaque, défense et stamina sont censées être bornées entre 0 et 15 + le niveau de l'individu, ce qui n'est pas le cas ici.

Les iv sont cencés être un pourcentage de perfections aléatoire allant de 0 à 100% ce qui n'est pas le cas ici non plus.

Les checkstyle n'étaient pas respectés (règles que j'ai imposé) : problème d'indentation et problème d'espaces entre les éléments (exemple i=0 -> i = 0)

## Choix techniques

### Technologies utilisées
- Java 
- Maven 3.0.0-M5
- JUnit 5.8.2
- Mockito 4.5.1 pour ajouter une couche d'abstraction
- JaCoCo 0.8.12 pour la couverture des tests
- CircleCI 3.2.5 pour l'intégration continue

### Outils de qualité
- Couverture de tests avec JaCoCo
- Intégration continue avec CircleCI
- Suivi de la couverture avec Codecov

## Rendus

Le rendu des TPs se fait au rythme suivant :

- TP1 : 2ème séance
- TP2 : 2ème séance
- TP3 : 3ème séance
- TP4 : 5ème séance
- TP5 : dernière séance
- TP6 : dernière séance

Pour chaque rendu vous devez créer un tag à partir du commit qui correspond à la complétion du TP.  
Si vous ne spécifiez pas de tag, le dernier commit à la date-heure de la fin de séance sera celui considéré.

[^1]: Si vous n’êtes vraiment pas à l’aise avec cet outil nous vous conseillons quand même vivement de vous y mettre.
