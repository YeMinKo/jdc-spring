package com.demo.bls;

import org.springframework.stereotype.Component;

@Component
public class CurrenciesRepositoryImpl implements CurrenciesRepository {

    @Override
    public int getCurrenciesCount() {
        return 0;
    }

    @Override
    public void greet() {
        System.out.println("Hello!");
    }
}
