# SpringBoot CI/CD Automation Pipeline

This is the backend for a student residence management system built with Spring Boot. It handles foyers, students, and rooms — and comes with a proper DevOps setup so it's easy to run locally or deploy anywhere.

---

## What You Need Before Starting

- Java 17
- Docker and Docker Compose (if you want to run it with containers)

---

## Running Locally

Clone the repo, then depending on your OS:

**Windows:**
```bat
mvnw.cmd clean test
mvnw.cmd spring-boot:run
```

**Linux/macOS:**
```bash
chmod +x mvnw
./mvnw clean test
./mvnw spring-boot:run
```

Once it's up, open `http://localhost:8089/tpfoyer` in your browser.

---

## Running With Docker Compose

First, copy the example env file and fill in your values:

```bash
cp .env.example .env
```

Then start everything:

```bash
docker compose up -d --build
```

You can check that the app started correctly by hitting the health endpoint:
`http://localhost:8089/tpfoyer/actuator/health`

---

## Project Structure & What I Added

This project started as a basic Spring Boot setup. Here's what I worked on to bring it closer to something production-ready:

**Docker & Compose**
- Rewrote the Dockerfile as a multi-stage build — keeps the final image small and clean
- Added health checks for both MySQL and the app in `docker-compose.yml` so Compose waits for services to actually be ready before connecting them
- Credentials are pulled from environment variables, nothing hardcoded

**CI/CD (GitHub Actions)**
- `.github/workflows/ci-cd.yml` runs on every push: tests, builds the JAR, then builds the Docker image
- `.github/workflows/release-docker.yml` is triggered manually when you're ready to push a tagged image to Docker Hub

**Code**
- Added validation annotations on `Etudiant`, `Chambre`, and `Foyer` entities
- The API now returns proper field-level error messages when validation fails instead of a generic 500

**Kubernetes**
- There's a full set of manifests under `k8s/` including namespace, configmap, secrets, MySQL and app deployments, a service, HPA for autoscaling, and an ingress
- See `k8s/README.md` for how to apply them

**Other cleanup**
- Added `.gitignore` and `.dockerignore` at the root — the pipelines were picking up unnecessary files before

---

## Handy Commands

```bash
# Full build + tests
./mvnw clean verify

# Follow app logs
docker compose logs -f app

# Tear everything down including volumes
docker compose down -v
```

---

## Deploying to Kubernetes

Check `k8s/README.md` — it walks through everything step by step.