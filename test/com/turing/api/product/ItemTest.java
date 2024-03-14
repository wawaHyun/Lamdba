package com.turing.api.product;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @org.junit.jupiter.api.Test
    void systemOut() {
        Item s = new Item();
        String s3 = s.systemOut();
        String s2 = "Hello";
        System.out.println("-->"+s3);
        Assertions.assertEquals(s.systemOut(),"hello");
    }

    @org.junit.jupiter.api.Test
    void add() {
        Item s =new Item();
//        int as = s.add(1,2);
        System.out.println("add test -->"+s.add(1,2));

        Assertions.assertEquals(s.add(1,2),3);

    }
}