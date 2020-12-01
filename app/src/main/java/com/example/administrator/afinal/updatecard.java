package com.example.administrator.afinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class updatecard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatecard);

        Button plus=(Button)findViewById(R.id.plusupdate);
        Button minus=(Button)findViewById(R.id.minusupdate);
        Button confirm=(Button)findViewById(R.id.updateamount);
        final shopping2 database=new shopping2(this);

       final TextView proname=(TextView)findViewById(R.id.pronameupdate);
         final TextView proprice=(TextView)findViewById(R.id.propriceupdate);
         final TextView proamount=(TextView)findViewById(R.id.numberofamountupdate);

        String name=getIntent().getExtras().getString("productname");
        String price=getIntent().getExtras().getString("cost");
        String amount=getIntent().getExtras().getString("amount");


        proamount.setText(amount);
        proname.setText(name);
        proprice.setText(price);

        int old1=Integer.parseInt(price);
        int old2=Integer.parseInt(amount);

        final int oldprice=old1/old2;

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number=Integer.parseInt(proamount.getText().toString());
                number=number-1;
                String nw = Integer.toString(number);
                proamount.setText(nw);

            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number=Integer.parseInt(proamount.getText().toString());
                number=number+1;
                String nw = Integer.toString(number);
                proamount.setText(nw);
            }
        });


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int n=Integer.parseInt(proamount.getText().toString());
                int newcost=n*oldprice;
                String cost=Integer.toString(newcost);
                database.updatebuy(proname.getText().toString(),proamount.getText().toString(),cost);
            }
        });






    }
}
