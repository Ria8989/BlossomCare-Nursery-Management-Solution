#!/bin/bash

# Change permissions
sudo chown -R $USER:$USER $HOME/.minikube
sudo chmod -R u+wrx $HOME/.minikube

# Start Minikube
minikube start

# Wait for all pods to be in running state
kubectl wait --for=condition=ready pod --all -n my-app --timeout=1000s

echo "$(minikube ip):30080"

# Perform port forwarding
pgrep -f "kubectl port-forward service/backend 8085:8085 -n my-app" || nohup kubectl port-forward service/backend 8085:8085 -n my-app > /dev/null 2>&1 &

