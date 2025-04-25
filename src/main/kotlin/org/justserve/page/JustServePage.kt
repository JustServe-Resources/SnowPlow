package org.justserve.page

import com.microsoft.playwright.Page
import jakarta.inject.Singleton

@Singleton
open class JustServePage(
    val page: Page
) {
}