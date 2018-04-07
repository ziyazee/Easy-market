package com.examples.hp.easymarket;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class SQLiteListAdapter extends BaseAdapter {
	
    Context context;
    Button b;
    ArrayList<String> id;
    ArrayList<String> item;
    ArrayList<String> description;
    ArrayList<String> price;
    ArrayList<String> name ;
    ArrayList<String> phone ;

    public SQLiteListAdapter(
    		Context context2,
            ArrayList<String> did,
            ArrayList<String> ditem,
    		ArrayList<String> ddescription,
    		ArrayList<String> dprice,
    		ArrayList<String> dname,
            ArrayList<String> dphone
            )
    {
    	this.context = context2;
        this.id = did;
        this.item = ditem;
        this.description = ddescription;
        this.price = dprice ;
        this.name = dname ;
        this.phone = dphone ;
    }
    public int getCount() {
        return id.size();
    }
    public Object getItem(int position) {
        return null;
    }
    public long getItemId(int position) {
        return 0;
    }
    public View getView(int position, View child, ViewGroup parent) {
        final Holder holder;
        LayoutInflater layoutInflater;
        if (child == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            child = layoutInflater.inflate(R.layout.listviewdatalayout, null);
            holder = new Holder();
            holder.textviewitem = (TextView) child.findViewById(R.id.item);
            holder.textviewdescription = (TextView) child.findViewById(R.id.description);
            holder.textviewprice = (TextView) child.findViewById(R.id.price);
            holder.textviewname = (TextView) child.findViewById(R.id.name);
            holder.textviewphone = (TextView) child.findViewById(R.id.phone);
            holder.bb=(Button)child.findViewById(R.id.bttn);
            child.setTag(holder);
        } else {
        	holder = (Holder) child.getTag();
        }
        holder.textviewitem.setText("Item Name:"+item.get(position));
        holder.textviewdescription.setText("Description:"+description.get(position));
        holder.textviewprice.setText("Price:"+price.get(position)+"\n---------------------------");
        holder.textviewname.setText("Sold By:"+name.get(position));
        holder.textviewphone.setText("Contact:"+phone.get(position));
        return child;
    }
    public class Holder {
        TextView textviewitem;
        TextView textviewdescription;
        TextView textviewprice;
        TextView textviewname;
        TextView textviewphone;
        Button bb;
    }
}