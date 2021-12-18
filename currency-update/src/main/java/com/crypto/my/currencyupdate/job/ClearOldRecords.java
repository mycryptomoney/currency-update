package com.crypto.my.currencyupdate.job;

import com.crypto.my.currencyupdate.service.PriceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
@EnableScheduling
public class ClearOldRecords {
    private final PriceService priceService;

    @Scheduled(fixedRate = 60000)
    private void clear24After() {
        //TODO sent last data to persistent database
        priceService.clear(LocalDateTime.now().minusHours(24));
    }
}
