package com.crypto.my.currencyupdate.job;

import com.crypto.my.currencyupdate.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@EnableScheduling
public class UpdateCurrencyJob {

    private final CurrencyService currencyService;

    @Scheduled(fixedRate = 1000)
    private void updateCurrency() {
        currencyService.updateCurrencies();
    }
}
