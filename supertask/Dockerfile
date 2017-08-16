FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER zhenpeng<zhenpeng@ctrip.com>

VOLUME /tmp
COPY ./supertask-0.0.1-SNAPSHOT.jar /supertask.jar
COPY ./config /config
ENTRYPOINT [ "java", "-jar", "/supertask.jar" ]

EXPOSE 8091