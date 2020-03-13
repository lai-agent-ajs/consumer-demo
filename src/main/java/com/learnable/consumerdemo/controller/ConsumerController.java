package com.learnable.consumerdemo.controller;

import com.learnable.consumerdemo.remote.ProducerApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConsumerController {

    @Value("${consumer-age}")
    private String consumerAge;

    final ProducerApi producerApi;

    public ConsumerController(ProducerApi producerApi) {
        this.producerApi = producerApi;
    }

    @GetMapping("/testConsumer")
    public String testConsumer(String consumerName) {
        return producerApi.testProducer(consumerName, consumerAge);
    }
}
