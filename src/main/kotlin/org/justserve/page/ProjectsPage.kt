package org.justserve.page

import com.microsoft.playwright.Page
import jakarta.inject.Singleton

/**
 * /projects page
 * @since 0.1.0
 * @author Jonathan Zollinger
 */
@Singleton
class ProjectsPage(page: Page) : JustServePage(page) {}
