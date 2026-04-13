#  Correct stable Java image
FROM eclipse-temurin:17-jdk

# Working directory
WORKDIR /app

# Copy project
COPY . .

# Build using Gradle
RUN chmod +x gradlew
RUN ./gradlew clean build -x test

# Expose port
EXPOSE 8080

# Run jar
CMD ["java", "-jar", "build/libs/calculatorhub-0.0.1-SNAPSHOT.jar"]