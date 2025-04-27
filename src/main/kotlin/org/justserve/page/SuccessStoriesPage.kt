package org.justserve.page

import com.microsoft.playwright.Page
import jakarta.inject.Singleton

/**
 * /stories page
 * @since 0.1.0
 * @author Jonathan Zollinger
 */
@Singleton
class SuccessStoriesPage(page: Page, override val path: String = "/stories") : JustServePage(page) {}
