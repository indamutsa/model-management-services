# We first build the jar
mvn package

# We build the the image
docker build -t registry-image .


# First check if the the port is provided
# If it is not provided, you need to set
value=$1

# shellcheck disable=SC2157
if [ -z "$value" ] ;
  then
    value=7070
fi

# Run the container
docker run --name registry-container -d -p $value:7070 registry-image
