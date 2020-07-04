FROM maven:3.6.3-adoptopenjdk-11 as dependant
WORKDIR /app
COPY . ./
RUN mvn clean install

FROM jboss/wildfly:20.0.0.Final


USER root

COPY --from=dependant /app/serverconf/mysql-connector-java-8.0.20.jar /opt/mysql-connector-java-8.0.20.jar
COPY --from=dependant /app/target/onlinebooks.war /opt/jboss/wildfly/standalone/deployments/onlinebooks.war


EXPOSE 8080

