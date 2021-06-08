# We first build the jar
mvn package

# We build the the image
docker build -t gateway-image .


# First check if the the port is provided
# If it is not provided, you need to set
value=$1

# shellcheck disable=SC2157
if [ -z "$value" ] ;
  then
    value=7500
fi

# Run the container
docker run --name gateway-container -d -p $value:7500 gateway-image
