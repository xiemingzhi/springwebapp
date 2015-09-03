package com.mycompany;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FacebookLookupService {

    RestTemplate restTemplate = new RestTemplate();

    @Async
    public Future<Page> findPage(String page) throws InterruptedException {
        System.out.println("Looking up " + page);
        //Page results = restTemplate.getForObject("https://graph.facebook.com/" + page + "?access_token=CAACEdEose0cBAIW3amrU1r2PoBpMbF5fSxJiQJJFcFmrA87XziUPI15ANtUvJZBv01RZAs7FcZBHRSlZCCZBLzkst6BMwIRglyJxTw8DBoZANl0ibKuLj6jFvdeKyHcT35NSD48fi9lUlgO14B5wsC2sQ13NxL9zZAm0IrFHXeHWfNWviYNazZC7vaDhRYcAkCIZD", Page.class);
        //Page results = restTemplate.getForObject("https://graph.facebook.com/" + page + "?access_token=CAACEdEose0cBABHdUu6USsDUX5zYFZClPULfeqqTkNTwJctZCetaY2HLX0sPmZBsJ95qnp9TmAZCBGkZCsq8UbiVrlt5gvul1apGALCzogVB1s0eHa5Q0DoIA2E4N8ZCiBhWpy8Hccb2j8ZA7fenMJOa37tDivQmZAIMXvwSNUuHjTKgylrZBUjRKc4ROHqDeOaUNMYNNe6bzyAZDZD", Page.class);
        Page results = restTemplate.getForObject("https://graph.facebook.com/" + page + "?access_token=CAACEdEose0cBAKFWGSZAqazjutv0SPnAkvm4nZApIiQOdGiP5DP203PJQDIXvbik3rosGv2nWOdXBssb0V0pwMuwcbsZCL0aLb8T6OfYmcrP7PoCPGosZAvylqZAPMggQhexqT4laeyt7GWZBGzwbqqiUPy9r4ZCfiZBn3O2txxd4ZCM6FH0NuSkOC200WYRpFD8d8plMpo2XAgZDZD", Page.class);
        Thread.sleep(1000L);
        return new AsyncResult<Page>(results);
    }

}