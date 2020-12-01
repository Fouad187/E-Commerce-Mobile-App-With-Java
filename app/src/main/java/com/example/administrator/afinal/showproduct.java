package com.example.administrator.afinal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class showproduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showproduct);

        final String name=getIntent().getExtras().getString("name");
        final String color=getIntent().getExtras().getString("color");
        final String pricee=getIntent().getExtras().getString("price");
        final String email=getIntent().getExtras().getString("email");
        final shopping2 database=new shopping2(this);
        TextView x=findViewById(R.id.proname);
        TextView y=(TextView)findViewById(R.id.procolor);
        TextView z=(TextView)findViewById(R.id.proprice);
        TextView hh=(TextView)findViewById(R.id.desid);

        final TextView amount=(TextView)findViewById(R.id.numberofamount);
        Button minus=(Button)findViewById(R.id.minus);
        Button plus=(Button)findViewById(R.id.plus);
        Button add=(Button)findViewById(R.id.addtocard);

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number=Integer.parseInt(amount.getText().toString());
                number=number-1;
                    String nw = Integer.toString(number);
                    amount.setText(nw);

            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number=Integer.parseInt(amount.getText().toString());
                number=number+1;
                String nw = Integer.toString(number);
                amount.setText(nw);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p=Integer.parseInt(pricee);
                int a=Integer.parseInt(amount.getText().toString());
                int mul=p*a;
                String totalprice=Integer.toString(mul);

                boolean y=database.addbuy(email,name,amount.getText().toString(),totalprice);
                if(y==true)
                {
                    Toast.makeText(getApplicationContext(),"Product Added To Your Card",Toast.LENGTH_LONG).show();
                }
            }
        });

        ImageView imageView=findViewById(R.id.imageshow);

        byte [] arr=getIntent().getByteArrayExtra("image");
        Bitmap bitmap= BitmapFactory.decodeByteArray(arr,0,arr.length);
        imageView.setImageBitmap(bitmap);
        x.setText(name);
        y.setText(color);
        z.setText(pricee);

    }
}
