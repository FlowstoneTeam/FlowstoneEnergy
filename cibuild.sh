#!/bin/bash
set -ev
chmod +x gradlew
./gradlew setupCIWorkspace
./gradlew build