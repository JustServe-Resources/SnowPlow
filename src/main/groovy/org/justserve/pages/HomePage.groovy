package org.justserve.pages

import org.openqa.selenium.By

/**
 * Page object for justserve.org
 */
class HomePage extends JustServePage {

    @SuppressWarnings("unused")
    static at = { (title == "JustServe") }
    static content = {
        //soonestCarouselNextButton { $(By.xpath("//div[starts-with(@class,\"soonest section\")]//button[@aria-label=\"Next\"]")) }
        //soonestCarouselPreviousButton { $(By.xpath("//div[starts-with(@class,\"soonest section\")]//button[@aria-label=\"Previous\"]")) }
        projectCardLocations { $(By.xpath("//div[@class=\"soonest section desktop\"]//div[@class=\"project-card-location\"]")) }
    }

//    String[][] getSoonestProjectLocations() {

//    }
}

