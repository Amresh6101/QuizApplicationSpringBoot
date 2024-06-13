FROM openjdk:17-jdk-alpine
RUN mkdir "app"
WORKDIR /app
ADD quiz.jar /app
EXPOSE 8080
CMD ["java","-jar","quiz.jar"]


