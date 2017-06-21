package com.ecommerce.android.productslist;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ecommerce.android.R;
import com.ecommerce.android.productslist.model.productsresponsemodel.Product;

import java.util.List;

import com.ecommerce.android.util.Helper;

/**
 * Created by GP00471911 on 03-02-2017.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductsViewHolder> {


    private final Context mContext;
    private final List<Product> mList;

    public ProductListAdapter(Context context, List<Product> productList) {
        this.mContext = context;
        this.mList = productList;
    }


    @Override
    public ProductsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_product_list_item_row, parent, false);

        return new ProductsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductsViewHolder holder, int position) {
        Product product = mList.get(position);
        holder.productName.setText(product.getTitle());
        holder.productAmount.setText(mContext.getResources().getString(R.string.rupees) + "" + product.getProductAmount());
        if (product.isDiscountAvailable()) {
            holder.productDiscountAmount.setVisibility(View.VISIBLE);
            holder.productDiscountPercent.setVisibility(View.VISIBLE);
            holder.productDiscountAmount.setText(mContext.getResources().getString(R.string.rupees) + "" + product.getProductAmountAfterDiscount());
            holder.productAmount.setPaintFlags(holder.productDiscountAmount.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.productDiscountPercent.setText(product.getDiscountInPercent() + "%");
        } else {
            holder.productDiscountAmount.setVisibility(View.GONE);
            holder.productDiscountPercent.setVisibility(View.GONE);
        }



        holder.productType.setText(product.getProductType());


//        Helper.downloadAndSetImage(mContext, holder.productImage, product.getThumbImageUrl());
        Glide.with(mContext).load(product.getThumbImageUrl())
                .fitCenter()
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.productImage);
    }



    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ProductsViewHolder extends RecyclerView.ViewHolder {
        TextView productName;
        TextView productDiscountAmount;
        TextView productAmount;
        ImageView productImage;
        TextView productType;
        TextView productDiscountPercent;

        public ProductsViewHolder(View itemView) {
            super(itemView);
            productName = (TextView) itemView.findViewById(R.id.txt_product_list_item_name);
            productAmount = (TextView) itemView.findViewById(R.id.txt_product_list_item_amount);
            productDiscountAmount = (TextView) itemView.findViewById(R.id.txt_product_list_item_discounted_amount);
            productDiscountPercent = (TextView) itemView.findViewById(R.id.txt_product_list_item_discount_percentage);
            productType = (TextView) itemView.findViewById(R.id.txt_product_list_item_type);
            productImage = (ImageView) itemView.findViewById(R.id.img_product_list_item_thumb);
        }
    }
}
