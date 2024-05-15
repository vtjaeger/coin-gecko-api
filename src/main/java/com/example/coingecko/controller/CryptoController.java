package com.example.coingecko.controller;

import com.example.coingecko.model.Crypto;
import com.example.coingecko.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cryptocurrencies")
public class CryptoController {
    @Autowired
    private CryptoService cryptoService;

    @GetMapping
    public Crypto[] getCryptocurrencies(@RequestParam(defaultValue = "usd") String vsCurrency) {
        return cryptoService.getCryptocurrencies(vsCurrency);
    }

    @GetMapping("/{id}")
    public Crypto getCryptoCurrencyById(@PathVariable String id, @RequestParam(defaultValue = "usd") String vsCurrency) {
        if ("bitcoin".equals(id)) {
            id = "bitcoin"; // Ajuste o id se necessário
        }
        return cryptoService.getCryptoById(id, vsCurrency);
    }
}
