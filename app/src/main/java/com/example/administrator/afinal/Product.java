package com.example.administrator.afinal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;
import android.speech.RecognizerIntent;


import java.util.ArrayList;
import java.util.Locale;

public class Product extends AppCompatActivity {

    GridView gridView;
    ArrayList<productdata> productlist;
    productgrid adapter=null;
    EditText proname;
    Button voice,cam,search,productshow;
    shopping2 database;

    private static final int voicecode=1;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=new MenuInflater(this);
        inflater.inflate(R.menu.menu,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.logout:
                Intent ii=new Intent(Product.this,Login.class);
                startActivity(ii);
                /*   SharedPreferences pref = getSharedPreferences(PREF_NAME,0);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("remeber","false");
                editor.apply();
                finish();*/
                return true;
            case R.id.fashion:
                cat("fashion");
                return true;
            case R.id.laptop:
                 cat("laptop");
                 return  true;
            case R.id.mobile:
                 cat("mobile");
                 return true;
            case R.id.electronic:
                 cat("electronic");
                 return  true;
            case R.id.all:
                all();
                return true;
            case R.id.mycard:
                Intent intent=new Intent(Product.this,mycard.class);
                String x=getIntent().getExtras().getString("email");
                intent.putExtra("email",x);
                startActivity(intent);
        }
        return  false;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        gridView=(GridView)findViewById(R.id.gridview);
         database=new shopping2(this);
        String em=getIntent().getExtras().getString("email");

        productlist=new ArrayList<>();
        adapter=new productgrid(this,R.layout.row,productlist,em);
        gridView.setAdapter(adapter);

        search=findViewById(R.id.sbutton);
        cam=findViewById(R.id.camerasearch);
        voice=findViewById(R.id.voicesearch);
        proname=findViewById(R.id.searchname);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Cursor cursor=database.searchbytext(proname.getText().toString());
                productlist.clear();
                while(cursor.moveToNext())
                {
                    String name=cursor.getString(1);
                    String color=cursor.getString(3);
                    String price=cursor.getString(6);
                    byte [] image=cursor.getBlob(4);
                    productlist.add(new productdata(name,color,price,image));

                }
                adapter.notifyDataSetChanged();

            }
        });
        voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                talk();



            }
        });

        Cursor cursor=database.getproduct("Select * from product");
        productlist.clear();
        while (cursor.moveToNext())
        {
            String name=cursor.getString(1);
            String color=cursor.getString(3);
            String price=cursor.getString(6);
            byte [] image=cursor.getBlob(4);
            productlist.add(new productdata(name,color,price,image));


        }
        adapter.notifyDataSetChanged();



    }

    private void talk(){
        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speak Product name");
        startActivityForResult(intent,voicecode);

    }
    private void byvoice(String name)
    {
        Cursor cursor=database.searchbytext(name);
        productlist.clear();
        while(cursor.moveToNext())
        {
            String namee=cursor.getString(1);
            String color=cursor.getString(3);
            String price=cursor.getString(6);
            byte [] image=cursor.getBlob(4);
            productlist.add(new productdata(namee,color,price,image));

        }
        adapter.notifyDataSetChanged();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case voicecode:{
                if (resultCode==RESULT_OK && null!=data)
                {
                        ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        byvoice(result.get(0));
                }
            }
            break;
        }
    }

    public void cat(String cat)
    {
        Cursor cursor=database.searchbycat(cat);
        productlist.clear();
        while(cursor.moveToNext())
        {
            String namee=cursor.getString(1);
            String color=cursor.getString(3);
            String price=cursor.getString(6);
            byte [] image=cursor.getBlob(4);
            productlist.add(new productdata(namee,color,price,image));

        }
        adapter.notifyDataSetChanged();

    }
    public void all()
    {
        Cursor cursor=database.getproduct("Select * from product");
        productlist.clear();
        while (cursor.moveToNext())
        {
            String name=cursor.getString(1);
            String color=cursor.getString(3);
            String price=cursor.getString(6);
            byte [] image=cursor.getBlob(4);
            productlist.add(new productdata(name,color,price,image));


        }
        adapter.notifyDataSetChanged();
    }
}
