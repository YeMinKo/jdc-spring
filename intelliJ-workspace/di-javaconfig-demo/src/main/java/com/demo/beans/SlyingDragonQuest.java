package com.demo.beans;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component()
@Order(2)
public class SlyingDragonQuest implements Quest{

    @Override
    public String goQuest() {
        return "Knight killed the dragon";
    }
}
