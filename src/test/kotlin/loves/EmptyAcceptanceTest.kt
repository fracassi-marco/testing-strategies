package loves

import io.github.bonigarcia.wdm.WebDriverManager
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assumptions.assumeThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.openqa.selenium.By
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
        caricoLaPagina()
        inseriscoAutore("883")
        inseriscoTitoloCanzone("nella notte")
        cliccoCerca()
        verificoIlTestoDellaCanzone("tacchi a spillo")
    }

    private fun caricoLaPagina() {
        browser.get("http://localhost:$port/")
    }

    private fun inseriscoAutore(autore: String) {
        browser.findElement(By.id("txtAutore")).sendKeys(autore)
    }

    private fun inseriscoTitoloCanzone(titolo:   String) {
        browser.findElement(By.id("txtTitolo")).sendKeys(titolo)
    }

    private fun cliccoCerca() {
        browser.findElement(By.id("btnCerca")).click()
    }

    private fun verificoIlTestoDellaCanzone(testo: String) {
        assumeThat(browser.pageSource).containsIgnoringCase(testo)
    }


}