## Welcome to Lowcomote/MDEForge microservices

-- <code> The microservices below are developed using Spring boot (Java) and dockerized. </code>

---

If you want to use the microservices without cloning the code, It gets even easier!!

Retrieve the image(microservice) you would like to run from my docker hub repo.

- Search my username _indamutsa_, and you will see the images available
- Copy and paste the command below in your terminal

_Image name example_

- indamutsa/model-query-image

The container name is optional, and you can set any name you want

Run the command below

```sh
docker run --name {container-name} -d -p 9000:8087 indamutsa/{image-name}
```

Inspect docker-compose.yml file to see the ports used by each service.

The service will be available on port 9000 locally.

```sh
localhost:9000/api-docs
```

---

If you want to pull the code locally and use it, just follow the instructions below

Clone the repository

```sh
git clone https://github.com/Indamutsa/model-management-services.git
```

Once downloaded you can run each service separately

```sh
cd microservice-folder
mvn spring-boot:run
```

You can easily run the microservice

The script run.sh:

1. Packages the service in a jar file
2. Containerizes the the jar service in a docker image
3. runs the service in background
4. The command below can take a port argument, if you dont provide it, it will use the default

#Run the script with no port argument

```sh
./run.sh
```

#or with port argument

```sh
./run.sh 9999
```

#Head to the url below in your browser and you can use openapi 3.0 to test the service

---

localhost:9000/api-docs

## Running the cluster

We will use both docker-compose and kubernetes to run the cluster.

---

### Docker-compose

<img src="./images/logic-workflow.jpg" alt="workflow" width="500"/>
We can run the cluster using docker-compose. The docker-compose.yml file is in the root directory of the project.
But before you can run the cluster, you have to build the images and push them to the registry.
Be mindful the DSL backend image is tagged with the version and compose. The only difference, is that it can be directly accessed externally using localhost:8082

You need to switch to the `docker-compose` branch to have the right docker-compose file.

```sh
git checkout docker-compose
```

Follow the instructions in the README.md file at the root of the project.

---

## Kubernetes

<img src="./images/High Level architecture-1.jpg" alt="architecture" width="500"/>
Let us first have the cluster installed locally using minikube.
But first, make sure you have helm, kubeclt and minikube installed on your machine.

Switch to the `kubernetes` branch to have the right helm charts.

```sh
git checkout kubernetes
```

Follow the instructions in the README.md file at the root of the project.
