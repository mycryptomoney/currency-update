package com.crypto.my.currencyupdate.repository;

import com.crypto.my.currencyupdate.model.Code;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CodeRepository extends JpaRepository<Code, Long> {
    Optional<Code> getByName(String name);
}
