FROM openjdk:11-jre-slim as builder
VOLUME /tmp
ADD build/libs/ContractsServer-0.0.1-SNAPSHOT.jar /opt/ContractsServer.jar
ENTRYPOINT ["java","-jar","/opt/ContractsServer.jar"]