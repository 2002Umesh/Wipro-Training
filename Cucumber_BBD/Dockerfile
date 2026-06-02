FROM maven:3.9.15-eclipse-temurin-21

# Install Chrome dependencies
RUN apt-get update && apt-get install -y \
    wget \
    gnupg \
    unzip \
    curl

# Add Google Chrome repository
RUN wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | \
    gpg --dearmor > /usr/share/keyrings/google-linux.gpg

RUN echo "deb [arch=amd64 signed-by=/usr/share/keyrings/google-linux.gpg] http://dl.google.com/linux/chrome/deb/ stable main" \
    > /etc/apt/sources.list.d/google.list

# Install Chrome
RUN apt-get update && apt-get install -y google-chrome-stable

WORKDIR /app

COPY . .

RUN mvn clean install -DskipTests

CMD ["mvn","-Dtest=myStepDefination.TestRunner","test"]