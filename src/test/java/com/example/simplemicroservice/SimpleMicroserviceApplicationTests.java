package com.example.simplemicroservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SimpleMicroserviceApplicationTests {

  @LocalServerPort
  private int port;

  TestRestTemplate restTemplate = new TestRestTemplate();

  HttpHeaders headers = new org.springframework.http.HttpHeaders();

  @Test
  public void testGetId_Fail() {
    var id = UUID.randomUUID().toString();
    HttpEntity<String> entity = new HttpEntity<String>(null, headers);
    var response = restTemplate.exchange("http://localhost:"+port+"/api/simple/"+id, HttpMethod.GET, entity, ReturnData.class);

    Assertions.assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
  }
}
