#!/bin/bash
# Version: 1.0
# Author : Denislav Veizov

docker volume rm $(docker volume list | grep 'orders-system_' | awk '{print $2}')
