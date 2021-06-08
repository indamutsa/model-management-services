# We first build the jar
mvn clean compile package

# We build the the images
docker build -t auth-image .

# First check if the the port is provided
# If it is not provided, you need to set
value=$1

# Checking if the input is not defined
if [ -z "$value" ] ;
  then
    value=8000
fi

# Run the container
docker run --name auth-container -d -p $value:8000 auth-image
