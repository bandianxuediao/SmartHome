package SHome.Pack;


import SHome.Pack.R;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;



public class Preconfig extends PreferenceActivity {
    /** Called when the activity is first created. */
	  static String strText;
	  @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        addPreferencesFromResource(R.xml.wifiset);

	  }

	  public static String getHostIp(Context context) {
			return PreferenceManager.getDefaultSharedPreferences(context)
					.getString("setting_host_ip", "192.168.2.3");
		}
	  public static String getDevAddr(Context context) {
			return PreferenceManager.getDefaultSharedPreferences(context)
					.getString("setting_dev_addr", "1");
		}
	  public static String getRelayText(Context context,int iChannel) {
		
		  	if(iChannel == 1)
		  		strText = PreferenceManager.getDefaultSharedPreferences(context)
					.getString("setting_realy1", "");
		  	else if(iChannel == 2)
		  		strText = PreferenceManager.getDefaultSharedPreferences(context)
				.getString("setting_realy2", "");
		  	else if(iChannel == 3)
		  		strText = PreferenceManager.getDefaultSharedPreferences(context)
				.getString("setting_realy3", "");
		  	else if(iChannel == 4)
		  		strText = PreferenceManager.getDefaultSharedPreferences(context)
				.getString("setting_realy4", "");
		  	else if(iChannel == 5)
			  		strText = PreferenceManager.getDefaultSharedPreferences(context)
					.getString("setting_realy5", "");
		  	else if(iChannel == 6)
		  		strText = PreferenceManager.getDefaultSharedPreferences(context)
				.getString("setting_realy6", "");
		  	else if(iChannel == 7)
		  		strText = PreferenceManager.getDefaultSharedPreferences(context)
				.getString("setting_realy7", "");
		  	else if(iChannel == 8)
			  		strText = PreferenceManager.getDefaultSharedPreferences(context)
					.getString("setting_realy8", "");
		  	else if(iChannel == 9)
		  		strText = PreferenceManager.getDefaultSharedPreferences(context)
				.getString("setting_realy9", "");
		  	else if(iChannel == 10)
			  		strText = PreferenceManager.getDefaultSharedPreferences(context)
					.getString("setting_realy10", "");
		  	else if(iChannel == 11)
		  		strText = PreferenceManager.getDefaultSharedPreferences(context)
				.getString("setting_realy11", "");
		  	else if(iChannel == 12)
			  		strText = PreferenceManager.getDefaultSharedPreferences(context)
					.getString("setting_realy12", "");
		  	
		  	
		  	
			return strText;
		}
	  
		public static void setHostIp(Context context,String ip) {
			saveString(context,"setting_host_ip", ip);
		}	
		public static void setDevAddr(Context context,String txt) {
			saveString(context,"setting_dev_addr", txt);
		}
		public static void setRelayText(Context context,int iChannel,String txt) {
			if(iChannel == 1)
				saveString(context,"setting_realy1", txt);
			else if(iChannel == 2)
				saveString(context,"setting_realy2", txt);
			else if(iChannel == 3)
				saveString(context,"setting_realy3", txt);
			else if(iChannel == 4)
				saveString(context,"setting_realy4", txt);
			else if(iChannel == 5)
				saveString(context,"setting_realy5", txt);
			else if(iChannel == 6)
				saveString(context,"setting_realy6", txt);
			else if(iChannel == 7)
				saveString(context,"setting_realy7", txt);
			else if(iChannel == 8)
				saveString(context,"setting_realy8", txt);
			else if(iChannel == 9)
				saveString(context,"setting_realy9", txt);
			else if(iChannel == 10)
				saveString(context,"setting_realy10", txt);
			else if(iChannel == 11)
				saveString(context,"setting_realy11", txt);
			else if(iChannel == 12)
				saveString(context,"setting_realy12", txt);
			
			
			
			
			
	
		}	
		public static String getHostPort(Context context) {
			return PreferenceManager.getDefaultSharedPreferences(context).getString("setting_host_port", "5000");
		}
		
		public static void setHostPort(Context context,String port) {
			saveString(context,"setting_host_port", port);
		}
		private static void saveString(Context context,String key,String value){
			SharedPreferences setting = PreferenceManager.getDefaultSharedPreferences(context); 
			Editor editor = setting.edit();
			editor.putString(key, value);
			editor.commit();
		}
}