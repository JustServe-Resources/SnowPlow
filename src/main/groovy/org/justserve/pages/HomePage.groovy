package org.justserve.pages

import org.openqa.selenium.By

/**
 * Page object for justserve.org
 */
class HomePage extends JustServePage {
    static content = {
        soonestCarouselNextButton { $(By.xpath("//div[starts-with(@class,\"soonest section\")]//button[@aria-label=\"Next\"]")) }
        soonestCarouselPreviousButton { $(By.xpath("//div[starts-with(@class,\"soonest section\")]//button[@aria-label=\"Previous\"]")) }
        projectCardLocations { $(By.xpath("//div[@class='soonest section desktop']//div[@class='project-card-location']")) }
    }

    @SuppressWarnings("unused")
    static at = { (title == "JustServe") }

    String[][] getSoonestProjectLocations() {
        waitFor(5, 0.5) { projectCardLocations.first().isDisplayed() } // this worked too quickly, I'm skeptical

        return projectCardLocations.collect(it -> it.text().split(",").collect())
    }
}

