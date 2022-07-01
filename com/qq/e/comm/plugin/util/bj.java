package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class bj {
  public static String a(Context paramContext) {
    String str2 = null;
    String str1 = str2;
    try {
      WifiManager wifiManager = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      if (wifiManager == null)
        return null; 
      str1 = str2;
      WifiInfo wifiInfo = wifiManager.getConnectionInfo();
      if (wifiInfo == null)
        return null; 
      str1 = str2;
      String str3 = wifiInfo.getSSID();
      str1 = str3;
      StringBuilder stringBuilder = new StringBuilder();
      str1 = str3;
      stringBuilder.append("WifiSsid=");
      str1 = str3;
      stringBuilder.append(str3);
      str1 = str3;
      GDTLogger.d(stringBuilder.toString());
      str1 = str3;
      String str4 = str3;
      if (Build.VERSION.SDK_INT >= 17) {
        str4 = str3;
        if (str3 != null) {
          str1 = str3;
          str4 = str3;
          if (str3.startsWith("\"")) {
            str1 = str3;
            str4 = str3;
            if (str3.endsWith("\"")) {
              str1 = str3;
              return str3.substring(1, str3.length() - 1);
            } 
          } 
        } 
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("get wifi ssid encountered exception: ");
      stringBuilder.append(exception.getMessage());
      GDTLogger.d(stringBuilder.toString());
      str2 = str1;
    } 
    return str2;
  }
  
  public static List<String> a(Context paramContext, int paramInt) {
    ScanResult scanResult1;
    boolean bool = x.c(paramContext);
    Context context = null;
    ScanResult scanResult2 = null;
    if (!bool)
      return null; 
    try {
      ArrayList<String> arrayList;
      List<?> list = ((WifiManager)paramContext.getSystemService("wifi")).getScanResults();
      paramContext = context;
      if (list != null) {
        if (list.size() == 0)
          return null; 
        arrayList = new ArrayList();
        try {
          Collections.sort(list, new a());
          Iterator<?> iterator = list.iterator();
          int i = 0;
          while (iterator.hasNext()) {
            scanResult2 = (ScanResult)iterator.next();
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(scanResult2.SSID);
            stringBuilder1.append("|");
            stringBuilder1.append(scanResult2.BSSID);
            stringBuilder1.append("|");
            stringBuilder1.append(scanResult2.level);
            GDTLogger.d(stringBuilder1.toString());
            String str = scanResult2.BSSID.replace(":", "").toUpperCase();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("|");
            stringBuilder2.append(scanResult2.level);
            arrayList.add(stringBuilder2.toString());
            int j = i + 1;
            i = j;
            if (j == paramInt)
              break; 
          } 
          return arrayList;
        } catch (Exception null) {}
      } else {
        return arrayList;
      } 
    } catch (Exception exception) {
      scanResult1 = scanResult2;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Get wifi scan result encounter exception: ");
    stringBuilder.append(exception.getMessage());
    GDTLogger.d(stringBuilder.toString());
    return (List<String>)scanResult1;
  }
  
  static class a implements Comparator {
    private a() {}
    
    public int compare(Object param1Object1, Object param1Object2) {
      param1Object1 = param1Object1;
      return ((ScanResult)param1Object2).level - ((ScanResult)param1Object1).level;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */