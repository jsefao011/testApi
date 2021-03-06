package presentacion.restapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Jse on 12/05/2018.
 */
@Controller
public class HelloWorldRestApi {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello-world")
    @ResponseBody
    public String sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return counter.incrementAndGet()+ "-" + String.format(template, name);
    }
}
