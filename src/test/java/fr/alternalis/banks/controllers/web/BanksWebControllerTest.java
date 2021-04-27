package fr.alternalis.banks.controllers.web;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test made for the website endpoint.
 * This test is able to test the whole banks because it even call the services and appropriate repositories.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BanksWebControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testWebsite() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("username","Test");
        map.add("password","Test");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
        ResponseEntity<String> response;

        //We test a registration.
        response = this.restTemplate.exchange("http://localhost:" + port + "/complete",
                HttpMethod.POST, entity, String.class);
        assertTrue(response.getBody().contains("Registration successful"));
        //Two user can't have the same username.
        response = this.restTemplate.exchange("http://localhost:" + port + "/complete",
                HttpMethod.POST, entity, String.class);
        assertTrue(response.getBody().contains("Welcome on Banks !"));
        //We connect to the previously created account.
        response = this.restTemplate.exchange("http://localhost:" + port + "/myaccount",
                HttpMethod.POST, entity, String.class);
        //If the user is connected, we can know it because the name is printed on the page.
        assertTrue(response.getBody().contains("Test"));
    }
}