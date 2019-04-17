FROM java:8
VOLUME /tmp
ADD target/azure-pki-1.0.jar pki-azure1.jar
RUN bash -c 'touch /pki-azure1.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/pki-azure1.jar"]
