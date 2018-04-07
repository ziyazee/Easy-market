package com.examples.hp.easymarket;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class sellitems extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;
    Button sub,b;
    EditText nam,pric, des;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellitems);
        nam=(EditText)findViewById(R.id.name);
        pric = (EditText) findViewById(R.id.price);
        des = (EditText) findViewById(R.id.desc);
        sub = (Button) findViewById(R.id.submit);
        b= (Button) findViewById(R.id.logout);
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        Bundle bundle = getIntent().getExtras();
        final String email = bundle.getString("email");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sellitems.this, MainActivity.class);
                startActivity(intent);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openHelper.getWritableDatabase();
                cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME1 + " WHERE " + DatabaseHelper.COL_3f + "=?", new String[]{email});
                cursor.moveToFirst();
                String isellername=cursor.getString(cursor.getColumnIndex("SellerName"));
                String  iphone=cursor.getString(cursor.getColumnIndex("Phone"));
                String iprice= pric.getText().toString();
                String iname= nam.getText().toString();
                String idesc= des.getText().toString();
                insertdata(iname,idesc,iprice,isellername,iphone);
                Toast.makeText(getApplicationContext(), "item added successfully",Toast.LENGTH_LONG).show();
            }
            public void insertdata(String item, String description, String price, String sellername,String phone){
                ContentValues contentValues = new ContentValues();
                contentValues.put(DatabaseHelper.COL_2i, item);
                contentValues.put(DatabaseHelper.COL_3i, description);
                contentValues.put(DatabaseHelper.COL_4i, price);
                contentValues.put(DatabaseHelper.COL_5i, sellername);
                contentValues.put(DatabaseHelper.COL_6i, phone);
                long id = db.insert(DatabaseHelper.TABLE_NAME2, null, contentValues);
            }
        });
    }
}
