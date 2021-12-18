package com.crypto.my.currencyupdate.service;

import com.crypto.my.currencyupdate.model.Code;
import com.crypto.my.currencyupdate.model.Price;

import java.math.BigInteger;
import java.time.LocalDateTime;

public interface PriceService {
    Price getLastPrice(Code code);
    void clear(LocalDateTime uoTo);
    Price save(Code code, BigInteger priceVal, LocalDateTime time);
}
