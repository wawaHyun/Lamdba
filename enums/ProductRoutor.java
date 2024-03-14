package com.turing.api.enums;

import com.turing.api.article.ArticleController;
import com.turing.api.common.UtilService;
import com.turing.api.common.UtilServiceImpl;
import com.turing.api.product.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum ProductRoutor {
    EXIT("exit",i->{
        System.out.println("back menu.");
        return false;
    }),
    PRODUCT("product",i->{
        List<Product> prodList = new ArrayList<>();
        UtilService util = UtilServiceImpl.getInstance();
        for(int j=0;j<5;j++){
            prodList.add(Product.builder()
                    .productNum(util.createRandomInteger(1,10))
                    .productName(util.createRandomName())
                    .company(util.createRandomTitles())
                    .productPrice(util.createRandomInteger(3000,150000))
                    .build()
            );
        }
        prodList.forEach(j->System.out.println(j.toString()));
        return true;
    })
    ;

    private final String name;
    private final Predicate<Scanner> predi;

    ProductRoutor(String aaname, Predicate<Scanner> predi) {
        this.name = aaname;
        this.predi = predi;
    }

    public static Boolean getArtiRouter(Scanner sc) {
        String select = sc.next();
        System.out.println("'exit'back menu, product");
        return Stream.of(ProductRoutor.values())
                .filter(i->i.name.equals(select))
                .findAny().orElse(ProductRoutor.EXIT)
                .predi.test(sc);
    }

}
