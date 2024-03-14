
package com.turing.api.product;

import com.turing.api.enums.ProductRoutor;

import java.util.Scanner;

public class ProductView {
    public static Boolean getProuctMain(Scanner sc) {
        return ProductRoutor.getArtiRouter(sc);
    }
    public static void proMain(Scanner sc) {

        while (getProuctMain(sc).equals(true)){}

    }
}