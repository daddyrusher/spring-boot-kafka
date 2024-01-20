FROM centos

RUN yum install -y java

VOLUME /tmp
ADD /target/consumer.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java", "-jar","/app.jar"]