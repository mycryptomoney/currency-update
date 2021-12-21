package com.crypto.my.currencyupdate.service.impl;

import com.crypto.my.currencyupdate.model.Currency;
import com.crypto.my.currencyupdate.model.Price;
import com.crypto.my.currencyupdate.repository.CurrencyRepository;
import com.crypto.my.currencyupdate.service.CurrencyService;
import com.crypto.my.currencyupdate.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.crypto.my.currencyupdate.provider.SettingsProvider;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    private final PriceService priceService;

    private final SettingsProvider settingsProvider;

    @Override
    public void updateCurrencies() {
        List<Currency> currencies = currencyRepository.findAll();
        currencies.parallelStream().forEach(this::setPriceAndTime);
    }

    private void setPriceAndTime(Currency currency) {
        Optional<Price> expectedPrice = priceService.getLastPrice(currency.getAbbreviation());
        if (expectedPrice.isPresent()) {
            Price price = expectedPrice.get();
            currency.setValue(new BigDecimal(price.getValue()).divide(settingsProvider.getMultiply()));
            currency.setTime(price.getTime());
            currencyRepository.save(currency);
        }
    }
}
