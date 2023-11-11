FROM eclipse-temurin:17
EXPOSE 8080:8080
RUN mkdir /app
COPY ./build/libs/*-all.jar /app/blog.jar
ENTRYPOINT ["java", "-jar", "/app/blog.jar"]