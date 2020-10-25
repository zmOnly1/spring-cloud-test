package com.example.springcloudtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zm on 2018/8/23.
 */
@RequestMapping("/rest")
@RestController
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test1")
    public String test1() {
        return restTemplate.getForObject("http://tomcat/v1/test1", String.class);
    }


}
