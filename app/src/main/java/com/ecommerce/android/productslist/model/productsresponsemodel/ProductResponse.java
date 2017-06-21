package com.ecommerce.android.productslist.model.productsresponsemodel;

import com.ecommerce.android.productslist.model.productsresponsemodel.Product;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by GP00471911 on 03-02-2017.
 */

public class ProductResponse {
    @SerializedName("products")
    private List<Product> products = null;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
