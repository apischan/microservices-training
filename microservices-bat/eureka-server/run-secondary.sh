#!/usr/bin/env bash

java -jar -Xmx128m -Dspring.profiles.active=secondary ../../eureka-server/target/eureka-server-0.0.1-SNAPSHOT.jar