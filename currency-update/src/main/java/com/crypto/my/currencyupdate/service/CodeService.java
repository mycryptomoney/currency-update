package com.crypto.my.currencyupdate.service;

import com.crypto.my.currencyupdate.model.Code;

public interface CodeService {
    Code save(String codeName);
    Code get(String codeName);
}
