package org.justserve

/**
 * Language locales to choose from in the language menu. Does not reflect the true locale for a user
 * @since 0.1.0
 * @author Jonathan Zollinger
 */
enum class Language(private val locale: String) {
    ENGLISH("en-us"),
    WRONG_ENGLISH("en-gb"),
    SPANISH("es-mx"),
    FRENCH("fr-ca"),
    PORTUGUESE("pt-pt"),
    HUNGARIAN("hu-hu"),
    GERMAN("de-de");

    override fun toString(): String {
        return locale
    }

}