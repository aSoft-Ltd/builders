import expect.expect
import kotlinx.coroutines.delay
import test.asyncTest
import kotlin.test.Test

class TodoAsyncTest {
    @Test
    fun quick_suspending_test() = asyncTest {
        delay(1)
        expect(1 + 1).toBe(2)
    }
}