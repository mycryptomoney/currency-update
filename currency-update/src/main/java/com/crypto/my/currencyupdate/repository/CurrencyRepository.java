package com.crypto.my.currencyupdate.repository;

import com.crypto.my.currencyupdate.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Optional<Currency> getByAbbreviation(String name);
}
