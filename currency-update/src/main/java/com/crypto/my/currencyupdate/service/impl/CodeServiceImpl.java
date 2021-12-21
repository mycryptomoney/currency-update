package com.crypto.my.currencyupdate.service.impl;

import com.crypto.my.currencyupdate.model.Code;
import com.crypto.my.currencyupdate.repository.CodeRepository;
import com.crypto.my.currencyupdate.service.CodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService {

    private final CodeRepository codeRepository;

    @Override
    public Code save(String codeName) {
        Code code = new Code();
        code.setName(codeName);
        return codeRepository.save(code);
    }

    @Override
    public Code get(String codeName) {
        return codeRepository.getByName(codeName).orElseGet(() -> save(codeName));
    }
}
