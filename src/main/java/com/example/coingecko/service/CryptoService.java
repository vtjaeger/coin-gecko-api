package com.example.coingecko.service;

import com.example.coingecko.model.Crypto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CryptoService {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_URL = "https://api.coingecko.com/api/v3/coins";

    public Crypto[] getCryptocurrencies(String vsCurrency) {
        String url = API_URL + "?vs_currency=" + vsCurrency;
        return restTemplate.getForObject(url, Crypto[].class);
    }

    public Crypto getCryptoById(String id, String vsCurrency) {
        String url = API_URL + "/" + id + "?vs_currency=" + vsCurrency;
        return restTemplate.getForObject(url, Crypto.class);
    }
}
