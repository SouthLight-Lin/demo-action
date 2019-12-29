package com.lnw.reactor;

import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author SouthLight-Lin on 2019/12/27
 */
public class TestFlatMap {

    public static void main(String[] args) throws InterruptedException {
        Flux.just("flux", "mono")
                .flatMap(s -> Flux.fromArray(s.split("\\s*"))
                        .delayElements(Duration.ofMillis(100)))
                .subscribe(System.out::println);
        Thread.sleep(1000);
    }
}
