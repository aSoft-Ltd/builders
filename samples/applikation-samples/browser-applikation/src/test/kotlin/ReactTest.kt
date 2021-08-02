import kotlinx.browser.document
import org.w3c.dom.HTMLDivElement
import kotlin.test.Test
import expect.*
import kotlinx.html.dom.create
import kotlinx.html.js.div
import react.dom.render
import tz.co.asoft.Counter

class ReactTest {
    @Test
    fun should_create_a_div() {
        val div = document.createElement("div") as HTMLDivElement
        expect(div).toBeNonNull()
        render(div) { Counter() }
    }

    @Test
    fun should_fail() {
        
    }
}