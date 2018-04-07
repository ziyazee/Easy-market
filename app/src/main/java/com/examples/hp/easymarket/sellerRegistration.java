package com.examples.hp.easymarket;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sellerRegistration extends AppCompatActivity {
    Button b;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    EditText _name,_pass,_phone,_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_registration);
        openHelper = new DatabaseHelper(this);
        _name=(EditText)findViewById(R.id.name);
        _pass=(EditText)findViewById(R.id.password);
        _phone=(EditText)findViewById(R.id.phone);
        _email=(EditText)findViewById(R.id.email);
        b=(Button)findViewById(R.id.register);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openHelper.getWritableDatabase();
                String rname=_name.getText().toString();
                String rpass=_pass.getText().toString();
                String rphone=_phone.getText().toString();
                String remail=_email.getText().toString();
                insertdata(rname,rpass,rphone,remail);
                Toast.makeText(getApplicationContext(), "register successfully",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(sellerRegistration.this, MainActivity.class);
                startActivity(intent);
            }
            public void insertdata(String fname,String fpass,String fphone,String femail){
                ContentValues contentValues = new ContentValues();
                contentValues.put(DatabaseHelper.COL_2f, fname);
                contentValues.put(DatabaseHelper.COL_3f, femail);
                contentValues.put(DatabaseHelper.COL_4f, fpass);
                contentValues.put(DatabaseHelper.COL_5f, fphone);
                long id = db.insert(DatabaseHelper.TABLE_NAME1, null, contentValues);
            }

        });


    }
}
