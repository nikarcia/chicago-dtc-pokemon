package com.chicago.dtc.controller;

import com.chicago.dtc.controller.wsdl.PokemonWSPort;
import com.chicago.dtc.model.schema.GetPokemonRequest;
import com.chicago.dtc.model.schema.GetPokemonResponse;
import com.chicago.dtc.service.PokemonService;
import com.chicago.dtc.security.WSSecurityInterceptor;
import org.apache.cxf.annotations.SchemaValidation;
import org.apache.cxf.annotations.SchemaValidation.SchemaValidationType;
import org.apache.cxf.interceptor.InInterceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SchemaValidation(type = SchemaValidationType.REQUEST)
@InInterceptors(classes = WSSecurityInterceptor.class)
public class PokemonWSPortImpl implements PokemonWSPort {

//singleton
  @Autowired
  PokemonService service;

  @Override
  public GetPokemonResponse getPokemon(GetPokemonRequest parameters) {
    return service.getPokemon(parameters);
  }
}