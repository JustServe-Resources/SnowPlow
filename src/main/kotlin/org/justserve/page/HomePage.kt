package org.justserve.page

import com.microsoft.playwright.Page
import jakarta.inject.Singleton

/**
 * default home page
 * @since 0.1.0
 * @author Jonathan Zollinger
 */
@Singleton
class HomePage(page: Page) : JustServePage(page) {}
