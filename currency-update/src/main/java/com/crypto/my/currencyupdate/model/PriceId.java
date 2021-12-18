package com.crypto.my.currencyupdate.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Data
public class PriceId implements Serializable {

    private Long code;

    private LocalDateTime time;

}
