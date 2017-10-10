package octuber.content

import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import org.jetbrains.ktor.http.ContentType

fun buildHTML5(prettyPint: Boolean = true, block: HTML.() -> Unit): String {
    return StringBuilder().apply {
        append("<!DOCTYPE html>\n")
        appendHTML(prettyPint).html(block)
    }.toString()
}


fun getHomePage(): String {
    return buildHTML5 {
        head {
            basicInfo()
        }
        body {

        }
    }
}

fun HEAD.basicInfo() {
    link(rel = "icon", type = ContentType.Image.PNG.toString(), href = "/content/favicon.ico")
    link(rel = "shortcut icon", type = ContentType.Image.PNG.toString(), href = "/content/favicon.ico")

    meta { charset = "UTF-8" }
    meta(name = "author", content = "Sierisimo Sier")
    meta(name = "keywords", content = arrayOf("KUG", "Kotlin", "Lambda").joinToString(","))
    meta(name = "viewport", content = "width=device-width, initial-scale=1.0")
}
