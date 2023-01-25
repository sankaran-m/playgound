package io.techcms.playground.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "io.techcms.playground")
public class AppConfig {
    private String name;
    private MockServer mockServer;

    @Data
    public static class MockServer {
        private String baseUrl;
    }
}
