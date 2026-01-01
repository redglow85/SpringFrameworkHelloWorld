package com.helloworld.di;

import com.helloworld.di.order.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DiExampleApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = context.getBean(OrderService.class);
        int finalPrice = orderService.placeOrder("user-1", 10_000);

        System.out.println("[RESULT] finalPrice=" + finalPrice);
        context.close();
    }
}


