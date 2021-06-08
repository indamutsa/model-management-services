#!/bin/bash 
docker-compose down -v --remove-orphans

docker rmi -f  eureka-registry-server  api-gateway-service  model-storage-image model-query-image model-transformation-image model-validation-image model-comparison-image 

# docker-compose up -d db

# while ! docker-compose exec db mysql --user=arsene --password=arsene -e "SELECT 1" >/dev/null 2>&1; do
#     sleep 1
# done


# Model management services
# =========================
# cd storage-service
# rm -rf target/
# mvn clean compile package -Dmaven.test.skip=true
# cd ..


# cd model-query
# rm -rf target/
# mvn clean compile package
# cd .. 


# cd model-transformation
# rm -rf target/
# mvn clean compile package
# cd .. 


# cd model-validation
# rm -rf target/
# mvn clean compile package
# cd .. 


# cd model-comparison
# rm -rf target/
# mvn clean compile package
# cd .. 


# Eureka service registry
# =======================
# cd service-registry
# rm -rf target/
# mvn clean compile package
# cd .. 


# # Eureka cloud api gateway
# # ========================
# cd service-gateway
# rm -rf target/
# mvn clean compile package
# cd .. 


# Authorization and Authentication server for underneath microservices
# ====================================================================
cd authorization-server
rm -rf target/
mvn clean compile package -Dmaven.test.skip=true
cd ..


docker-compose up --build
