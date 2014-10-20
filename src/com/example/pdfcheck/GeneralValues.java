package com.example.pdfcheck;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

 
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

public class GeneralValues {
	public static String serverPath = "http://108.168.203.226:8200/";
	public static String userPicPath = "http://108.168.203.226:8200/images/";

	public static String sServiceName;
	public static final String CLIENT_ID = "QZCCPBB3HF5RISCEOWFQCPPJECUD0ZIG1CJXWJGS2YP0EQ4Y";
	public static final String CLIENT_SECRET = "SPMPOYWSF20IGD3MFG5YRG4JBQUNLSRCNYXE1BQWSMTN3F2Y";
	public static String URLFORPLACESLIST = "http://maps.google.com/maps/api/geocode/json?sensor=false&address=";
	/** The variable to add parameters to url */
	public static String sParameter;
	/** The variable to manage server status */
	public static boolean sServerStatus = false;

	/** The variable to manage internet status */
	public static boolean sInternetStatus = false;

	/** The API Key for bugsense */
	public static Context sApplicationContext;
	public static final String RESULTS = "results";
	public static final String ADDRESS = "formatted_address";
	public static final String JOBJECT_GEO = "geometry";
	public static final String JOBJECT_LOC = "location";
	public static final String LATTITUDE = "lat";
	public static final String LONGITUDE = "lng";

	public static String sLoggedinUsername;
	public static String sLoggedinUser;
	public static String sRegisteredUserID = "";

	public static String sLoggedinUserDeviceType;
	public static String sLoggedinUserEmail;
	public static ArrayList<String> sSelectedTriptypesIds;
	public static ArrayList<String> sTriptypesIds;
	public static ArrayList<String> sTriptypesValues;
	public static ArrayList<String> sPaymentTypesValues;
	public static ArrayList<String> sDelayReportingTypesIds;
	public static ArrayList<String> sDelayReportingTypesValues;

	public static HashMap<String, String> sTriptypes;
	public static HashMap<String, String> mTriptypes;
	public static HashMap<String, String> sSubTriptypes;
	public static HashMap<String, String> sPaymentTypes;
	public static HashMap<String, String> sDelayReportingTypes;
	public static String sDeviceType = "android";
	public static ArrayList marraylist = new ArrayList();
	 

	public static Boolean IsUserLoggedIn = false;
	public static Boolean IsUserFromEditProfile = false;
	public static Boolean Isprofilefilled = false;
	// Four Square Lat and Long

	public static String PREF_PASSWORD;
	public static String messageText;
	public static String GCM_SenderID;
	public static String sLoggedinUserDeviceId;
	public static Object sSelectedMessageId = "";
	public static String sLoggedinUsertype = "";

	public static boolean fromdriversignup = false;

	public static class HOME_MENU {
		public static final int SETTING = 1;
		public static final int CHANGE_PASSWORD = 0;
		public static final int LOGOUT = 2;
	}

	public static class HOME_TOW_CAR {
		public static Boolean tow1 = false;
		public static Boolean tow2 = false;
		public static HashMap<String, String> towhash;

	}

	public static class EXIF_ORIENTATION_CODES {
		public static final int ORIENTATION_ROTATE_90 = 6;
		public static final int ORIENTATION_ROTATE_180 = 3;
		public static final int ORIENTATION_ROTATE_270 = 8;
	}

	public static class TripLocationDetails {
		public static String HomeLat = "";
		public static String HomeLong = "";
		public static String DestLat = "";
		public static String DestLong = "";
	}

	public static HashMap<String, String> hashmile;
	public static HashMap<Integer, ArrayList<String>> flatchargeeshash;
	public static int flagchargescounter = 0;

