package nl.han.bewd.demospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemospringApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemospringApplication.class, args);
    }

    @GetMapping("/hello")
    // http://localhost:8080/hello?myName=superstudent
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}

