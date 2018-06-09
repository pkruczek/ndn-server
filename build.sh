#!/usr/bin/env bash

set -e

mvn clean compile assembly:single

cp target/*jar-with-dependencies.jar docker/server/.

pushd docker
sudo docker-compose build
popd