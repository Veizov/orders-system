#!/bin/bash
docker compose -f ./merchant/docker/docker-compose.yml up -d
docker compose -f ./notification-provider/docker/docker-compose.yml up -d
