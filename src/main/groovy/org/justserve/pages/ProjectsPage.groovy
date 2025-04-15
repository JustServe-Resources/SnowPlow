package org.justserve.pages

import org.openqa.selenium.By

/**
 * Page object for justserve.org/projects
 */
class ProjectsPage extends JustServePage {

    @SuppressWarnings("unused")
    static at = {
        ["Projects", "Proyectos", "Projets", "Projetos", "Projektek", "Projekte"].any {
            expectedTitle -> title.startsWith(expectedTitle)
        }
    }
}
