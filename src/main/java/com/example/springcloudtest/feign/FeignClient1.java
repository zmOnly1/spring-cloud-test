package com.example.springcloudtest.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.*;

/**
 * Created by zm on 2020/10/25.
 */
@FeignClient(name = "tomcat", path = "/v1")
public interface FeignClient1 {

    @GetMapping("/test1")
    String test1();

    @PostMapping("/post1")
    String post1(@RequestHeader Map<String, String> headers, @RequestBody Student student);

    @PostMapping("/post2")
    ResponseEntity<String> post2(@RequestHeader Map<String, String> headers, @RequestBody Student student);

}
