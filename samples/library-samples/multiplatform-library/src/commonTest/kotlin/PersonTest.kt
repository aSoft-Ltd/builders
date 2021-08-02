import expect.expect
import tz.co.asoft.Person
import kotlin.test.Test

class PersonTest {
    @Test
    fun should_just_test() {
        val p = Person("John Doe")
        expect(p.name).toBe("John Doe")
    }

    @Test
    fun should_fail() {
        expect { TODO() }.toFail()
    }
}