package io.techcms.playground.webclient;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/playwebclient")
@AllArgsConstructor
public class PlayWebClientController {

    private final PlayWebClientService playWebClientService;

    @GetMapping("/")
    public String index() {
        Optional<String> res = playWebClientService.getResponse();
        return res.orElse("No Response");
    }

}
