package com.NseDataFeed.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Getter
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OptionChain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String symbol;
    @Column(name = "expiry_date")
    private LocalDate expiryDate;
    @Column(name = "strike_price")
    private Double strikePrice;
    private Double openInterest;
    private Double changeInOpenInterest;
    private Double impliedVolatility;
}
