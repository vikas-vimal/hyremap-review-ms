FROM openjdk:23-slim
COPY target/hyremap-review-ms-0.0.1-SNAPSHOT.jar hyremap-review-ms-0.0.1.jar
ENTRYPOINT ["java","-jar","/hyremap-review-ms-0.0.1.jar"]
