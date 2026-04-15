# Kubernetes Deployment

This folder contains manifests for running the project on Kubernetes with:

- namespace isolation
- MySQL deployment and service
- app deployment and service
- centralized config via ConfigMap and Secret
- readiness/liveness probes
- Horizontal Pod Autoscaler (HPA)
- Ingress routing

## Apply Manifests

```bash
kubectl apply -f k8s/namespace.yaml
kubectl apply -f k8s/configmap.yaml
kubectl apply -f k8s/secrets.yaml
kubectl apply -f k8s/mysql-deployment.yaml
kubectl apply -f k8s/mysql-service.yaml
kubectl apply -f k8s/app-deployment.yaml
kubectl apply -f k8s/app-service.yaml
kubectl apply -f k8s/hpa.yaml
kubectl apply -f k8s/ingress.yaml
```

## Notes

- Update `image` in `app-deployment.yaml` to your pushed registry image.
- Change secret values in `secrets.yaml` for non-local environments.
- `tpfoyer.local` in ingress should map to your ingress controller endpoint.
