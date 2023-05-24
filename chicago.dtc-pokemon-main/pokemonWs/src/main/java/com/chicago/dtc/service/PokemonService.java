package com.chicago.dtc.service;

import com.chicago.dtc.model.schema.GetPokemonRequest;
import com.chicago.dtc.model.schema.GetPokemonResponse;
import org.springframework.stereotype.Service;

public interface PokemonService {

     GetPokemonResponse getPokemon(GetPokemonRequest request);

    }
