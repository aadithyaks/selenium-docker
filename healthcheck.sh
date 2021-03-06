# Environment variables -e
# HUB_HOST
# BROWSER
# MODULE
echo "Checking if hub is ready - $HUB_HOST"
while [ "$( curl -s http://172.31.24.255:4444/wd/hub/status | jq -r .value.ready )" != true ]
do
  sleep 1
done
# start the java program
java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* \
  -DHUB_HOST=$HUB_HOST \
  -DBROWSER=$BROWSER \
  org.testng.TestNG $MODULE