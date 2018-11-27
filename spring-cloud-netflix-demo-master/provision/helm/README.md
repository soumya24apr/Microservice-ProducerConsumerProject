# Setup

Install helm.sh on your local machine. Make sure you are connected to a kubernetes cluster. If you want to set one up have a look at the plain [Kubernetes](../kubernetes) deployment info.

Please have a look at the [project page](https://helm.sh/) to find more info on the project and the local installation.

# Hostnames for local development

Please make sure you can reach your cluster with the ingresss names e.g. by adding it to your hosts-file.

The hostnames are by default `frontend.cloud.minikube.local` and `zipkin.cloud.minikube.local`.


# Initialise Helm

## Without RBAC
This command will install the tiller pod in your cluster.

```
helm init 
```

## With RBAC

```
kubectl create serviceaccount tiller --namespace kube-system
kubectl create -f tiller-clusterrolebinding.yaml
helm init --service-account tiller --upgrade
```

#  Install the app

```
helm upgrade test . -i --wait
sleep 120 # or more ;)
curl -k https://$(minikube ip)/routes
http http://$(minikube ip)/frontend/
```

# Upgrade and apply in the cluster

If you make changes to the configuration you can easily apply it to your local cluster.

```
helm upgrade test . -i --wait
```

# Create chaos

```
helm install --set labels='app=cloud',namespaces='!kube-system\,!production',rbac.create=true,dryRun=false stable/chaoskube --debug --name chaos
```

# Delete the app

```
helm delete test --purge
helm delete chaos --purge
```