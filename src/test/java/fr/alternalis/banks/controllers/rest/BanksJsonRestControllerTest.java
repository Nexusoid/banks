package fr.alternalis.banks.controllers.rest;

import fr.alternalis.banks.iservices.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;


/**
 * Unit test made for the REST JSON endpoint.
 * This test is able to test the whole banks because it even call the services and appropriate repositories.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class BanksJsonRestControllerTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private WebTestClient webClient;

    @BeforeEach
    public void init(){
        userService.registerUser("Test","Test");
    }

    @Test
    void testGetUserAmount() {
        this.webClient.post().uri("/rest/json/user/balance").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(balanceRequest))
                .exchange().expectStatus().isNotFound().expectBody().jsonPath("error").isEqualTo("No user found");
        this.webClient.post().uri("/rest/json/user/balance").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(existBalanceRequest))
                .exchange().expectStatus().isOk().expectBody().jsonPath("balance").isEqualTo("50.0");
    }

    @Test
    void testGetUserOperations() {
        this.webClient.post().uri("/rest/json/user/operations").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(operationsRequest))
                .exchange().expectStatus().isNotFound().expectBody().jsonPath("error").isEqualTo("No user found");
        this.webClient.post().uri("/rest/json/user/operations").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(existOperationsRequest))
                .exchange().expectStatus().isOk().expectBody().jsonPath("error").isEqualTo("No operation found");
    }

    private static final String balanceRequest = "{\n" +
            "    \"username\":\"Tristan\"\n" +
            "}";

    private static final String existBalanceRequest = "{\n" +
            "    \"username\":\"Test\"\n" +
            "}";

    private static final String operationsRequest = "{\n" +
            "    \"username\":\"Tristan\",\n" +
            "    \"number\":\"5\"\n" +
            "}";

    private static final String existOperationsRequest = "{\n" +
            "    \"username\":\"Test\",\n" +
            "    \"number\":\"5\"\n" +
            "}";
}