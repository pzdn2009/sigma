package com.l3lab;

import com.l3lab.service.SpeechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BwSpeechApplication {

    @Autowired
    SpeechService speechService;

    public static void main(String[] args) {
        SpringApplication.run(BwSpeechApplication.class, args);
    }

    @RequestMapping("/reco")
    public String hello(@RequestParam String filename, @RequestParam Integer rate) {
        return speechService.recognize(filename, rate);
    }
}
