package com.lukaszszszsz.designpatterns;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class ReactorIntroductionBase {

    public Mono<String> helloWorldService() {
        return Mono.just("Hello World!");
    }

    public Flux<String> multiResultService() {
        return Flux.just("valid result").concatWith(Flux.error(new RuntimeException("oops, you collected to many, and you broke the service...")));
    }

    public Mono<String> unresponsiveService() {
        return Mono.never();
    }
    protected AtomicReference<Boolean> emptyServiceIsCalled = new AtomicReference<>(false);

    public Mono<String> emptyService() {
        return Mono.defer(()-> {
            emptyServiceIsCalled.set(true);
            return Mono.empty();
        });
    }




}
