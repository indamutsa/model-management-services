## Welcome to Lowcomote/MDEForge microservices
#### The microservices below are developed using Spring boot (Java)

----------------------------------------------------------------------------
### If you want to use the microservices without cloning the code, 
### It gets even easier!!

#### Retrieve the image(microservice) you would like to run from my docker hub repo. 
* Search my username *indamutsa*, and you will see the images available
* Copy and paste the command below in your terminal

*Image name example*
* indamutsa/model-query-image
###### The container name is optional, and you can set any name you want

##### Run the command below
docker run --name {container-name} -d -p 9000:8087 indamutsa/{image-name}

### The service will be available on port 9000 locally.
localhost:9000/api-docs


-----------------------------------------------------------------------------


## If you want to pull the code locally and use it, just follow the instructions below

### Clone the repository
git clone https://github.com/Indamutsa/model-management-services.git

### Once downloaded you can run each service separately
* cd microservice-folder
* mvn spring-boot:run

### You can easily run the microservice
### The script run.sh:
1. Packages the service in a jar file
2. Containerizes the the jar service in a docker image
3. runs the service in background
4. The command below can take a port argument, if you dont provide it, it will use the default

#### Run the script with no port argument
* ./run.sh
#### or with port argument
* ./run.sh 9999


#### Head to the url below in your browser and you can use openapi 3.0 to test the service
-----------------------------------------------------------------------------
localhost:9000/api-docs
