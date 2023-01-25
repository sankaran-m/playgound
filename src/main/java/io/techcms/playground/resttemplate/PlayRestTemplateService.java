package io.techcms.playground.resttemplate;

import io.techcms.playground.config.AppConfig;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@AllArgsConstructor
@Service
public class PlayRestTemplateService {

    public final AppConfig appConfig;
    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;

    public Optional<String> getResponse() {
        ResponseEntity<String> response
                = restTemplate.getForEntity(appConfig.getMockServer().getBaseUrl() + "/", String.class, new HttpEntity<>(httpHeaders));
        return response != null && response.hasBody() ? Optional.ofNullable(response.getBody()) : Optional.empty();
    }
}
