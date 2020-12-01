package com.example.administrator.afinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class forget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
       final EditText email=(EditText)findViewById(R.id.forgetmail);
       final EditText color=(EditText)findViewById(R.id.favoritecolor);
        final TextView password=(TextView)findViewById(R.id.textView5);

        Button get=(Button)findViewById(R.id.getpassword);
        final shopping2 database=new shopping2(this);

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           String x=database.getpassword(email.getText().toString(),color.getText().toString());
              password.setText(x);
            }
        });





    }
}
