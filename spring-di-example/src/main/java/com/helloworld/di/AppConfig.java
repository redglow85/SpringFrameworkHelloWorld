package com.helloworld.di;

import com.helloworld.di.discount.DiscountPolicy;
import com.helloworld.di.discount.FixDiscountPolicy;
import com.helloworld.di.order.DefaultOrderService;
import com.helloworld.di.order.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy(1_000);
    }

    @Bean
    public OrderService orderService(DiscountPolicy discountPolicy) {
        return new DefaultOrderService(discountPolicy);
    }
}


