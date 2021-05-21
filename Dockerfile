FROM openjdk:8u191-jre-alpine3.8
#install curl and jq for healthcheck.sh script
RUN apk add curl jq
#define working dir in container
WORKDIR /usr/share/bfsdemo

#Add jar files and dependencies directory
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs
#Add any other test data .csv .json .xls testdata dependencies files

#Add testng suite files
ADD spethomepage-module.xml spethomepage-module.xml
ADD spetsearchpage-module.xml spetsearchpage-module.xml
#Add healthcheck.sh script
ADD healthcheck.sh healthcheck.sh
#shell script migrated from windows to Linux...so apply this to convert format
RUN dos2unix healthcheck.sh
#BROWSER
#HUB_HOST
#MODULE
#execute healthcheck.sh as part of Entrypoint
ENTRYPOINT sh healthcheck.sh