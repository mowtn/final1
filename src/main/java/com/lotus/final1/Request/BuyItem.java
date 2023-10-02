package com.lotus.final1.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyItem {
    private int productid;
    private int productdetailid;
    private int quantity;
    public BuyItem(int productid, int productdetailid, int quantity) {
        this.productid = productid;
        this.productdetailid = productdetailid;
        this.quantity = quantity;
    }
}
