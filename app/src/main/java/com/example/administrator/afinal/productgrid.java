package com.example.administrator.afinal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class productgrid extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<productdata> productlist;
   private String mail;
    public productgrid(Context context, int layout, ArrayList<productdata> productlist,String mail) {
        this.context = context;
        this.layout = layout;
        this.productlist = productlist;
        this.mail=mail;
    }



    @Override
    public int getCount() {
        return productlist.size();
    }

    @Override
    public Object getItem(int position) {
        return productlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
     private class ViewHolder{
        ImageView imageView;
        TextView name,color,price;
        Button b;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View row=convertView;
       ViewHolder holder=new ViewHolder();

       if(row == null)
       {
           LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           row=inflater.inflate(layout,null);
           holder.name=(TextView)row.findViewById(R.id.productname);
           holder.color=(TextView)row.findViewById(R.id.productcolor);
           holder.price=(TextView)row.findViewById(R.id.productprice);
           holder.imageView=(ImageView)row.findViewById(R.id.cardview);
           holder.b=(Button)row.findViewById(R.id.productshow);

           row.setTag(holder);
       }
       else {
            holder=(ViewHolder)row.getTag();
       }
       productdata pro=productlist.get(position);
       holder.name.setText(pro.getName());
       holder.color.setText(pro.getColor());
       holder.price.setText(pro.getPrice());
       final byte[] proimage=pro.getImage();
       Bitmap bitmap= BitmapFactory.decodeByteArray(proimage,0,proimage.length);
       holder.imageView.setImageBitmap(bitmap);

       final String name1=holder.name.getText().toString();
       final String color=holder.color.getText().toString();
       final String pric =holder.price.getText().toString();
        holder.b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context,showproduct.class);
                intent.putExtra("name",name1);
                intent.putExtra("image",proimage);
                intent.putExtra("color",color);
                intent.putExtra("price",pric);
                intent.putExtra("email",mail);
                context.startActivity(intent);
            }
        });

        return row;
    }
}
