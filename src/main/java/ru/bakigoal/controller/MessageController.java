package ru.bakigoal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.bakigoal.model.Message;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by ilmir on 15.03.16.
 */
@RestController
public class MessageController {

    private static final String DEFAULT_CONTENT = "Hello world!";
    private AtomicLong counter = new AtomicLong();

    @RequestMapping("/message")
    public Message getMessage(@RequestParam(value = "content", defaultValue = DEFAULT_CONTENT) String content) {
        return new Message(counter.incrementAndGet(), content);
    }
}
