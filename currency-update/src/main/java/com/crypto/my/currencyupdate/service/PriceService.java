package com.crypto.my.currencyupdate.service;

import com.crypto.my.currencyupdate.model.Code;
import com.crypto.my.currencyupdate.model.Price;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceService {
    Optional<Price> getLastPrice(String name);
    Price getLastPrice(Code code);
    void clear(LocalDateTime uoTo);
    Price save(Code code, BigInteger priceVal, LocalDateTime time);
}
