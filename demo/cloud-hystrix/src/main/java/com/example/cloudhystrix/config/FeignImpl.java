package com.example.cloudhystrix.config;

import org.springframework.stereotype.Component;

@Component
public class FeignImpl implements FeignConfig {
    @Override
    public String say() {
        return "hello say error";
    }
}
