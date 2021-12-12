#!/bin/sh
echo "Running pre-commit hook..."
echo "Running ktlint formatting task"
./gradlew formatKotlin
echo "Running ktlint check task"
./gradlew lintKotlin
echo "Running detekt"
./gradlew detekt



