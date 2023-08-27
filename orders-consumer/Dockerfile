ARG MVN_VERSION=3.8.3
ARG JDK_VERSION=17

FROM maven:${MVN_VERSION}-openjdk-${JDK_VERSION} AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean install -DskipTests

FROM openjdk:${JDK_VERSION}
COPY --from=build /usr/src/app/target/orders-consumer.jar /usr/app/orders-consumer.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/usr/app/orders-consumer.jar"]