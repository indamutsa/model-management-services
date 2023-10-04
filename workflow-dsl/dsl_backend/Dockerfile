# Use AdoptOpenJDK 11
FROM adoptopenjdk:11-jdk-hotspot

# Create app directory
WORKDIR /app

# Update package list and install dependencies for curl
RUN apt-get update && \
    apt-get install -y curl

# Install Node.js 12.x
RUN curl -fsSL https://deb.nodesource.com/setup_12.x | bash - && \
    apt-get install -y nodejs

# Copy package.json and package-lock.json
COPY package*.json ./

# Install npm packages
RUN npm install

# Copy the rest of the application
COPY . .

# Expose the application port
EXPOSE 8082

# Start the application
CMD [ "npm", "run", "start" ]



# FROM adoptopenjdk/openjdk11

# # Create app directory
# WORKDIR /app

# # Install app dependencies
# # A wildcard is used to ensure both package.json AND package-lock.json are copied
# # where available (npm@5+)
# COPY package*.json ./

# RUN apt-get update; apt-get install -y curl \
#     && curl -sL https://deb.nodesource.com/setup_14.x | bash - \
#     && apt-get install -y nodejs \
#     && curl -L https://www.npmjs.com/install.sh | sh 


# RUN npm install
# # If you are building your code for production
# # RUN npm ci --only=production

# # Bundle app source
# COPY . .

# EXPOSE 8082
# CMD [ "npm", "run", "start" ]
