package com.pgl.sys.ces.a;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.pgl.a.b.d;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;

public class f {
  public static String a(Context paramContext) {
    try {
      WifiInfo wifiInfo = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      String str1 = wifiInfo.getBSSID();
      if (str1 == null) {
        str1 = "";
      } else {
        str1 = str1.trim();
      } 
      String str2 = wifiInfo.getSSID();
      if (str2 == null) {
        str2 = "";
      } else {
        str2 = str2.trim();
      } 
      String str3 = str2.replace(' ', ' ').replace('\'', ' ').replace('"', ' ');
      str2 = Integer.toString(wifiInfo.getIpAddress());
      if (str2 == null) {
        str2 = "";
      } else {
        str2 = str2.trim();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append("[<!>]");
      stringBuilder.append(str3);
      stringBuilder.append("[<!>]");
      stringBuilder.append(str2);
      stringBuilder.append("[<!>]");
    } finally {
      paramContext = null;
    } 
    return (paramContext == null) ? "" : paramContext.trim();
  }
  
  public static String b(Context paramContext) {
    JSONArray jSONArray = new JSONArray();
    if (paramContext == null) {
      d.a("Context Instance is null...");
      return jSONArray.toString();
    } 
    try {
      List<?> list = ((WifiManager)paramContext.getSystemService("wifi")).getScanResults();
      if (list == null || list.size() <= 0)
        return jSONArray.toString(); 
      Collections.sort(list, new a());
      int i = 0;
      while (true)
        return (str == null) ? "[]" : str.trim(); 
    } finally {
      paramContext = null;
    } 
    return (paramContext == null) ? "[]" : paramContext.trim();
  }
  
  public static String c(Context paramContext) {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2 = null;
    try {
      StringBuilder stringBuilder;
      String str;
      LocationManager locationManager = (LocationManager)paramContext.getSystemService("location");
      Location location = locationManager.getLastKnownLocation("gps");
      if (location != null) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(location.getLongitude());
        stringBuilder.append(",");
        stringBuilder.append(location.getLatitude());
      } else {
        location = stringBuilder.getLastKnownLocation("network");
        if (location != null) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("");
          stringBuilder.append(location.getLongitude());
          stringBuilder.append(",");
          stringBuilder.append(location.getLatitude());
        } else {
          location = stringBuilder.getLastKnownLocation("passive");
          stringBuilder = stringBuilder2;
          if (location != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(location.getLongitude());
            stringBuilder.append(",");
            stringBuilder.append(location.getLatitude());
            str = stringBuilder.toString();
          } 
          if (str == null)
            return ""; 
        } 
      } 
    } finally {
      paramContext = null;
    } 
    if (stringBuilder1 == null)
      return ""; 
  }
  
  static class a implements Comparator<Object> {
    public final int compare(Object param1Object1, Object param1Object2) {
      int i = Math.abs(((ScanResult)param1Object1).level);
      int j = Math.abs(((ScanResult)param1Object2).level);
      return (i > j) ? 1 : ((i == j) ? 0 : -1);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\sys\ces\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */