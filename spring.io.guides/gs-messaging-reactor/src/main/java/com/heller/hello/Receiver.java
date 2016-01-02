package com.heller.hello;

import com.heller.hello.vo.QuoteResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import reactor.bus.Event;
import reactor.fn.Consumer;

import java.util.concurrent.CountDownLatch;

public class Receiver implements Consumer<Event<Integer>> {

    @Autowired
    private CountDownLatch latch;

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public void accept(Event<Integer> ev) {
        QuoteResource quoteResource = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", QuoteResource.class);
        System.out.println("Quote " + ev.getData() + ": " + quoteResource.getValue().getQuote());
        latch.countDown();
    }
}
