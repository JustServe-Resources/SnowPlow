package org.justserve.page

import com.microsoft.playwright.Page
import jakarta.inject.Singleton

/**
 * /about page
 * @since 0.1.0
 * @author Jonathan Zollinger
 */
@Singleton
class AboutUsPage(page: Page, override val path: String = "/about") : JustServePage(page) {}