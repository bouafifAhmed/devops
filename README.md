# Sky — Configuration de la base de données

Ce projet utilise Spring Boot 3 et Hibernate 6. Par défaut, la datasource pointe vers MySQL local.

## Paramètres par défaut

- Fichier `src/main/resources/application.properties`
- URL par défaut: `jdbc:mysql://localhost:3306/skystation?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC`
- Utilisateur: `root`
- Mot de passe: vide

## Variables d’environnement (recommandé)

Vous pouvez surcharger la configuration sans modifier le fichier properties:

- `SPRING_DATASOURCE_URL`
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`
- `SERVER_PORT`

Exemple (Windows PowerShell):

```powershell
$env:SPRING_DATASOURCE_URL = "jdbc:mysql://localhost:3306/skystation?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"
$env:SPRING_DATASOURCE_USERNAME = "root"
$env:SPRING_DATASOURCE_PASSWORD = "votre_mot_de_passe"
mvn spring-boot:run
```

## Exécution dans Docker

Si l’application tourne dans Docker mais que MySQL est **sur votre machine**, utilisez `host.docker.internal` (Windows/macOS):

```
SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/skystation?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
```

Alternative: utilisez `docker-compose` avec un service MySQL et pointez l’URL vers le **nom du service** (ex: `mysql`).

## Dépannage rapide

- Vérifiez que MySQL est démarré et écoute sur le port 3306.
- Testez la connexion: `mysql -h 127.0.0.1 -P 3306 -u root -p`.
- Si vous utilisez XAMPP/WAMP, le port peut être `3307`: ajustez l’URL.
- Si pare-feu actif, autorisez le port MySQL.

## Mode H2 (option dev)

Pour démarrer sans MySQL, vous pouvez basculer H2:

- Ajouter la dépendance `com.h2database:h2` (scope `runtime`).
- Changer l’URL vers `jdbc:h2:mem:testdb;MODE=MySQL;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE`.

