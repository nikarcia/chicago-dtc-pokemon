package com.chicago.dtc.model;

import com.chicago.dtc.model.dto.ResponsePokemonRestApi;

import java.math.BigInteger;

public interface PokemonAPI {

     ResponsePokemonRestApi getPokemon(BigInteger offset , BigInteger limit);
}
