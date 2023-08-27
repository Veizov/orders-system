#!/bin/bash
# Version: 1.0
# Author : Denislav Veizov

docker compose -f ../docker-compose.yml up kafka-ui -d
docker compose -f ../docker-compose.yml up postgres -d
