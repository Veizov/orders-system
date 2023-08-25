#!/bin/bash
docker compose -f ../docker-compose.yml up kafka-ui -d
docker compose -f ../docker-compose.yml up postgres -d
