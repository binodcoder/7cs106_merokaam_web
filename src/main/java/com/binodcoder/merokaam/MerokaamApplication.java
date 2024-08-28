package com.binodcoder.merokaam;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MerokaamApplication {
    public static void main(String[] args) {
        SpringApplication.run(MerokaamApplication.class, args);
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public Object checkNull(Object obj) {
        if (obj != null) {
            return obj;
        }
        return null;
    }
}
