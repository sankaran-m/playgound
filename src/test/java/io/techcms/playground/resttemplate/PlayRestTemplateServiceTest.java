package io.techcms.playground.resttemplate;

import io.techcms.playground.config.AppConfig;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class PlayRestTemplateServiceTest {

    @Mock
    public AppConfig appConfig;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private HttpHeaders httpHeaders;

    private PlayRestTemplateService playRestTemplateService;

    @BeforeEach
    public void setup() {
        httpHeaders = new HttpHeaders() {{
            String auth = "admin:password";
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")));
            String authHeader = "Basic " + new String(encodedAuth);
            set("Authorization", authHeader);
        }};
        playRestTemplateService = new PlayRestTemplateService(appConfig, restTemplate, httpHeaders);
        AppConfig.MockServer mockServer = new AppConfig.MockServer();
        mockServer.setBaseUrl("http://localhost:8001");
        Mockito.when(appConfig.getMockServer()).thenReturn(mockServer);

        Mockito
                .when(restTemplate.getForEntity(mockServer.getBaseUrl() + "/", String.class))
                .thenReturn(new ResponseEntity<>("Hello!", HttpStatus.OK));
    }

    @Test
    public void getResponse() {

        Optional<String> response = playRestTemplateService.getResponse();

        assertEquals("Hello!", response.orElse(null));
    }
}