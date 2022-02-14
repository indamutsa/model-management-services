### Welcome to Lowcomote/MDEForge microservices

#### The microservices below are developed using Spring boot (Java)

---

### If you want to use the microservices without cloning the code,

### It gets even easier!!

#### Retrieve the image(microservice) you would like to run from my docker hub repo.

- Search my username _indamutsa_, and you will see the images available
- Copy and paste the command below in your terminal

_Image name example_

- indamutsa/model-query-image

###### The container name is optional, and you can set any name you want

##### Run the command below

docker run --name {container-name} -d -p 9000:8087 indamutsa/{image-name}

### The service will be available on port 9000 locally.

localhost:9000/api-docs

---

## If you want to pull the code locally and use it, just follow the instructions below

### Clone the repository

git clone https://github.com/Indamutsa/model-management-services.git

### Once downloaded you can run each service separately

- cd microservice-folder
- mvn spring-boot:run

### You can easily run the microservice

### The script run.sh:

1. Packages the service in a jar file
2. Containerizes the the jar service in a docker image
3. runs the service in background
4. The command below can take a port argument, if you dont provide it, it will use the default

#### Run the script with no port argument

- ./run.sh

#### or with port argument

- ./run.sh 9999

#### Head to the url below in your browser and you can use openapi 3.0 to test the service

---

localhost:9000/api-docs

####

### Running the cluster

####

We use helm to run the cluster.
-- Run **helm install lowcomote** to install the chart
-- If you want to uninstall the charts **helm uninstall lowcomote**
-- if you want to update the charts **helm upgrade lowcomote .** in the current directory.

Before you can run these commands, make sure you have built and pushed on the cloud the correct containers.
For instance, i already have a script that take the name of the container and version, build it and push it to the registry
-- build.sh dsl-frontend v2.9

After pushing on the cloud, you have to upgrade the helm charts values, especially the version of the container to retrieve the latest version.

Before you can upgrade the charts, it's good to delete the current deployment you want to update
-- kube delete deployment.apps/dsl-frontend-deployment service/dsl-frontend-server
For instance, here i would like to update the service and deployment above, so i removed them.

Then, now i can update the charts: helm upgrade lowcomote helm-deployment/

In case you want to forward a given container to localhost, use portforwarding
-- kube port-forward service/dsl-frontend-server 9999:8080

To enter a container while you are running the cluster:
-- kubectl exec -it dsl-backend-server -- /bin/sh

To get the node where the cluster is deployed:
-- kube get node -o wide

To connect to GKE cluster
-- gcloud container clusters get-credentials lowcomote-cluster --zone europe-west3-a --project lowcomote

To allow the cluster
-- gcloud compute firewall-rules create allowed-node-ports --allow tcp:30100

To log a deployment
-- kube logs deployment.apps/dsl-backend-deployment
