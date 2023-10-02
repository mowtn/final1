package com.lotus.final1.Service;

import com.lotus.final1.Model.ProductDetails;
import com.lotus.final1.Model.Products;
import com.lotus.final1.Request.BuyItem;
import com.lotus.final1.Request.QuantityUpdateRequest;
import com.lotus.final1.Request.Request;
import com.lotus.final1.Response.Response;

import java.util.List;

public interface ProductService {
    Response<Products> buy(Request<List<BuyItem>> request);

    Response<Products> updateQuantity(int productid, List<QuantityUpdateRequest> updateRequestList);

    Response<List<ProductDetails>> listProductDetail(int productid);
}
