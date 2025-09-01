#!/bin/bash

# Script pour lancer l'application dockerisée

echo "🚀 Démarrage de l'application de gestion des utilisateurs..."

# Vérifier si Docker est installé
if ! command -v docker &> /dev/null; then
    echo "❌ Docker n'est pas installé. Veuillez l'installer d'abord."
    exit 1
fi

# Vérifier si Docker Compose est installé
if ! command -v docker-compose &> /dev/null; then
    echo "❌ Docker Compose n'est pas installé. Veuillez l'installer d'abord."
    exit 1
fi

# Créer le fichier .env s'il n'existe pas
if [ ! -f .env ]; then
    echo "📝 Création du fichier .env..."
    cp .env.example .env
    echo "⚠️  Veuillez modifier le fichier .env avec vos propres valeurs sécurisées."
fi

# Build et démarrage des services
echo "🔨 Construction et démarrage des conteneurs..."
docker-compose up --build -d

# Attendre que les services soient prêts
echo "⏳ Attente du démarrage des services..."
sleep 30

# Vérifier le statut des services
echo "📊 Statut des services:"
docker-compose ps

echo ""
echo "✅ Application démarrée avec succès!"
echo "🌐 API disponible sur: http://localhost:8082"
echo "📚 Documentation Swagger: http://localhost:8082/swagger-ui.html"
echo "🔍 Health check: http://localhost:8082/actuator/health"
echo ""
echo "📋 Commandes utiles:"
echo "  - Voir les logs: docker-compose logs -f"
echo "  - Arrêter: docker-compose down"
echo "  - Redémarrer: docker-compose restart"