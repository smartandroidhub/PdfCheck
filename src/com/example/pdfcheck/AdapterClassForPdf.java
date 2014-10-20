package com.example.pdfcheck;

import java.util.ArrayList;

 
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterClassForPdf extends BaseAdapter {
	private static ArrayList<String> nameArrayList;
	private static ArrayList<String> AuthIDArrayList;
	public String authuserid = "";
	public int pos = 0;
	private LayoutInflater mInflater;
	Context mcontext;

	public AdapterClassForPdf(Context context, ArrayList<String> name) {
		nameArrayList = name;

		mcontext = context;
		mInflater = LayoutInflater.from(context);
	}

	public int getCount() {
		return nameArrayList.size();
	}

	public Object getItem(int position) {
		return nameArrayList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.listview_pdf_row, null);
			holder = new ViewHolder();
			holder.txtName = (TextView) convertView.findViewById(R.id.pdftext);
			holder.img = (ImageView) convertView.findViewById(R.id.imagepdf);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.txtName.setText(nameArrayList.get(position));
		 

		return convertView;
	}

	static class ViewHolder {
		TextView txtName;
		ImageView img;
	}

}
