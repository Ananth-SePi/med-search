FROM openjdk:17
MAINTAINER Ananth Pitchiah <ananth.pitchiah.95@gmail.com>

ADD /build/libs/med-search-0.0.1-SNAPSHOT.jar med-search.jar
ENTRYPOINT ["java","-jar","med-search.jar"]

EXPOSE 8900
