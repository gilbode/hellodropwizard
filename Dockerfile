FROM gcr.io/google-appengine/openjdk:8

COPY build/libs/*.jar hellodropwizard.jar

CMD [ "java", "-jar","hellodropwizard.jar", "server" ]
