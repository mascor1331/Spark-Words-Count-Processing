package com.rest.api;

import com.rest.api.model.response.WordCountResponse;
import org.springframework.web.client.RestTemplate;

public class SpringRestTestClient {

    public static final String REST_SERVICE_URI = "http://localhost:8080";


    /* GET */
    private static void wordsCount() {
        System.out.println("Testing wordsCount API----------");
        RestTemplate restTemplate = new RestTemplate();
        WordCountResponse wordCountResponse = restTemplate.getForObject(REST_SERVICE_URI + "/wordsCount/hello", WordCountResponse.class);
        System.out.println(wordCountResponse);
    }

    public static void main(String args[]) {
        wordsCount();
    }
}