package com.crypto.my.currencyupdate.service.impl;

import com.crypto.my.currencyupdate.model.Code;
import com.crypto.my.currencyupdate.model.Price;
import com.crypto.my.currencyupdate.repository.PriceRepository;
import com.crypto.my.currencyupdate.service.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {
    private final PriceRepository priceRepository;

    @Override
    public Price getLastPrice(Code code) {
        return priceRepository.findFirstByCodeOrderByTimeDesc(code).orElseThrow(() -> new IllegalArgumentException("No such a price"));
    }

    @Override
    public void clear(LocalDateTime uoTo) {
        List<Price> toDelete = priceRepository.findAllByTimeLessThan(uoTo);
        toDelete.forEach(priceRepository::delete);
    }

    @Override
    public Price save(Code code, BigInteger priceVal, LocalDateTime time) {
        Price price = Price.builder()
                .code(code)
                .time(time)
                .value(priceVal)
                .build();
        return priceRepository.save(price);
    }
}
