package com.l3lab.web.controller;

import com.l3lab.Greeting;
import com.l3lab.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Summary:
 * User: zhenpeng
 * Date: 2017-08-16
 * Time: 19:18
 * <p>
 * Desc: {描述}
 */
@Controller
public class GreetingController {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }

}