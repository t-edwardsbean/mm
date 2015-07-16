#!/bin/bash
mvn clean package -Dmaven.test.skip=true -Pprod
cd target
scp mm-1.0-SNAPSHOT.jar root@h15:/home/market/mm
#ssh root@h15 "su market;cd /home/market/mm/;sh stop.sh;sh start.sh"
