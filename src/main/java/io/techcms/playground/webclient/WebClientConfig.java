package io.techcms.playground.webclient;

import io.techcms.playground.config.AppConfig;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@AllArgsConstructor
public class WebClientConfig {

    private final AppConfig appConfig;

    @Bean
    public WebClient webClientProvide() {
        return WebClient
                .builder()
                .filter(ExchangeFilterFunctions
                        .basicAuthentication("admin", "password"))
                .baseUrl(appConfig.getMockServer().getBaseUrl())
                .build();
    }
}
