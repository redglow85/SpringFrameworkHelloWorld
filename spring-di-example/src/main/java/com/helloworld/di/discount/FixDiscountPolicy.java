package com.helloworld.di.discount;

public class FixDiscountPolicy implements DiscountPolicy {
    private final int amount;

    public FixDiscountPolicy(int amount) {
        this.amount = amount;
    }

    @Override
    public int discount(int price) {
        return Math.min(amount, price);
    }
}


