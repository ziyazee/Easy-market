package com.examples.hp.easymarket;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;
    Button _usrLogin;
    EditText _txtEmail, _txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _txtEmail=(EditText)findViewById(R.id.txtEmail);
        _txtPass=(EditText)findViewById(R.id.txtPass);
        _usrLogin=(Button)findViewById(R.id.usrLogin);
        openHelper=new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        _usrLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = _txtEmail.getText().toString();
                String pass = _txtPass.getText().toString();

                cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME3 + " WHERE " + DatabaseHelper.COL_5 + "=? AND " + DatabaseHelper.COL_4 + "=?", new String[]{email, pass});
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        Intent i = new Intent(login.this, ListViewActivity.class);
                        startActivity(i);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "login failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}
