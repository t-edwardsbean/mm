package com.xpspeed.mm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author edwardsbean
 * @date 15-6-11
 */
@EnableSwagger2
@SpringBootApplication
public class MarketMain extends WebMvcConfigurerAdapter {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MarketMain.class, args);
    }

}
