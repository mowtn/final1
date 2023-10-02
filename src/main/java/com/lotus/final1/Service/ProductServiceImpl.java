package com.lotus.final1.Service;

import com.lotus.final1.Model.ProductDetailPropertyDetails;
import com.lotus.final1.Model.ProductDetails;
import com.lotus.final1.Model.Products;
import com.lotus.final1.Model.PropertyDetails;
import com.lotus.final1.Repository.DbContext.DbContext;
import com.lotus.final1.Repository.ProductDetailPropertydetailRP;
import com.lotus.final1.Request.BuyItem;
import com.lotus.final1.Request.QuantityUpdateRequest;
import com.lotus.final1.Request.Request;
import com.lotus.final1.Response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    DbContext dbContext;

    @Override
    public Response<Products> buy(Request<List<BuyItem>> request) {
        String error = "";
        boolean flag = true;
        Optional<ProductDetails> productDetails = Optional.of(new ProductDetails());
        Optional<Products> products =  Optional.of(new Products());
        for (BuyItem buyItem : request.getData()) {
            productDetails = dbContext.productdetailRP.findById(buyItem.getProductdetailid());
            products = dbContext.productRP.findById(buyItem.getProductid());
            if (productDetails.get().getQuantity() == 0) {
                error+="Sản phẩm "+products.get().getProductName()+" hết hàng!";
                flag = false;
                break;
            }
            if (productDetails.get().getQuantity() < buyItem.getQuantity()){
                error+="Sản phẩm "+products.get().getProductName()+" không đủ hàng!";
                flag = false;
                break;
            }
        }
        if (flag){
            for (BuyItem buyItem: request.getData()){
                productDetails = dbContext.productdetailRP.findById(buyItem.getProductdetailid());
                int quantityUpdate = productDetails.get().getQuantity() - buyItem.getQuantity();
                productDetails.get().setQuantity(quantityUpdate);
                dbContext.productdetailRP.save(productDetails.get());
            }
        }
        return (flag) ? new Response<>("Mua hàng thành công!", 0, null):new Response<>(error, 1, null);
    }

    @Override
    public Response<Products> updateQuantity(int productid, List<QuantityUpdateRequest> updateRequestList) {
        try{
            for (QuantityUpdateRequest quantityUpdateRequest:updateRequestList){
                int count = quantityUpdateRequest.getPropertisid().size();
                int productDetailID = dbContext.productDetailPropertydetailRP.
                        GetProductDetailID(productid,quantityUpdateRequest.getPropertisid(),count);
                Optional<ProductDetails> productDetails = dbContext.productdetailRP.findById(productDetailID);
                int newQuantity =productDetails.get().getQuantity()+quantityUpdateRequest.getQuantity();
                productDetails.get().setQuantity(newQuantity);
                dbContext.productdetailRP.save(productDetails.get());
            }
            return new Response<>("Cập nhật thành công",0,null);
        }catch (Exception ex){
            return new Response<>("Cập Nhật Thất bại",1,null);
        }
    }

    @Override
    public Response<List<ProductDetails>> listProductDetail(int productid) {
            int propertyId = dbContext.propertyRp.getLastPropertyIdByProductID(productid);
            Optional<Products> product = dbContext.productRP.findById(productid);
            List<ProductDetails> productDetailsList = new ArrayList<>();
            List<PropertyDetails> detailsList = new ArrayList<>();
            for (PropertyDetails propertyDetails : dbContext.propertydetailRP.findAll()) {
                if (propertyDetails.getProperties().getPropertyID() == propertyId) {
                    detailsList.add(propertyDetails);
                }
            }
            for (ProductDetailPropertyDetails productDetailPropertyDetails : dbContext.productDetailPropertydetailRP.findAll()) {
                for (PropertyDetails propertyDetails : detailsList) {
                    if (productDetailPropertyDetails.getPropertyDetails() == propertyDetails
                            && productDetailPropertyDetails.getProducts() == product.get()) {
                        productDetailsList.add(productDetailPropertyDetails.getProductDetails());
                    }
                }
            }
            return new Response<List<ProductDetails>>(null, 0, productDetailsList);
    }
}
