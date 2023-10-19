FROM openjdk

MAINTAINER jaguar017

WORKDIR /app

COPY target/phoneBook.jar /app/phoneBook.jar

ENTRYPOINT ["java", "-jar", "phoneBook.jar"]