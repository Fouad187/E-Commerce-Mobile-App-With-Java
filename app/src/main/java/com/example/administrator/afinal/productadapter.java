package com.example.administrator.afinal;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class productadapter extends RecyclerView.Adapter<setview> {
    List<productdata> data=Collections.emptyList();
    public itemclicklistner item;
    private Activity activity;

    public productadapter(List<productdata> pro){
        this.data=pro;
    }

    @NonNull
    @Override
    public setview onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row,viewGroup,false);

        return new setview(view);
    }


    @Override
    public void onBindViewHolder(@NonNull setview setview, final int i) {
          setview.name.setText(data.get(i).getName());
          setview.color.setText(data.get(i).getColor());
          setview.price.setText(data.get(i).getPrice());

          setview.itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                      //ntent intent=new Intent(Product.this,showproduct.class);


              }
          });
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public void setItemClicklisnter(itemclicklistner listner){
        this.item=listner;
    }
}
