FROM openjdk

MAINTAINER jaguar017

WORKDIR /app

COPY target/PhoneBook_Java-0.0.1-SNAPSHOT.jar /app/PhoneBook_Java-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "PhoneBook_Java-0.0.1-SNAPSHOT.jar"]