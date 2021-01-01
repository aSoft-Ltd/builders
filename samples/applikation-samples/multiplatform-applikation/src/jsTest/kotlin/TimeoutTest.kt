import kotlinx.coroutines.delay
import tz.co.asoft.asyncTest
import kotlin.test.Ignore
import kotlin.test.Test

class TimeoutTest {
    @Test
    @Ignore
    fun should_stay_for_at_least_ten_seconds() = asyncTest {
        console.log("Testing for a long time")
        delay(9500)
        console.log("Finished testing")
    }

    @Test
    @Ignore
    fun assert_it_due_to_timout() = asyncTest {
        console.log("Testing for a long time")
        delay(10500)
        console.log("Finished testing")
    }
}