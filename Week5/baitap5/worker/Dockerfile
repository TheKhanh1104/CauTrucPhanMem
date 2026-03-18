FROM maven:3.8.6-openjdk-11

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn package -DskipTests

CMD ["java", "-cp", "target/classes:target/dependency/*", "com.example.Worker"]