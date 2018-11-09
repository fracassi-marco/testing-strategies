package loves

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomePageController {

    @GetMapping("/")
    @ResponseBody
    fun home() : String {
        return ""
    }
}