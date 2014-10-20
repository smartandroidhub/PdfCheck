package com.example.pdfcheck;

 
import java.io.File;

import net.sf.andpdf.pdfviewer.PdfViewerActivity;

 
import android.app.Activity;
import android.app.Dialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Pdfclass extends Activity{
	private Dialog InfoDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_pdf);
		
 	new Driverpdffetch().execute();
		
	/*	Intent intent = new Intent(Pdfclass.this, MainActivity.class);
	     intent.putExtra(MainActivity.EXTRA_PDFFILENAME,  "/mnt/sdcard/Download/PBGSM2013AUGM15_1601540245_7696674240.pdf");
	     startActivity(intent);*/
		
		
	 
//		    this.setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, GeneralValues.arrFileList));
	}
	
	
     

private void openPdfIntent(String path) 
{
    try
    {
      final Intent intent = new Intent(Pdfclass.this, MainActivity.class);
      intent.putExtra(PdfViewerActivity.EXTRA_PDFFILENAME, path);
      startActivity(intent);
    }
    catch (Exception e) 
    {
      e.printStackTrace();
    }
}
	public void onInfopdfClick(View view) {

		InfoDialog = new Dialog(Pdfclass.this);
		InfoDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		InfoDialog.setContentView(R.layout.listview_pdf);
		InfoDialog.getWindow().setFeatureInt(Window.FEATURE_NO_TITLE, 0);
		InfoDialog.setCancelable(true);
		InfoDialog.show();

		ListView listview = (ListView) InfoDialog
				.findViewById(R.id.listviewpdf);
		AdapterClassForPdf adapter = new AdapterClassForPdf(
				getApplicationContext(), GeneralValues.arrFileList);
		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// my code
				GeneralValues.pathforresume = GeneralValues.arrFileList.get(
						arg2).toString();
				Toast.makeText(getApplicationContext(),
						"you selected" + GeneralValues.arrFileList.get(arg2),
						Toast.LENGTH_LONG).show();
				
				
				InfoDialog.cancel();
				 Intent intent = new Intent(Pdfclass.this, MainActivity.class);
			     intent.putExtra(MainActivity.EXTRA_PDFFILENAME,  GeneralValues.arrFileList.get(arg2));
			     startActivity(intent);
			}

		});

	}

	public class Driverpdffetch extends AsyncTask<Void, Void, Void> {

		ProgressDialog authDialog;

		Context context;

		private Intent intent;

		@Override
		protected void onPreExecute() {
			 
			/* Create Connection class object */


		}

		 

		/**
		 * activateDriverCheckResponse 1 = flag(Email does not Exist) 2 = Error
		 * with HTTP connection 3 = Error while convert into string 4 = Failure
		 * 5 = Email Already Exist
		 */
		/*protected void onPostExecute(View jso) {
			viewProgressGone();
			onInfopdfClick(jso);

		}*/

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			ListView listview = (ListView) 
					findViewById(R.id.listviewpdf);
			AdapterClassForPdf adapter = new AdapterClassForPdf(
					getApplicationContext(), GeneralValues.arrFileList);
			listview.setAdapter(adapter);

			listview.setOnItemClickListener(new OnItemClickListener() {

				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					// my code
					GeneralValues.pathforresume = GeneralValues.arrFileList.get(
							arg2).toString();
					Toast.makeText(getApplicationContext(),
							"you selected" + GeneralValues.arrFileList.get(arg2),
							Toast.LENGTH_LONG).show();
					
					
 
					 Intent intent = new Intent(Pdfclass.this, MainActivity.class);
				     intent.putExtra(PdfViewerActivity.EXTRA_PDFFILENAME,  GeneralValues.arrFileList.get(arg2));
				     startActivity(intent);
				}

			});

		}
		
		
		/** Functions to display progress dialog box **/

		public void viewProgressGone() {
			authDialog.dismiss();
		}

		public void viewProgressVisible(String paramString) {
			authDialog = ProgressDialog.show(context, "Registration",
					paramString, true, false);
		}

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			search_Clicked(".pdf");
			return null;
		}
	}

	public void search_Clicked(String type) {
		GeneralValues.arrFileList.clear();

		String systemPath = Environment.getRootDirectory().getAbsolutePath();

		String extPath = Environment.getExternalStorageDirectory()
				.getAbsolutePath();
		GeneralValues.lstSearchPath = new String[] { systemPath, extPath };
		for (int x = 0; x < GeneralValues.lstSearchPath.length; x++) {
			File fileSystem = new File(GeneralValues.lstSearchPath[x]);
			File[] arrfileSystem = fileSystem.listFiles();
			if (arrfileSystem != null) {
				for (int i = 0; i < arrfileSystem.length; i++) {
					if (arrfileSystem[i].isDirectory()) {
						File search = new File(arrfileSystem[i].getPath());
						searchFunction(search, type);
					} else {

						if (arrfileSystem[i].getPath().toLowerCase()
								.contains(".pdf"))

						{
							GeneralValues.arrFileList.add(arrfileSystem[i]
									.getPath());

							Log.v("the size of the search list in else", ""
									+ GeneralValues.arrFileList.size());

						}
					}
				}
			}
		}

	}

	public void searchFunction(File search, String type) {
		File[] searchlist = search.listFiles();

		if (searchlist != null) {
			for (int j = 0; j < searchlist.length; j++) {
				if (searchlist[j].isDirectory()) {
					File f = new File(searchlist[j].getPath());
					searchFunction(f, type);
				} else {

					// Log.i("the path of the files are",
					// ""+searchlist[j].getPath().toLowerCase().contains(".pdf"));

					if (searchlist[j].getPath().toLowerCase().contains(type))

					{
						Log.i("the size of the search list is", ""
								+ GeneralValues.arrFileList.size());

						GeneralValues.arrFileList.add(searchlist[j].getPath());
						Log.i("paths", searchlist[j].getPath());

					}

				}

			}
		}
	}

}
