package com.chicago.dtc.service.impl;

import com.chicago.dtc.model.dto.ResponsePokemonRestApi;
import com.chicago.dtc.model.PokemonAPI;
import com.chicago.dtc.model.schema.GetPokemonRequest;
import com.chicago.dtc.model.schema.GetPokemonResponse;
import com.chicago.dtc.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonServiceImpl implements PokemonService {

    // utilizar el patrón de diseño Singleton para gestionar la instancia de la clase que realiza las llamadas al API RESTful. Esto asegura que solo exista una instancia de la clase y evita la creación de múltiples instancias innecesarias.
    @Autowired
    PokemonAPI apiData;

    public GetPokemonResponse getPokemon(GetPokemonRequest request) {
        GetPokemonResponse response = new GetPokemonResponse();
        ResponsePokemonRestApi responsePokemonRestApi = apiData.getPokemon(request.getOffset(),request.getLimit());
        responsePokemonRestApi.getResults().forEach(x->{
            GetPokemonResponse.Pokemon pokemon = new GetPokemonResponse.Pokemon();
            pokemon.setName(x.getName());
            pokemon.setUrl(x.getUrl());
            response.getPokemon().add(pokemon);
        });
        return response ;
    }


}
