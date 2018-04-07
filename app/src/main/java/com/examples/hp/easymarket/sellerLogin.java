package com.examples.hp.easymarket;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sellerLogin extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;
    Button _btnLogin;
    EditText _txtemail, _txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_login);
        _txtemail=(EditText)findViewById(R.id.femail);
        _txtPass=(EditText)findViewById(R.id.fPass);
        _btnLogin=(Button)findViewById(R.id.fLogin);
        openHelper=new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = _txtemail.getText().toString();
                String pass = _txtPass.getText().toString();

                cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME1 + " WHERE " + DatabaseHelper.COL_3f + "=? AND " + DatabaseHelper.COL_4f + "=?", new String[]{name, pass});
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        Intent i = new Intent(sellerLogin.this, sellitems.class);

                        String getrec=_txtemail.getText().toString();
                        Bundle bundle = new Bundle();
                        bundle.putString("email", getrec);
                        i.putExtras(bundle);
                        startActivity(i);

                    } else {
                        Toast.makeText(getApplicationContext(), "login failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}