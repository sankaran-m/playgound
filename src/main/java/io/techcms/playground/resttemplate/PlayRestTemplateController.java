package io.techcms.playground.resttemplate;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/playresttemplate")
@AllArgsConstructor
public class PlayRestTemplateController {

    private final PlayRestTemplateService playRestTemplateService;

    @GetMapping("/")
    public String index() {
        Optional<String> res = playRestTemplateService.getResponse();
        return res.orElse("No Response");
    }
}
