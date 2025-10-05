# Documentation Swagger

## Accès à Swagger UI

Une fois l'application démarrée, accédez à Swagger UI via :
- **URL** : http://localhost:8082/swagger-ui.html
- **API Docs** : http://localhost:8082/v3/api-docs

## Authentification JWT dans Swagger

### 1. Créer un utilisateur
Utilisez l'endpoint `POST /api/users` (pas d'authentification requise)

### 2. Se connecter
Utilisez l'endpoint `POST /auth/login` pour obtenir un token JWT

### 3. Configurer l'authentification dans Swagger
1. Cliquez sur le bouton **"Authorize"** en haut à droite
2. Dans le champ "Value", entrez : `Bearer VOTRE_TOKEN_JWT`
3. Cliquez sur **"Authorize"**
4. Vous pouvez maintenant tester les endpoints protégés

## Endpoints disponibles

### Publics (sans authentification)
- `POST /api/users` - Créer un utilisateur
- `POST /auth/login` - Se connecter

### Protégés (avec JWT)
- `GET /api/users` - Lister tous les utilisateurs (ADMIN)
- `GET /api/users/{id}` - Obtenir un utilisateur
- `PUT /api/users/{id}` - Modifier un utilisateur (ADMIN)
- `DELETE /api/users/{id}` - Supprimer un utilisateur (ADMIN)