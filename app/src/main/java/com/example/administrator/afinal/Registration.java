package com.example.administrator.afinal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
   Button confirm,userbirth;
   EditText fname,lname,mail,pw,phone,color;
   TextView d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        confirm=findViewById(R.id.confirm);
        d=findViewById(R.id.userdate);

        userbirth=findViewById(R.id.userbirth);
        String data=getIntent().getStringExtra("date");


       userbirth.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(Registration.this,calender.class);
               startActivity(i);
           }
       });
       if(data!=null) {
           d.setText(data);
       }
        color=findViewById(R.id.favoritecolor);

        fname=findViewById(R.id.userfirstname);
        lname=findViewById(R.id.userlastname);
        mail=findViewById(R.id.usermail);
        pw=findViewById(R.id.userpassword);
        phone=findViewById(R.id.userphone);
        final shopping2 reg=new shopping2(this);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check=reg.checkmail(mail.getText().toString());
                if(check==true){
                    boolean insert=reg.addnewuser(fname.getText().toString(),lname.getText().toString(),mail.getText().toString(),pw.getText().toString(),phone.getText().toString(),color.getText().toString(),d.getText().toString());
                    if(insert==true){
                        Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_LONG).show();

                    }
                } else {
                    Toast.makeText(getApplicationContext(),"Email Already Exist",Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}
