package com.crypto.my.currencyupdate.config;

import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.impl.BinanceApiRestClientImpl;
import com.crypto.my.currencyupdate.provider.SettingsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BinanceRestConfig {

    private final SettingsProvider settingsProvider;

    @Bean
    public BinanceApiRestClient binanceApiRestClient() {
        return new BinanceApiRestClientImpl(settingsProvider.getApiKey(), settingsProvider.getSecretKey());
    }
}
