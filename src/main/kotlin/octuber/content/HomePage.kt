package octuber.content

import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import org.jetbrains.ktor.http.ContentType

const val MEDIA_SCREEN_PROJECTION = "screen,projection"
const val STYLESHEET = "stylesheet"

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

            title {
                +"KUG KTor - Example "
            }

            loadMaterialTheme()
            optimizeForMobile()
            link {
                href = "/content/style.css"
                type = ContentType.Text.CSS.toString()
                rel = STYLESHEET
                media = MEDIA_SCREEN_PROJECTION
            }
        }
        body {
            nav(classes = "light-blue lighten-1") {
                role = "navigation"

                div(classes = "nav-wrapper container") {
                    a(classes = "brand-logo") {
                        id = "logo-container"
                        href = "#"
                        +"Logo"
                    }
                    ul(classes = "right hide-on-med-and-down") {
                        li { a { href = "#"; +"Navbar Link" } }
                    }

                    ul(classes = "side-nav") {
                        li { a { href = "#";+"Navbar Link" } }
                    }
                    a(classes = "button-collapse") {
                        href = "#"
                        attributes["data-activates"] = "nav-mobile"

                        i(classes = "material-icons") { +"Menu" }
                    }
                }
            }

            div(classes = "section no-pad-bot") {
                id = "index-banner"

                div(classes = "container") {
                    br {}
                    h1(classes = "header center orange-text") { +"Turbo-awesome website" }
                    div("row center") {
                        h5(classes = "header col s12 light") { +"This a turbo creative and turbo awesome website that shows the power of lambdas" }
                    }
                    div("row center") {
                        a(classes = "btn-large waves-effect waves-light orange") { +"Turbo boton" }
                    }
                    br {}
                }
            }

            divContainer {
                divSection {
                    divRow {
                        div(classes = "col s12 m4") {
                            div(classes = "icon-block") {
                                h2(classes = "center light-blue-text") { i(classes = "material-icons") { +"flash_on" } }
                                h5(classes = "center") { +"Kotlin is awesome" }
                                p(classes = "light") {
                                    +"We did most of the heavy lifting for you to provide a default stylings that incorporate our custom components. Additionally, we refined animations and transitions to provide a smoother experience for developers."
                                }
                            }
                        }

                        div(classes = "col s12 m4") {
                            div(classes = "icon-block") {
                                h2(classes = "center light-blue-text") { i(classes = "material-icons") { +"group" } }
                                h5(classes = "center") { +"Kotlin is and can create blocks" }
                                p(classes = "light") {
                                    +"By utilizing elements and principles of Material Design, we were able to create a framework that incorporates components and animations that provide more feedback to users. Additionally, a single underlying responsive system across all platforms allow for a more unified user experience."
                                }
                            }
                        }

                        div(classes = "col s12 m4") {
                            div(classes = "icon-block") {
                                h2(classes = "center light-blue-text") { i(classes = "material-icons") { +"settings" } }
                                h5(classes = "center") { +"Kotlin is and can create blocks" }
                                p(classes = "light") {
                                    +"We have provided detailed documentation as well as specific code examples to help new users get started. We are also always open to feedback and can answer any questions a user may have about Materialize."
                                }
                            }
                        }
                    }
                }
                br
            }

            footer(classes = "page-footer orange") {
                divContainer {
                    divSection {
                        divRow {
                            div(classes = "col 16 s12") {
                                h5(classes = "white-text") { +"Sier is a great dude" }
                            }
                        }
                    }
                }
            }

            bringThemeJs()
            script {
                src = "/content/init.js"
            }
        }
    }
}

fun HEAD.basicInfo() {
    link(rel = "icon", type = ContentType.Image.PNG.toString(), href = "/content/favicon.ico")
    link(rel = "shortcut icon", type = ContentType.Image.PNG.toString(), href = "/content/favicon.ico")

    meta {
        httpEquiv = "Content-Type"
        content = "${ContentType.Text.Html}; charset=UTF-8"
    }
    meta { charset = "UTF-8" }
    meta(name = "author", content = "Sierisimo Sier")
    meta(name = "keywords", content = arrayOf("KUG", "Kotlin", "Lambda").joinToString(","))
    meta(name = "viewport", content = "width=device-width, initial-scale=1.0")
}

fun HEAD.loadMaterialTheme() {
    style {
        type = ContentType.Text.CSS.toString()
        +"""/* fallback */
@font-face {
  font-family: 'Material Icons';
  font-style: normal;
  font-weight: 400;
  src: url(/content/material-icon.woff2) format('woff2');
}

.material-icons {
  font-family: 'Material Icons';
  font-weight: normal;
  font-style: normal;
  font-size: 24px;
  line-height: 1;
  letter-spacing: normal;
  text-transform: none;
  display: inline-block;
  white-space: nowrap;
  word-wrap: normal;
  direction: ltr;
  -moz-font-feature-settings: 'liga';
  -moz-osx-font-smoothing: grayscale;
}
 """
    }
    link {
        rel = "stylesheet"
        type = ContentType.Text.CSS.toString()
        href = "/content/materialize.min.css"
        media = "screen,projection"
    }
}

fun HEAD.optimizeForMobile() {
    meta {
        name = "viewport"
        content = "width=device-width, initial-scale=1.0"
    }
}

fun BODY.bringThemeJs() {
    script {
        type = ContentType.Text.JavaScript.toString()
        src = "/content/external/jquery-3.2.1.min.js"
    }
    script(type = ContentType.Text.JavaScript.toString(), src = "/content/external/materialize.min.js")
}

fun BODY.divContainer(block: DIV.() -> Unit) {
    div(classes = "container", block = block)
}

fun DIV.divSection(block: DIV.() -> Unit) {
    div(classes = "section", block = block)
}

fun DIV.divRow(block: DIV.() -> Unit) {
    div(classes = "row", block = block)
}

fun FOOTER.divContainer(block: DIV.() -> Unit) {
    div(classes = "container", block = block)
}