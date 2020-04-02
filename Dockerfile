
FROM maven:latest
WORKDIR /app
COPY . .
ENTRYPOINT ["mvn", "pom.xml package"]




#ADD build/discovery-service-0.0.1-SNAPSHOT.jar discovery-service-0.0.1-SNAPSHOT.jar
## Add wait-for-it
#ADD sh/wait-for-it.sh wait-for-it.sh
#RUN chmod +x /wait-for-it.sh
##ENTRYPOINT ["java", "-jar", "discovery-service-0.0.1-SNAPSHOT.jar"]