	// Internet on/off check
	public static boolean isInternetOn(Context mconstContext) {
		ConnectivityManager connec = (ConnectivityManager) mconstContext
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		// ARE WE CONNECTED TO THE NET
		if (connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED
				|| connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING
				|| connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING
				|| connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {
			// MESSAGE TO SCREEN FOR TESTING (IF REQ)
			// Toast.makeText(this, connectionType + ” connected”,
			// Toast.LENGTH_SHORT).show();
			return true;
		} else if (connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED
				|| connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED) {
			// System.out.println(“Not Connected”);
			return false;
		}
		return false;
	}

	// Alert Box to show no internet connection
	public static void showAlert_Network_not_available(Context mContext) {
		AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();
		alertDialog.setTitle("Error!");

		alertDialog.setMessage("Network not available.");

		// alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
		// public void onClick(DialogInterface dialog, int which) {
		// }
		// });
		alertDialog.show();
	}

	// Webservice of Staging Server
	public static class WB_URL {
		public static final String web_service = "http://108.168.203.226:8200/services/";
		public static final String Login_webservice = web_service + "sign_in";
		public static final String driver_signup_webservice = web_service
				+ "driver_sign_up";
		public static final String driver_update_webservice = web_service
				+ "driver_update_profile";
		public static final String dealer_signup_webservice = web_service
				+ "dealer_sign_up";
		public static final String driverupload_webservice = web_service
				+ "driver_upload";
		public static final String dealerupload_webservice = web_service
				+ "dealer_upload";
		public static final String driverprofile_webservice = web_service
				+ "driver_details";
		public static final String dealerprofile_webservice = web_service
				+ "dealer_detail";
		public static final String forgotpassword_webservice = web_service
				+ "forgot_password";
		public static final String AddAuthUsers_webservice = web_service
				+ "AuthorizedUsers_signup";
		public static final String DelAuthUsers_webservice = web_service
				+ "del_authuser";
		public static final String dealer_updateprofile_webservice = web_service
				+ "dealer_update_profile";
		public static final String Triptype_webservice = web_service
				+ "gettriptype";
		public static final String Subtriptype_webservice = web_service
				+ "getsubtriptype";
		public static final String ChangePassword_webservice = web_service
				+ "changepassword";
		public static final String PaymentType_webservice = web_service
				+ "paytype";
		public static final String DriverSearch_webservice = web_service
				+ "search_driver";
		public static final String InviteDriver_webservice = web_service
				+ "invite_driver";
		public static final String AcceptInvitation_webservice = web_service
				+ "accept_driver";
		public static final String TripRequests_webservice = web_service
				+ "create_trip";
		public static final String TripUploads_webservice = web_service
				+ "trip_upload";
		public static final String CurrentTrips_webservice = web_service
				+ "current_trips";
		public static final String AcceptTripRequests_webservice = web_service
				+ "approve_triprequest";
		public static final String PickUpDetails_webservice = web_service
				+ "pickupdetails";
		public static final String MyRequsts_webservice = web_service
				+ "trip_requestreceived";
		public static final String StartTrip_webservice = web_service
				+ "start_trip";
		public static final String MyDrivers_webservice = web_service
				+ "getmydrivers";
		public static final String ProblemReporting_webservice = web_service
				+ "getdropdowndelay";
	}

	/** Checks whether two providers are the same */
	public static boolean isSameProvider(String provider1, String provider2) {
		if (provider1 == null) {
			return provider2 == null;
		}
		return provider1.equals(provider2);
	}

	public static Location getBetterLocation(Location newLocation,
			Location currentBestLocation) {
		final int TWO_MINUTES = 1000 * 60 * 2;
		if (currentBestLocation == null) {
			// A new location is always better than no location
			return newLocation;
		}

		// Check whether the new location fix is newer or older
		long timeDelta = newLocation.getTime() - currentBestLocation.getTime();
		boolean isSignificantlyNewer = timeDelta > TWO_MINUTES;
		boolean isSignificantlyOlder = timeDelta < -TWO_MINUTES;
		boolean isNewer = timeDelta > 0;

		// If it's been more than two minutes since the current location, use
		// the new location
		// because the user has likely moved.
		if (isSignificantlyNewer) {
			return newLocation;
			// If the new location is more than two minutes older, it must be
			// worse
		} else if (isSignificantlyOlder) {
			return currentBestLocation;
		}

		// Check whether the new location fix is more or less accurate
		int accuracyDelta = (int) (newLocation.getAccuracy() - currentBestLocation
				.getAccuracy());
		boolean isLessAccurate = accuracyDelta > 0;
		boolean isMoreAccurate = accuracyDelta < 0;
		boolean isSignificantlyLessAccurate = accuracyDelta > 200;

		// Check if the old and new location are from the same provider
		boolean isFromSameProvider = isSameProvider(newLocation.getProvider(),
				currentBestLocation.getProvider());

		// Determine location quality using a combination of timeliness and
		// accuracy
		if (isMoreAccurate) {
			return newLocation;
		} else if (isNewer && !isLessAccurate) {
			return newLocation;
		} else if (isNewer && !isSignificantlyLessAccurate
				&& isFromSameProvider) {
			return newLocation;
		}
		return currentBestLocation;
	}

	public static Location requestUpdatesFromProvider(final String provider,
			final int errorResId, LocationManager mLocationManager,
			Activity activity) {
		final int TEN_SECONDS = 10000;
		final int TEN_METERS = 10;
		Location location = null;
		if (mLocationManager.isProviderEnabled(provider)) {
			mLocationManager.requestLocationUpdates(provider, TEN_SECONDS,
					TEN_METERS, listener);
			location = mLocationManager.getLastKnownLocation(provider);
		} else {
			// Toast.makeText(activity, errorResId, Toast.LENGTH_LONG).show();
		}
		return location;
	}

	public final static LocationListener listener = new LocationListener() {

		@Override
		public void onLocationChanged(Location location) {
			// A new location update is received. Do something useful with it.
			// Update the UI with
			// the location update.
			updateUILocation(location);
		}

		@Override
		public void onProviderDisabled(String provider) {
		}

		@Override
		public void onProviderEnabled(String provider) {
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
		}
	};
	public static HashMap<String, String> hashforhour;
	public static String[] lstSearchPath;
	public static ArrayList<String> arrFileList = new ArrayList<String>();
	public static ArrayList<String> arraylist1 = new ArrayList<String>();
 
	public static String pathforresume = "";
	public static String sDealerImage = "";
 
	public static HashMap<String, String> mPaymentTypes;
	public static boolean sIsFromDriverSearch = false;
	public static String sSelectedDriverID = "";
 
	public static String sCreatedTripId = "";
	public static boolean sFromPage1 = false;
	public static boolean sFromPage2 = false;
	public static boolean sFromPage3 = false;
	public static String sDriverImage = "";
	public static String sSelectedTripId = "";
	public static String sSelectedTripRequestId = "";
 
 

	public static double[] updateUILocation(Location location) {

		double[] latLong = { location.getLatitude(), location.getLongitude() };
		return latLong;

	}

	public static final class FontsOverride {

		public static void setDefaultFont(Context context,
				String staticTypefaceFieldName, String fontAssetName) {
			final Typeface regular = Typeface.createFromAsset(
					context.getAssets(), fontAssetName);
			replaceFont(staticTypefaceFieldName, regular);
		}

		protected static void replaceFont(String staticTypefaceFieldName,
				final Typeface newTypeface) {
			try {
				final Field StaticField = Typeface.class
						.getDeclaredField(staticTypefaceFieldName);
				StaticField.setAccessible(true);
				StaticField.set(null, newTypeface);
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

}
