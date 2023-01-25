package io.techcms.playground.webclient;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PlayWebClientService {
    private final WebClient webClient;

    public Optional<String> getResponse() {
        return webClient.get()
                .uri("/")
                .retrieve()
                .bodyToMono(String.class)
                .blockOptional();
    }
}
