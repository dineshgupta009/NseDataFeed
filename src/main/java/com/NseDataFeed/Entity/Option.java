package com.NseDataFeed.Entity;

import jakarta.persistence.Entity;


public class Option {

    private String strikePrice;
    private String openInterest;
    private String changeInOpenInterest;
    private String impliedVolatility;

    public String getStrikePrice() {
        return strikePrice;
    }

    public void setStrikePrice(String strikePrice) {
        this.strikePrice = strikePrice;
    }

    public String getOpenInterest() {
        return openInterest;
    }

    public void setOpenInterest(String openInterest) {
        this.openInterest = openInterest;
    }

    public String getChangeInOpenInterest() {
        return changeInOpenInterest;
    }

    public void setChangeInOpenInterest(String changeInOpenInterest) {
        this.changeInOpenInterest = changeInOpenInterest;
    }

    public String getImpliedVolatility() {
        return impliedVolatility;
    }

    public void setImpliedVolatility(String impliedVolatility) {
        this.impliedVolatility = impliedVolatility;
    }
}
