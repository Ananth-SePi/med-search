FROM openjdk:17
MAINTAINER Ananth Pitchiah <ananth.pitchiah.95@gmail.com>

ADD /build/libs/med-search-1.0.0.jar med-search.jar
ENTRYPOINT ["java","-jar","med-search.jar"]

EXPOSE 8900
