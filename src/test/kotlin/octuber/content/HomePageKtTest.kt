package octuber.content

import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.p
import org.junit.Assert.assertEquals
import org.junit.Test

class HomePageKtTest {
    @Test
    fun test_buildHTML5PrettyPrintOff() {
        val start = "<!DOCTYPE html>\n<html>"
        val end = "</html>"
        var expected = start + end
        var actual = buildHTML5(false) {}

        assertEquals("Doctype should be included", expected, actual)

        expected = start + "<body><div><p>Hello</p></div></body>" + end
        actual = buildHTML5(false) { body { div { p { +"Hello" } } } }

        assertEquals("Always a Doctype, no matter what is appended and using false pretty print", expected, actual)
    }

    @Test
    fun test_getHomePage() {
        val content = getHomePage()
        println(content)
//        assertTrue(false)
    }

}