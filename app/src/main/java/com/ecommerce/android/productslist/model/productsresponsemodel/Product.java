package com.ecommerce.android.productslist.model.productsresponsemodel;

/**
 * Created by GP00471911 on 03-02-2017.
 */

import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("product_id")
    private String productId;
    @SerializedName("product_category")
    private String productCategory;
    @SerializedName("product_code")
    private String productCode;
    @SerializedName("title")
    private String title;
    @SerializedName("color")
    private String color;
    @SerializedName("size")
    private String size;
    @SerializedName("thumb_image_url")
    private String thumbImageUrl;
    @SerializedName("isDiscountAvailable")
    private Boolean isDiscountAvailable;
    @SerializedName("discount_in_percent")
    private Integer discountInPercent;
    @SerializedName("product_amount")
    private Integer productAmount;
    @SerializedName("product_amount_after_discount")
    private Integer productAmountAfterDiscount;
    @SerializedName("product_type")
    private String productType;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getThumbImageUrl() {
        return thumbImageUrl;
    }

    public void setThumbImageUrl(String thumbImageUrl) {
        this.thumbImageUrl = thumbImageUrl;
    }

    public Boolean isDiscountAvailable() {
        return isDiscountAvailable;
    }

    public void setIsDiscountAvailable(Boolean isDiscountAvailable) {
        this.isDiscountAvailable = isDiscountAvailable;
    }

    public Integer getDiscountInPercent() {
        return discountInPercent;
    }

    public void setDiscountInPercent(Integer discountInPercent) {
        this.discountInPercent = discountInPercent;
    }

    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }

    public Integer getProductAmountAfterDiscount() {
        return productAmountAfterDiscount;
    }

    public void setProductAmountAfterDiscount(Integer productAmountAfterDiscount) {
        this.productAmountAfterDiscount = productAmountAfterDiscount;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

}