Social Rules
============

Natural Language Analyzer from Twitter posts

Requirements
------------

 * Java 8.+
 * Eclipse Luna with STS
 * Scala IDE
 * Valid Twitter APP (API Key / Secret)

Building
--------

Update Twitter configuration in:

    src/main/resources/application.properties

From console

    ./gradlew clean build

From Eclipse with Gradle Plugin

    File -> Import -> Gradle Project

From Eclipse without Gradle Plugin

    ./gradlew eclipse
    Eclipse -> File -> Import -> Existing Projects into Workspace