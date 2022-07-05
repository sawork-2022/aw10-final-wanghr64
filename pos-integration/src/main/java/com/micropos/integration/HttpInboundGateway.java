package com.micropos.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.dsl.Http;
import org.springframework.stereotype.Component;

@Component
public class HttpInboundGateway {

    @Bean
    public IntegrationFlow inGate() {
        return IntegrationFlows.from(Http.inboundGateway("/delivery"))
                .headerFilter("accept-encoding", false)
                .channel("deliveryChannel")
                .get();
    }
}