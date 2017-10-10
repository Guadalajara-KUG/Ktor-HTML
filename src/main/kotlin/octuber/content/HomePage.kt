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
            link(rel = "icon", type = ContentType.Image.PNG.toString(), href = "/favicon.ico")
            link(rel = "shortcut icon", type = ContentType.Image.PNG.toString(), href = "/favicon.ico")

            meta { charset = "UTF-8" }
            meta(name = "author", content = "Sierisimo Sier")
            meta(name = "keywords", content = arrayOf("KUG", "Kotlin", "Lambda").joinToString(","))
            meta(name = "viewport", content = "width=device-width, initial-scale=1.0")
        }
        body {


            p {

            }

            img(alt = "GDG", src = "/static/gdg.png")
            img(alt = "GDG", src = "/gdg.png")
            img(alt = "GDG", src = "gdg.png")
        }
    }
}
