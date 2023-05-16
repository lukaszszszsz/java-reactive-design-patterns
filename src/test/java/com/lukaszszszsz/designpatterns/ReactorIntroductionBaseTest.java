package com.lukaszszszsz.designpatterns;


import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.time.Duration;

class ReactorIntroductionBaseTest extends ReactorIntroductionBase  {


    @Test
    void helloWorldServiceTest() {

        StepVerifier.create(helloWorldService()).expectNext("Hello World!").expectComplete().verify();

    }

    @Test
    void multiResultServiceTest() {

        String expectedErrorMessage = "oops, you collected to many, and you broke the service...";

        StepVerifier.create(multiResultService()).expectNext("valid result").expectErrorMatches(error -> expectedErrorMessage.equals(error.getMessage())).verify();


    }

    @Test
    void unresponsiveServiceTest() {

        StepVerifier.create(unresponsiveService()).expectSubscription().expectNoEvent(Duration.ofSeconds(10)).thenCancel().verify();

    }

    @Test
    void emptyServiceTest() {

        StepVerifier.create(emptyService()).expectComplete().verify();

    }
}