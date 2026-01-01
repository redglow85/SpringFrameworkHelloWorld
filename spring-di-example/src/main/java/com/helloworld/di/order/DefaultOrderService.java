package com.helloworld.di.order;

import com.helloworld.di.discount.DiscountPolicy;

public class DefaultOrderService implements OrderService {
    private final DiscountPolicy discountPolicy;

    public DefaultOrderService(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
        System.out.println("[DI] DefaultOrderService created with discountPolicy=" + discountPolicy.getClass().getSimpleName());
    }

    @Override
    public int placeOrder(String userId, int price) {
        int discount = discountPolicy.discount(price);
        int finalPrice = price - discount;
        System.out.println("[ORDER] userId=" + userId + ", price=" + price + ", discount=" + discount + ", finalPrice=" + finalPrice);
        return finalPrice;
    }
}


