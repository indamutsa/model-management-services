# We first build the jar
mvn package

# We build the the images
docker build -t query-image .


# First check if the the port is provided
# If it is not provided, you need to set
value=$1

# Checking if the input is not defined
if [ -z "$value" ] ;
  then
    value=8087
fi

# Run the container
docker run --name query-container -d -p $value:8087 query-image
