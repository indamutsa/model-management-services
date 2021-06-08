# We first build the jar
mvn package

# We build the the images
docker build -t validation-image .


# First check if the the port is provided
# If it is not provided, you need to set
value=$1

# shellcheck disable=SC2157
if [ -z "$value" ] ;
  then
    value=8086
fi

# Run the container
docker run --name validate-container -d -p $value:8086 validation-image
