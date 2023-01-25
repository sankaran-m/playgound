package io.techcms.playground.timeout;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController("/timeout")
public class TimeOutController {

    @GetMapping()
    public Callable<String> getFoobar() throws InterruptedException {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(8000); //this will cause a timeout
                return "foobar";
            }
        };
    }
}
