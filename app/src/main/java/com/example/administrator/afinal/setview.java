package com.example.administrator.afinal;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class setview extends RecyclerView.ViewHolder {
    public TextView name,color,price;
    public ImageView image;
    public itemclicklistner item;

    public setview(@NonNull View itemView) {
        super(itemView);
        name=(TextView)itemView.findViewById(R.id.productname);
        color=(TextView)itemView.findViewById(R.id.productcolor);
        price=(TextView)itemView.findViewById(R.id.productprice);
        image=(ImageView)itemView.findViewById(R.id.cardview);
    }

 /*   public void setItemClicklisnter(itemclicklistner listner){
      this.item=listner;
    }

    public void onClick(View view){
        item.onClick(view,getAdapterPosition(),false);
    }*/
}
