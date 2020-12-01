package com.example.administrator.afinal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button log,forgetpw;
    EditText name,pw;
    CheckBox checkBox;


   // private static final String PREF_NAME ="prefs";
    private static final String KEY_REMEMBER ="remember";
    private static final String KEY_EMAIL ="email";
    private static final String KEY_PW ="password";

    private  static String PREF_NAME = "myPref_File";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        log=findViewById(R.id.log);

        name=findViewById(R.id.username);
        pw=findViewById(R.id.userpw);


        forgetpw=findViewById(R.id.forget);
        checkBox=findViewById(R.id.check);
/*
        SharedPreferences preferences=getSharedPreferences(PREF_NAME,0);
        String check=preferences.getString("remeber","");

        if(check.equals("true")){

            Intent i=new Intent(getApplicationContext(),Product.class);
            startActivity(i);
        }
        else if (check.equals("false")){
            Toast.makeText(getApplicationContext(),"plse sign in ",Toast.LENGTH_SHORT).show();

        }
*/

       final shopping2 login=new shopping2(this);
       log.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if (name.getText().toString().equals("admin") && pw.getText().toString().equals("admin")) {
                       Intent intent = new Intent(Login.this, Admin.class);
                       startActivity(intent);
                   } else {
                       boolean x = login.loginuser(name.getText().toString(), pw.getText().toString());
                       if (x == true) {
                           Intent intent = new Intent(Login.this, Product.class);
                           intent.putExtra("email", name.getText().toString());
                           startActivity(intent);
                       } else {

                           Toast.makeText(getApplicationContext(), "Please Enter a valid Email and Password", Toast.LENGTH_LONG).show();

                       }
                   }
               }
           });
        forgetpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login.this,forget.class);
                startActivity(i);
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked())
                {
                    SharedPreferences preferences=getSharedPreferences(PREF_NAME,0);
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putString("remeber","true");
                    editor.apply();

                }else if(!buttonView.isChecked())
                {

                    SharedPreferences preferences=getSharedPreferences(PREF_NAME,0);
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putString("remeber","false");
                    editor.apply();

                }
            }
        });



    }



}
