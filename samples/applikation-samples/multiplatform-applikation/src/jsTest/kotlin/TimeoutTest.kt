import kotlinx.coroutines.delay
import tz.co.asoft.asyncTest
import kotlin.test.Test

class TimeoutTest {
    @Test
    fun should_stay_for_at_least_ten_seconds() = asyncTest {
        console.log("Testing for a long time")
        delay(9500)
        console.log("Finished testing")
    }

    @Test
    fun assert_it_due_to_timout() = asyncTest {
        console.log("Testing for a long time")
        delay(10500)
        console.log("Finished testing")
    }
}