#!/bin/bash 
docker-compose down -v --remove-orphans

docker rmi -f  eureka-registry-server  api-gateway-service  storage-service

# docker-compose up -d db

# while ! docker-compose exec db mysql --user=arsene --password=arsene -e "SELECT 1" >/dev/null 2>&1; do
#     sleep 1
# done

cd service-registry
rm -rf target/
mvn clean compile package
cd .. 


cd service-gateway
rm -rf target/
mvn clean compile package
cd .. 


cd storage-service
rm -rf target/
mvn clean compile package -Dmaven.test.skip=true
cd ..

docker-compose up