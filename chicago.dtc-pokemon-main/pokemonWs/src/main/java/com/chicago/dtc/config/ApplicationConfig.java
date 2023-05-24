package com.chicago.dtc.config;

import com.chicago.dtc.controller.PokemonWSPortImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;

@Configuration
public class ApplicationConfig {

  //singleton
  @Autowired
  private Bus bus;

  //singleton
  @Bean
  public Endpoint endpoint(PokemonWSPortImpl pokemonWSPort) {
    Endpoint endpoint = new EndpointImpl(bus, pokemonWSPort, SOAPBinding.SOAP12HTTP_BINDING);
    endpoint.publish("/soap/pokemonWS");
    return endpoint;
  }

  //singleton
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
