package com.bitsnbytes.productlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class MyAppConfi {

    @Bean
    public MyComponent myComponent(){
        return  new MyComponent();
    }

    @Component
    public static class MyApp {
        //1.by using autowired we can access the all beans from that class but for our understanding we are using
        @Autowired
        private MyComponent myComponent;

    // 2.This type using constructore we are using it
    //    public MyApp(MyComponent myComponent) {
    //        this.myComponent = myComponent;
    //    }

        public void run() {
            myComponent.getMessage();
        }
    }
}
