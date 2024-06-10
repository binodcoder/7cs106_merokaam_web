package com.binodcoder.merokaam.config;
import com.binodcoder.merokaam.common.Coach;
import com.binodcoder.merokaam.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return  new SwimCoach();
    }
}
