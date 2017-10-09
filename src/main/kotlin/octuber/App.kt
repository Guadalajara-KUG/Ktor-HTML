package octuber

import octuber.content.getHomePage
import org.jetbrains.ktor.application.Application
import org.jetbrains.ktor.application.install
import org.jetbrains.ktor.content.file
import org.jetbrains.ktor.content.static
import org.jetbrains.ktor.features.CallLogging
import org.jetbrains.ktor.features.DefaultHeaders
import org.jetbrains.ktor.http.ContentType
import org.jetbrains.ktor.response.respondText
import org.jetbrains.ktor.routing.get
import org.jetbrains.ktor.routing.routing

fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging)
    routing {
        static {
            file("favicon.ico")
            file("gdg.png")
        }
        get("/") {
            call.respondText(getHomePage(), ContentType.Text.Html)
        }
    }
}
