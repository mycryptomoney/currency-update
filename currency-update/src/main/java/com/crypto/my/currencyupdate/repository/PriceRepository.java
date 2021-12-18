package com.crypto.my.currencyupdate.repository;

import com.crypto.my.currencyupdate.model.Code;
import com.crypto.my.currencyupdate.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findAllByTimeLessThan(LocalDateTime time);

    Optional<Price> findFirstByCodeOrderByTimeDesc(Code code);
}
