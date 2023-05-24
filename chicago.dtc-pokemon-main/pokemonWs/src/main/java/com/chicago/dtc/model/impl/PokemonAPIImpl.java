package com.chicago.dtc.model.impl;

import com.chicago.dtc.model.PokemonAPI;
import com.chicago.dtc.model.dto.ResponsePokemonRestApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Service
public class PokemonAPIImpl implements PokemonAPI {

    //singleton
    @Autowired
    RestTemplate restTemplate;

    public ResponsePokemonRestApi getPokemon(BigInteger offset , BigInteger limit) {
        Map<String, String> queryParams = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        queryParams.put("offset",  offset!=  null ? String.valueOf(offset) : "0");
        queryParams.put("limit", limit != null ? String.valueOf(limit) : "20");
        try {
            URI baseUri = new URI("https://pokeapi.co/api/v2/pokemon");
            URI finalUri = appendQueryParams(baseUri, queryParams);
            System.out.println("-> requestPokemonRestApi "  + finalUri );
            ResponseEntity<String> result = restTemplate.getForEntity(finalUri, String.class);
            System.out.println("<- responsePokemonRestApi " + result.getBody());
            ResponsePokemonRestApi responsePokemonRestApi = mapper.readValue(result.getBody(),ResponsePokemonRestApi.class);
           return responsePokemonRestApi;
            } catch (Exception e) {
            return null;
        }


    }

    public static URI appendQueryParams(URI uri, Map<String, String> queryParams) throws URISyntaxException {
        String query = "";
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            if (!query.isEmpty()) {
                query += "&";
            }
            query += entry.getKey() + "=" + entry.getValue();
        }
        return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), query, uri.getFragment());
    }

}
