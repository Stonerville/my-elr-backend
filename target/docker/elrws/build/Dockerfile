FROM openjdk:latest
ARG CACHEBUST=1
ARG JAR_FILE
ARG SPRING_PROFILE=dev
ARG artifactId
ENV WORK_DIR=usr/elrapp/
ENV SERVICE_DIR=service/
RUN mkdir -p ${WORK_DIR}${SERVICE_DIR}
ENV SOURCE_DEST=target/${JAR_FILE}
ENV DOCKER_DEST=/${WORK_DIR}${SERVICE_DIR}elrws.jar
#WORKDIR /${WORK_DIR}
COPY ${SOURCE_DEST} ${DOCKER_DEST}
EXPOSE 8888
#CMD java -Dspring.profiles.active=$SPRING_PROFILE -Djava.security.egd=file:/dev/./urandom -jar ${DOCKER_DEST}
ENTRYPOINT exec java -Dspring.profiles.active=$SPRING_PROFILE -Djava.security.egd=file:/dev/./urandom -jar ${DOCKER_DEST}
#ENTRYPOINT ["java","-Dspring.profiles.active="$SPRING_PROFILE,"-Djava.security.egd=file:/dev/./urandom","-jar",${DOCKER_DEST}]
