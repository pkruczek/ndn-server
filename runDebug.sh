#!/usr/bin/env bash

java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005 -jar target/ndn-server-1.0-SNAPSHOT-jar-with-dependencies.jar