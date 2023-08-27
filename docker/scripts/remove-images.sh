#!/bin/bash
docker rmi $(docker images 'orders-api' -q)
docker rmi $(docker images 'orders-consumer' -q)
