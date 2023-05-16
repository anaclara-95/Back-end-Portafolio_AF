FROM amazoncorretto:18-alpine-jdk
maintainer Anaclara M Ferrando
copy target/AF-0.0.1-SNAPSHOT.jar   AF-app.jar
entrypoint ["java","-jar","/AF-app.jar"]
