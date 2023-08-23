#!/bin/bash
docker compose -f ./merchant/docker/docker-compose.yml down
docker compose -f ./notification-provider/docker/docker-compose.yml down

