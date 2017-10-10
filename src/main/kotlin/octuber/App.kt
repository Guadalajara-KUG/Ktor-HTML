package octuber

import octuber.content.getHomePage
import org.jetbrains.ktor.application.Application
import org.jetbrains.ktor.application.install
import org.jetbrains.ktor.content.files
import org.jetbrains.ktor.content.static
import org.jetbrains.ktor.content.staticRootFolder
import org.jetbrains.ktor.features.CallLogging
import org.jetbrains.ktor.features.DefaultHeaders
import org.jetbrains.ktor.http.ContentType
import org.jetbrains.ktor.response.respondText
import org.jetbrains.ktor.routing.get
import org.jetbrains.ktor.routing.routing
import java.io.File

fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging)
    routing {
        static("content") {
            staticRootFolder = File("./web")
            files("img")
        }
        get("/") {
            call.respondText(getHomePage(), ContentType.Text.Html)
        }
    }
}