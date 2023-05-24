package com.chicago.dtc.model.impl;

import com.chicago.dtc.model.PokemonAPI;
import com.chicago.dtc.model.dto.Pokemon;
import com.chicago.dtc.model.dto.ResponsePokemonRestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//La clase PokemonAPIProxy actúa como un intermediario entre el cliente
// y la API RESTful. Esta clase implementa la interfaz PokemonAPI
// y contiene una instancia de la implementación concreta PokemonAPIImpl.
// En el método getPokemons, el proxy verifica si los datos solicitados
// ya están en caché. Si es así, los recupera de la caché y los devuelve.
// Si los datos no están en caché, el proxy llama a la implementación concreta
// para obtener los datos de la API RESTful, los guarda en caché y luego los devuelve.
@Service
@Primary
public class PokemonAPIProxy  implements PokemonAPI {

    @Autowired
    private PokemonAPI pokemonAPI;
    private Map<String, ResponsePokemonRestApi> cache;

    @Autowired
    PokemonAPIImpl restTemplate;

    public PokemonAPIProxy() {
        this.cache = new HashMap<>();
    }

    @Override
    public ResponsePokemonRestApi getPokemon(BigInteger offset, BigInteger limit) {
        System.out.println("using proxy pattern");

        if ( offset==null || offset.intValue()<0){
            offset= BigInteger.valueOf(0);
        }
        if ( limit==null || limit.intValue()<0){
            limit= BigInteger.valueOf(10);
        }

        String key = offset + "-" + limit;

        // Comprobar si los datos están en caché
        if (cache.containsKey(key)) {
            System.out.println("getting  cache data...");
            return cache.get(key);
        }

        // Si los datos no están en caché, llamar a la API RESTful
        ResponsePokemonRestApi pokemons = pokemonAPI.getPokemon(offset, limit);
        // Guardar los datos en caché
        cache.put(key, pokemons);
        return pokemons;
    }



}
