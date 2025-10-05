# API de gestion des utilisateurs

Ce projet implémente une API de gestion des utilisateurs avec des fonctionnalités d'authentification et de gestion des utilisateurs. L'API permet de créer, mettre à jour, et authentifier des utilisateurs, ainsi que de gérer leurs rôles.

## Prérequis

Avant de commencer, assurez-vous que vous avez installé les éléments suivants sur votre machine :

- **Java 17 ou supérieur** - pour compiler et exécuter l'application.
- **Maven** -
- pour gérer les dépendances et construire le projet.
- **Base de données** - Postgres ou autre base de données relationnelle configurée pour l'application.

## Lancer l'API

### Étape 1 : Cloner le dépôt

Cloner le projet depuis GitHub en utilisant la commande suivante :

```bash
git clone https://github.com/hels237/api-gestion-utilisateur.git
cd api-gestion-utilisateur
```
# Guide de Configuration et d'Utilisation de l'API

## Étape 2 : Configurer la base de données
Avant de démarrer l'API, configurez votre base de données en modifiant le fichier `application.properties` ou `application.yml` dans le dossier `src/main/resources`.

### Exemple pour PostgreSQL :

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/user_db
    username: hels
    password: hels
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect

server:
  port: 8082
```

## Étape 3 : Construire et démarrer l'application
Exécutez les commandes suivantes pour construire le projet et démarrer l'application :

```bash
mvn clean install
mvn spring-boot:run
```

Cela démarrera l'API sur le port par défaut `8082`. Vous pouvez le modifier dans le fichier `application.yml` :

```yaml
server:
  port: 8082
```

## Étape 4 : Vérifier que l'API fonctionne
Une fois l'API lancée, vous pouvez tester les points de terminaison (endpoints) en accédant à http://localhost:8082/swagger-ui.html (assurez-vous que Swagger est activé pour explorer l'API).

## Tester l'authentification

### Étape 1 : Créer un nouvel utilisateur

Utilisez l'endpoint **POST /api/users** pour créer un nouvel utilisateur avec les informations suivantes :

```json
{
  "name": "user1",
  "email": "user1@example.com",
  "password": "password1",
  "roles": ["USER"]
}
```
### Réponse attendue

Si la création est réussie, vous recevrez une réponse avec les informations de l'utilisateur :

```json
{
  "id": 1,
  "name": "user1",
  "email": "user1@example.com",
  "roles": ["USER"]
}
```

### Étape 2 : Authentification de l'utilisateur

Une fois créé, vous pouvez vous authentifier en envoyant une requête **POST /auth/login** avec les informations suivantes :

```json
{
  "email": "user1@example.com",
  "password": "password1"
}
```

### Réponse attendue

Si l'authentification est réussie, vous recevrez un JWT Token dans la réponse :

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```
### Étape 3 : Utiliser le token JWT pour l'accès aux endpoints protégés

Après avoir obtenu le token JWT, vous pouvez l'utiliser pour accéder aux endpoints protégés de l'API. Incluez le token dans l'en-tête `Authorization` de vos requêtes comme suit :

```bash
Authorization: Bearer <votre_token_jwt>
```

Par exemple, pour mettre à jour le profil de l'utilisateur, envoyez une requête `PUT /api/users/{id}` avec les informations suivantes :

```json
{
  "name": "user1_updated",
  "email": "user1_updated@example.com",
  "password": "newpassword",
  "roles": ["USER"]
}
```

### Réponse attendue

Si l'utilisateur est mis à jour avec succès, vous recevrez une réponse avec les nouvelles informations de l'utilisateur :

```json
{
  "id": 1,
  "name": "user1_updated",
  "email": "user1_updated@example.com",
  "roles": ["USER"]
}
```

## Points de terminaison de l'API

### Authentification

- **POST /auth/login** : Authentification d'un utilisateur et obtention du token JWT.

### Utilisateurs

- **POST /api/users** : Créer un nouvel utilisateur.
- **GET /api/users** : Obtenir la liste de tous les utilisateurs (ADMIN uniquement).
- **GET /api/users/{id}** : Obtenir les informations d'un utilisateur par son ID.
- **PUT /api/users/{id}** : Mettre à jour les informations d'un utilisateur (ADMIN uniquement).
- **DELETE /api/users/{id}** : Supprimer un utilisateur (ADMIN uniquement).

## Sécurisation de l'API

L'API utilise **JWT** (JSON Web Tokens) pour sécuriser les endpoints. Vous devez inclure le token JWT dans l'en-tête `Authorization` de toutes les requêtes qui nécessitent une authentification.

## Conclusion

Cette API est conçue pour être utilisée dans un système de gestion des utilisateurs avec des fonctionnalités de création, mise à jour et authentification. Elle est sécurisée à l'aide de JWT et permet de gérer les utilisateurs de manière efficace.# api-gestion-utilisateur
api pour la gestion des utllisateurs
