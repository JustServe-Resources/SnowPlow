package org.justserve

/**
 * language locales to choose from in the language menu. Does not reflect the true locale for a user
 */
enum Language {
    ENGLISH("en-us"),
    WRONG_ENGLISH("en-gb"),
    SPANISH("es-mx"),
    FRENCH("fr-ca"),
    PORTUGUESE("pt-pt"),
    HUNGARIAN("hu-hu"),
    GERMAN("de-de")

    final String locale

    Language(String locale) {
        this.locale = locale
    }

    @Override
    String toString() {
        return locale
    }
}