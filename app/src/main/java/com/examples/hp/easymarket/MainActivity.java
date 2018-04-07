package com.examples.hp.easymarket;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    Button   sellogin,selreg,userreg,userlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userlogin=(Button)findViewById(R.id.userlogin);
        selreg=(Button)findViewById(R.id.register);
        sellogin=(Button)findViewById(R.id.btnlogin);
        userreg=(Button)findViewById(R.id.register2);

        sellogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, sellerLogin.class);
                startActivity(intent);

            }
        });
        userreg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, UserRegistration.class);
                startActivity(intent);

            }
        });
        selreg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, sellerRegistration.class);
                startActivity(intent);

            }
        });


        userlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
            }


        });






    }
}
