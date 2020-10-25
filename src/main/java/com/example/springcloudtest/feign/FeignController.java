package com.example.springcloudtest.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by zm on 2020/10/25.
 */
@RestController
public class FeignController {

    @Autowired
    private FeignClient1 feignClient1;

    @GetMapping("/feign1")
    public String feign1() {
        System.out.println("feign1");
        return feignClient1.test1();
    }

    @GetMapping("/feign2")
    public String feign2() {
        System.out.println("feign2");
        Student student = new Student("DS", 18);
        Map<String, String> headers = new HashMap<>();
        headers.put("header1", "value1");
        headers.put("header2", "value2");
        return feignClient1.post1(headers, student);
    }

    @GetMapping("/feign3")
    public String feign3() {
        System.out.println("feign3");
        Student student = new Student("DS", 18);
        Map<String, String> headers = new HashMap<>();
        headers.put("header1", "value1");
        headers.put("header2", "value2");
        ResponseEntity<String> responseEntity = feignClient1.post2(headers, student);
        String body = responseEntity.getBody();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        System.out.printf("%s ,%s", body, statusCodeValue);
        System.out.println();
        return "feign3";
    }

}
