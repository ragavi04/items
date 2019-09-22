package com.example.mobile_project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LoginItemList extends AppCompatActivity {
    GridView gridView;
    ArrayList<Item> list;
    ItemListAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginitem_list);
        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new ItemListAdapter(this, R.layout.mob_item, list);
        gridView.setAdapter(adapter);

        // get all data from sqlite
        Cursor cursor = ItemMainActivity.sqLiteHelper.getData("SELECT * FROM ITEM");
        list.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String price = cursor.getString(2);
            String des = cursor.getString(3);
            byte[] image = cursor.getBlob(4);

            list.add(new Item(name, price, des, image, id));
        }
        adapter.notifyDataSetChanged();

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                CharSequence[] items = {"Add to cart"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(LoginItemList.this);


                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (item == 0) {
                            //Intent change for addtocart
                            Intent intent = new Intent(LoginItemList.this, ItemList.class);
                            startActivity(intent);

                        }
                    }
                });
                dialog.show();
                return true;
            }
        });
    }
}