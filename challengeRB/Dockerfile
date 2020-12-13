FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package -DskipTests

FROM openjdk:12.0.2
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/ChallengeRB-0.0.1.jar /app
ENTRYPOINT ["java","-jar","/app/ChallengeRB-0.0.1.jar"]
