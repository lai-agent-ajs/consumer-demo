package com.learnable.consumerdemo.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="producer-demo")
public interface ProducerApi {

    @GetMapping("/testProducer")
    String testProducer(@RequestParam("consumerName") String consumerName,
                        @RequestParam("consumerAge") String consumerAge);
}
