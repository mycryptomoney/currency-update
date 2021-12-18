package com.crypto.my.currencyupdate.job;

import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.market.TickerPrice;
import com.crypto.my.currencyupdate.model.Code;
import com.crypto.my.currencyupdate.provider.SettingsProvider;
import com.crypto.my.currencyupdate.service.CodeService;
import com.crypto.my.currencyupdate.service.PriceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
@EnableScheduling
public class BinanceFetcherJob {

    private final CodeService codeService;
    private final PriceService priceService;
    private final BinanceApiRestClient binanceApiRestClient;
    private final SettingsProvider settingsProvider;

    @Scheduled(fixedRate = 15000)
    private void call() {
        List<TickerPrice> tickerPrices = binanceApiRestClient.getAllPrices();
        BigDecimal multiply = settingsProvider.getMultiply();
        tickerPrices.forEach(tickerPrice -> {
            String codeName = null;
            BigDecimal price = BigDecimal.ZERO;
            try {
                codeName = tickerPrice.getSymbol();
                if (codeName.endsWith("USDT")) {
                    Code code = codeService.get(codeName.substring(0, codeName.length()-4));
                    price = new BigDecimal(tickerPrice.getPrice());
                    priceService.save(code, price.multiply(multiply).toBigInteger(), LocalDateTime.now());
                }
            } catch (Exception e) {
                log.error("Code: {}, Price: {}, Exception: {}", codeName, price, e.getMessage());
            }
        });
    }
}
