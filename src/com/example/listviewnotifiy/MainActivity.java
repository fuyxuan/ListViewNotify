package com.example.listviewnotifiy;

import java.util.ArrayList;
import java.util.HashSet;

import com.example.listviewnotifi.R;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class MainActivity extends Activity {
	
	private Context context ;
	public static int mSelectedItems=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        
        ArrayList<String> arrayList = new ArrayList<String>();
        
        
        for(int i=0;i<50;i++){
        	arrayList.add("AA"+i);
        }
        
        final ListViewAdapter listViewAdapter = new ListViewAdapter(arrayList,context);
        
        
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(listViewAdapter);
        
        for(int i=0;i<listViewAdapter.getCount();i++){
        	listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        
        listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				Log.i("msg","on item click");
				mSelectedItems = position;
				for(int i = 0 ;parent.getChildCount() > i ;i++){
					View v = parent.getChildAt(i);
					if (i % 2 == 0) {
						v.setBackgroundColor(Color.parseColor("#FFBBCC"));
					} else {
						v.setBackgroundColor(Color.parseColor("#FFEEFF"));
					}
				}
				
				view.setBackgroundColor(Color.parseColor("#00AACC"));
			}

		});
        listViewAdapter.notifyDataSetChanged();
        
    }



}
