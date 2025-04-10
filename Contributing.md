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
- Git


Create your own fork of `SnowPlow`, clone your fork and call the gradle wrapper to build the project

```shell
git clone git@github.com:my-user/SnowPlow.git
cd SnowPlow
./gradlew build
```
## IDE
Any IDE specific documentation will reference IntelliJ configured to [delegate build and run actions to gradle].

## Style Guide
- This project uses [Groovy's default StyleGuide]
- We follow (and enforce) [conventional commits] in this repo.

## Geb
Browser Automation is done with [Geb], which is a Selenium wrapper. SnowPlow runs with the Page Object Model. 

## Minimum Testing
The Page Object Model provided in this repo is to be used between all of JustServe's supported languages and device sizes. See [JustServe's Yellow Brick Road] for supported browser sizes and languages.

Tests should be data driven and validate the documented API. That means if your page object model reports that you can click a button - write a test that validates the behavior. If the button click has any sort of [branch in flow] (ie navigates to a new page - see [at-checking]), test all branches. Nothing more, nothing less.

## Example of an insufficient test

This test looks to do enough. I wrote it, I thought it was enough. All I added with this PR was the header links in JustServe. In my mind, I just needed to test that they navigated properly and I'd be golden.

> [!NOTE] 
> Separate from this test are tests dedicated to failed validations. The branch coverage is addressed outside of this test.

```groovy
    @Unroll
    def "clicking #link link in the header navigates to the #link page"() {
        when:
        to JustServePage

        then:
        JustServePage page = browser.page(JustServePage)

        when:
        page.header."$methodName"()

        then:
        at expectedPage

        where:
        link              | methodName            | expectedPage
        "About Us"        | "clickAboutUs"        | AboutUsPage
        "Projects"        | "clickProjects"       | ProjectsPage
        "Organizations"   | "clickOrganizations"  | OrganizationsPage
        "Success Stories" | "clickSuccessStories" | SuccessStoriesPage
        "Home Page"       | "clickHeaderLogo"     | HomePage
    }

```

I later realized that my selectors I wrote for the header will only work in the english language, and my tests didn't catch that. Nor do my tests account for the supported browser sizes, where my selectors aren't usable on smaller screens. I wrote bad code and my tests didn't tell me that.

# Example of a good test

 TODO (lol)



[Groovy]:https://groovy.apache.org/index.html
[Gradle]:https://docs.gradle.org/current/userguide/gradle_basics.html#gradle
[Eclipse Temurin's 17 OpenJDK]:https://adoptium.net/temurin/releases/?version=17
[Java 17.0.9]:https://sdkman.io/jdks#tem
[gradle wrapper]:https://docs.gradle.org/current/userguide/gradle_wrapper_basics.html
[delegate build and run actions to gradle]:https://www.jetbrains.com/help/idea/work-with-gradle-projects.html#delegate_build_gradle
[Groovy's default StyleGuide]:https://groovy-lang.org/style-guide.html
[Geb]:https://www.gebish.org/manual/current/
[JustServe's Yellow Brick Road]:https://github.com/JustServe-Resources/Documentation/tree/main/core/src/docs/asciidoc/en/Yellow%20Brick%20Road
[branch in flow]:https://medium.com/@zubairkhansh/branch-testing-and-branch-coverage-3fb4bbd9f949
[conventional commits]:https://www.conventionalcommits.org/en/v1.0.0/#summary]
[at-checking]:https://www.gebish.org/manual/current/#at-checking