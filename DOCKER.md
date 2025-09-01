# Guide Docker - API Gestion Utilisateurs

## 🚀 Démarrage rapide

```bash
# Méthode 1: Script automatique
./docker-run.sh

# Méthode 2: Commandes manuelles
docker-compose up --build -d
```

## 📋 Prérequis

- Docker 20.10+
- Docker Compose 2.0+

## 🔧 Configuration

1. Copiez `.env.example` vers `.env`
2. Modifiez les variables d'environnement:
   - `JWT_SECRET`: Clé secrète JWT (minimum 256 bits)
   - `POSTGRES_PASSWORD`: Mot de passe PostgreSQL

## 🌐 Accès aux services

- **API**: http://localhost:8082
- **Swagger UI**: http://localhost:8082/swagger-ui.html
- **Health Check**: http://localhost:8082/actuator/health
- **PostgreSQL**: localhost:5432

## 🔒 Sécurité implémentée

- ✅ Utilisateur non-root dans le conteneur
- ✅ Multi-stage build pour réduire la surface d'attaque
- ✅ Variables d'environnement pour les secrets
- ✅ Health checks pour la surveillance
- ✅ Network isolation
- ✅ Volume persistant pour la base de données

## 📊 Commandes utiles

```bash
# Voir les logs
docker-compose logs -f

# Logs d'un service spécifique
docker-compose logs -f app

# Arrêter les services
docker-compose down

# Arrêter et supprimer les volumes
docker-compose down -v

# Redémarrer un service
docker-compose restart app

# Accéder au conteneur
docker-compose exec app sh
```

## 🔍 Dépannage

### Service ne démarre pas
```bash
docker-compose logs app
```

### Base de données inaccessible
```bash
docker-compose logs postgres
```

### Rebuild complet
```bash
docker-compose down -v
docker-compose up --build -d
```