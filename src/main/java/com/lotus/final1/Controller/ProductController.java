package com.lotus.final1.Controller;

import com.lotus.final1.Model.ProductDetails;
import com.lotus.final1.Model.Products;
import com.lotus.final1.Request.BuyItem;
import com.lotus.final1.Request.QuantityUpdateRequest;
import com.lotus.final1.Request.Request;
import com.lotus.final1.Response.Response;
import com.lotus.final1.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("buy")
    public Response<Products> buy(@RequestBody Request<List<BuyItem>> request){
        return productService.buy(request);
    }

    @PostMapping("updateQuantity")
    public Response<Products> updateQuantity(@RequestParam(name = "productid")int productid,
                                             @RequestBody List<QuantityUpdateRequest> updateRequestList)
    {
        return productService.updateQuantity(productid,updateRequestList);
    }
    @GetMapping("listProductDetail")
    public Response<List<ProductDetails>> listProductDetail(@RequestParam("productid")int productid){
        return productService.listProductDetail(productid);
    }
}
