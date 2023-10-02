package com.lotus.final1.Request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class QuantityUpdateRequest {
    private int quantity;
    private List<Integer> propertisid;
    public QuantityUpdateRequest(int quantity, List<Integer> propertisid) {
        this.quantity = quantity;
        this.propertisid = propertisid;
    }
}
