package com.example.servertest1;

    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import javax.servlet.http.HttpServletRequest;
    import javax.validation.Valid;
    import java.util.*;

/**
 * Created by zm on 2018/8/24.
 */
@RestController
@RequestMapping(value = "/v1")
public class ServerTest1Controller {

    @GetMapping("/test1")
    public String hell() {
        System.out.println("test1");
        return "test1";
    }

    @GetMapping("/server1")
    public String server1() {
        System.out.println("server1");
        return "server1";
    }

    @PostMapping("/post1")
    public String post1(HttpServletRequest request, @RequestBody @Valid Student student) {
        System.out.println("-------------header---------------");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            System.out.printf("%s: %s \n", name, value);
        }
        System.out.println("-------------header---------------");
        System.out.printf("student: %s.\n", student);
        return "post1";
    }

    @PostMapping("/post2")
    public ResponseEntity<String> post2(HttpServletRequest request, @RequestBody @Valid Student student) {
        System.out.println("-------------header---------------");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            System.out.printf("%s: %s \n", name, value);
        }
        System.out.println("-------------header---------------");
        System.out.printf("student: %s.\n", student);

        return new ResponseEntity<String>("success", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
