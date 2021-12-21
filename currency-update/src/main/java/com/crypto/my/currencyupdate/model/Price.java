package com.crypto.my.currencyupdate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@IdClass(PriceId.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "price")
@Data
public class Price {
    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "code_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "code_key"))
    private Code code;

    @Id
    private LocalDateTime time;

    private BigInteger value;
}
