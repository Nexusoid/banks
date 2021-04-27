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
 * Unit test made for the REST XML endpoint.
 * This test is able to test the whole banks because it even call the services and appropriate repositories.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class BanksXmlRestControllerTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private WebTestClient webClient;

    @BeforeEach
    public void init(){
        userService.registerUser("Test","Test");
    }

    @Test
    void testMakeUserTransaction(){
        this.webClient.post().uri("/rest/xml/user/transaction").accept(MediaType.APPLICATION_XML).contentType(MediaType.APPLICATION_XML).body(BodyInserters.fromValue(transactionRequest))
                .exchange().expectStatus().isOk().expectBody().xpath("ResponseXml/information").isEqualTo("No user found");
        this.webClient.post().uri("/rest/xml/user/transaction").accept(MediaType.APPLICATION_XML).contentType(MediaType.APPLICATION_XML).body(BodyInserters.fromValue(existTransactionRequest))
                .exchange().expectStatus().isOk().expectBody().xpath("ResponseXml/information").isEqualTo("User correctly updated");
    }

    private static final String transactionRequest = "<TransactionRequestXml>\n" +
            "    <username>Tristan</username>\n" +
            "    <value>10</value>\n" +
            "</TransactionRequestXml>";

    private static final String existTransactionRequest = "<TransactionRequestXml>\n" +
            "    <username>Test</username>\n" +
            "    <value>10</value>\n" +
            "</TransactionRequestXml>";

}