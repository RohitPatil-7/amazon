package com.bitsnbytes.productlist;

import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    MyComponent() {

        System.out.println("Result from MyComponent");

    }

    public void getMessage() {
        System.out.println("Result from getmessage");
    }
}
