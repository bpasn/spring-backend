#FROM nginx
#
#COPY src /home/app/src
#COPY pom.xml /home/app
#COPY default.conf /etc/nginx/conf.d/default.conf
#
#RUN apt-get update && apt-get install -y \
#    maven \
#    openjdk-17-jdk \
#    vim \
#    net-tools
#ENV JAVA_HOME=/usr/bin/jvm/jvm/java-17-openjdk-amd64
#
#RUN export JAVA_HOME
##EXPORT JAVA_HOME=/usr/bin/jvm/openjdk-17
## mvn -g /home/app/pom.xml clean package
#WORDIR /home/app
#
#
#
#EXPOSE 80
#
##
## Package stage
##



FROM maven:3.8.3-openjdk-17 as build
WORKDIR /apps
COPY src src
COPY pom.xml .

RUN mvn -f pom.xml clean package

#
# Package stage
#
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /apps/target/backend-0.0.1-SNAPSHOT.jar /usr/local/lib/backend.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/backend.jar"]
#EXPOSE 8080




