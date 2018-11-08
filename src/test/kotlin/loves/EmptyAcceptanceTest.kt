package loves

import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmptyAcceptanceTest {

    @LocalServerPort
    private var port: Int = 0
    private lateinit var browser: PhantomJSDriver

    @Before
    fun before() {
        WebDriverManager.phantomjs().setup();
        browser = PhantomJSDriver();
    }

    @After
    fun after() {
        browser.close()
    }

    @Test
    fun shouldFindALyrics() {
        browser.get("http://localhost:$port/")
    }
}