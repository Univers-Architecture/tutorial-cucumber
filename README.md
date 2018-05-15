# Titre du projet

Tutoriel : Intégration de cucumber avec Spring Boot

## Getting Started

Ces instructions vous permettront d'obtenir une copie du projet en cours d'exécution sur votre machine locale à des fins de développement et de test. 

## Description du projet

L’objectif de ce tutoriel est de vous familiariser avec l’outil cucumber et de son intégration avec le framework Spring avec persistance de données dans une base de données SQL. Vous maîtriserez le framework Cucumber et serez en mesure de l’implémenter avec succès sur vos projets quelque soit les cas de tests d’automatisation dont vous disposez.
Pour concrétiser tout ce qui a été cité dans l’article précédent . Nous implémenterons l’approche Behavior Driven Development sur la fonctionnalité Inscription de l’utilisateur. Celle-ci doit nous assurer :
* Qu’un utilisateur s’enregistrera avec succès si l’email introduit n’est pas déjà utilisé par un autre utilisateur.
* L’Affichage d’une erreur indiquant que l’email est déjà utilisé.

###  Prérequis logiciels
* Maven : la dernière version est recommandée.
* Java : Java 1.8+ (ou plus).


## Exécution des tests

Pour exécuter et visualiser le résultat des tests, Il y a deux méthode à suivre. Soit:
* En exécutant la commande "mvn clean test" dans le terminal au niveau du dossier parent.
```
mvn clean test
```

* En Démarrant La classe CucumberTutoApplicationTests Java depuis l’IDE Eclipse, en tant que Test JUNIT,

