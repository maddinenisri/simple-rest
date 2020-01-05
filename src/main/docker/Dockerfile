FROM tomcat:8-alpine

ENV WAR_FILE simple-rest-1.0.0.war
ENV WEBAPP_DIR /usr/local/tomcat/webapps
EXPOSE 8080
COPY $WAR_FILE $WEBAPP_DIR/simple-rest.war

CMD ["catalina.sh", "run"]
