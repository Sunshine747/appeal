FROM maven

COPY . .

RUN apt-get update && \
        apt-get install -y iceweasel && \
        apt-get clean



ENTRYPOINT ["mvn", "clean", "test"]