package cz.tadeasvalenta.sample.constants

object NetworkConstants {
    const val API_ENDPOINT = "https://api.github.com"
    const val CONNECT_TIMEOUT = 20 // in seconds
    const val WRITE_TIMEOUT = 20 // in seconds
    const val READ_TIMEOUT = 60 // in seconds

    object StatusCode {
        const val NO_CONTENT = 204
    }

    const val REPOSITORY_BUNDLE = "REPOSITORY_BUNDLE"
}