package com.example.listviewnotifiy;

import java.util.ArrayList;
import java.util.HashSet;

import com.example.listviewnotifi.R;

import android.R.color;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter{
	
	private ArrayList<String> arrayList;
	private Context context;
	private int position;
	private ViewGroup parent;
	private View convertView;
	//public static  int mSelectedItems ;
	public ListViewAdapter(ArrayList<String> arrayList,Context context){
		this.arrayList = arrayList;
		this.context = context;
		
	}
	
	@Override
	public int getCount() {
		return arrayList.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
	
	public View setView(int position,View view){
		getView(1,view,null);
//		for(int i=0;i<50;i++){
//			if (i % 2 == 0) {
//				view.setBackgroundColor(Color.parseColor("#FFBBCC"));
//			} else {
//				view.setBackgroundColor(Color.parseColor("#FFEEFF"));
//			}
//		}
//		
		return view;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder = null;
		if(convertView  == null){
			holder = new ViewHolder();
			LayoutInflater mInflater = LayoutInflater.from(context);
			convertView = mInflater.inflate(R.layout.item, null);
			holder.textView = (TextView) convertView.findViewById(R.id.tv_text);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		

		if (position % 2 == 0) {
			convertView.setBackgroundColor(Color.parseColor("#FFBBCC"));
		} else {
			convertView.setBackgroundColor(Color.parseColor("#FFEEFF"));
		}
		if(position == MainActivity.mSelectedItems){
			convertView.setBackgroundColor(Color.parseColor("#00AACC"));
		}
		holder.textView.setText(arrayList.get(position));
		return convertView;
	}

	
	private class ViewHolder {
		TextView textView;
	}

}
