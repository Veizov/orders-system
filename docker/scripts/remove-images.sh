#!/bin/bash
# Version: 1.0
# Author : Denislav Veizov

docker rmi $(docker images 'orders-api' -q)
docker rmi $(docker images 'orders-consumer' -q)
