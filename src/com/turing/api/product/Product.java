
package com.turing.api.product;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"productNum"})
public class Product {
    private int productNum;
    private String productName;
    private String company;
    private int productPrice;
    @Builder(builderClassName = "builer")
    public Product(int productNum, String productName, String company, int productPrice) {
        this.productNum = productNum;
        this.productName = productName;
        this.company = company;
        this.productPrice = productPrice;
    }
}