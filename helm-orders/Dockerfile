FROM dock999evg/alp-ja:net
VOLUME /tmp
COPY maven/orders-jar/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]