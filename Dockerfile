# Use Java 17
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build project (Gradle)
RUN chmod +x gradlew
RUN ./gradlew build -x test

# Expose port
EXPOSE 8080

# Run jar (auto detect)
CMD ["sh", "-c", "java -jar build/libs/*.jar"]