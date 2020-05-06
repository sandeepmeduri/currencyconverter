FROM openjdk:8-jdk-alpine
RUN rm -rf /usr/src/currency
WORKDIR /usr/src/currency
EXPOSE 8083
ENTRYPOINT java -jar /usr/src/currency/CurrencyExchange-0.0.1-SNAPSHOT.jar