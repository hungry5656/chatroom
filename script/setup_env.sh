#!/usr/bin/env bash

################################################################################
# Help                                                                         #
################################################################################
function Help() {
    echo -e "Script to install all the environment dependencies for this project."
    echo
    echo -e "Syntax: ./setup_env.sh [-h|m]"
    echo -e "options:"
    echo -e "\t-h --help\tShow this help."
    echo -e "\t-m --mysql\tInstall mysql-server."
    echo
}

if [[ $* == *--help* ]] || [[ $* == *-h* ]]; then
  Help
  exit
fi

################################################################################
# Execute script                                                               #
################################################################################

# zulu jdk21 install

# maven install

# mysql install
if [[ $* == *--mysql* ]] || [[ $* == *-m* ]]; then
  sudo apt-get install mysql-server
fi
