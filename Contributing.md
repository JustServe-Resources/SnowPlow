# Contributing

By participating in this project, you agree to abide our
[code of conduct](CodeOfConduct.md).

## Set up your machine

`SnowPlow` is written in [Groovy], runs on  [Eclipse Temurin's 17 OpenJDK], and uses [Gradle] to
handle dependencies. 

Prerequisites:

- [Java 17.0.9] installed locally
- Gradle doesn't need to be installed locally, a [gradle wrapper] is provided with this repo. 
- Docker or Podman installed and running at compile time

## Getting Started

Create your own fork of `SnowPlow`, clone your fork and call the gradle wrapper to build the project

```shell
git clone git@github.com:my-user/SnowPlow.git
cd SnowPlow
./gradlew build
```
### IDE
Any IDE specific documentation will reference IntelliJ configured to [delegate build and run actions to gradle].

## Style Guide
This project uses [Groovy's default StyleGuide]

## Geb
Browser Automation is done with [Geb], which is a Selenium wrapper. SnowPlow runs with the Page Object Model. 

## Minimum Testing
The Page Object Model provided in this repo is to be used between all of JustServe's supported languages and device sizes. See [JustServe's Yellow Brick Road] for supported browser sizes and languages.


[Groovy]:https://groovy.apache.org/index.html
[Gradle]:https://docs.gradle.org/current/userguide/gradle_basics.html#gradle
[Eclipse Temurin's 17 OpenJDK]:https://adoptium.net/temurin/releases/?version=17
[Java 17.0.9]:https://sdkman.io/jdks#tem
[gradle wrapper]:https://docs.gradle.org/current/userguide/gradle_wrapper_basics.html
[delegate build and run actions to gradle]:https://www.jetbrains.com/help/idea/work-with-gradle-projects.html#delegate_build_gradle
[Groovy's default StyleGuide]:https://groovy-lang.org/style-guide.html
[Geb]:https://www.gebish.org/manual/current/
[JustServe's Yellow Brick Road]:https://github.com/JustServe-Resources/Documentation/tree/main/core/src/docs/asciidoc/en/Yellow%20Brick%20Road