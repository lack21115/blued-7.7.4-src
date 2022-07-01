package com.geetest.onelogin.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.geetest.onelogin.j.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class d implements Serializable {
  private boolean hasIntent;
  
  private List<a> networkList = new ArrayList<a>();
  
  private int networkType;
  
  private String nt;
  
  private String proxyHost;
  
  private String proxyPort;
  
  private int sdkInt = Build.VERSION.SDK_INT;
  
  private int simState;
  
  private String ss;
  
  public d(Context paramContext) {
    try {
      a(paramContext);
    } finally {
      Exception exception;
    } 
    try {
      b(paramContext);
    } finally {
      paramContext = null;
    } 
  }
  
  private static final String a(int paramInt) {
    switch (paramInt) {
      default:
        return "NULL";
      case 11:
        return "PRESENT";
      case 10:
        return "LOADED";
      case 9:
        return "CARD_RESTRICTED";
      case 8:
        return "CARD_IO_ERROR";
      case 7:
        return "PERM_DISABLED";
      case 6:
        return "NOT_READY";
      case 5:
        return "READY";
      case 4:
        return "NETWORK_LOCKED";
      case 3:
        return "PUK_REQUIRED";
      case 2:
        return "PIN_REQUIRED";
      case 1:
        return "ABSENT";
      case 0:
        break;
    } 
    return "UNKNOWN";
  }
  
  private void a() {
    this.proxyHost = System.getProperty("http.proxyHost");
    this.proxyPort = System.getProperty("http.proxyPort");
  }
  
  private void a(Context paramContext) {
    boolean bool1;
    boolean bool2;
    ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (connectivityManager == null)
      return; 
    this.hasIntent = b.a(connectivityManager);
    if (Build.VERSION.SDK_INT >= 21) {
      Network[] arrayOfNetwork = connectivityManager.getAllNetworks();
      int j = arrayOfNetwork.length;
      int i = 0;
      boolean bool4 = false;
      boolean bool3 = false;
      while (true) {
        bool2 = bool4;
        bool1 = bool3;
        if (i < j) {
          Network network = arrayOfNetwork[i];
          NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
          bool1 = bool4;
          if (!bool4) {
            bool1 = bool4;
            if (networkInfo.getType() == 1)
              bool1 = true; 
          } 
          bool2 = bool3;
          if (!bool3) {
            bool2 = bool3;
            if (networkInfo.getType() == 0)
              bool2 = true; 
          } 
          NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(networkCapabilities.hasCapability(16));
          stringBuilder.append("");
          a a = new a(networkInfo, stringBuilder.toString());
          this.networkList.add(a);
          i++;
          bool4 = bool1;
          bool3 = bool2;
          continue;
        } 
        break;
      } 
    } else {
      NetworkInfo[] arrayOfNetworkInfo = connectivityManager.getAllNetworkInfo();
      if (arrayOfNetworkInfo != null) {
        int j = arrayOfNetworkInfo.length;
        int i = 0;
        boolean bool4 = false;
        boolean bool3 = false;
        while (true) {
          bool2 = bool4;
          bool1 = bool3;
          if (i < j) {
            NetworkInfo networkInfo = arrayOfNetworkInfo[i];
            bool1 = bool4;
            if (!bool4) {
              bool1 = bool4;
              if (networkInfo.getType() == 1)
                bool1 = true; 
            } 
            bool2 = bool3;
            if (!bool3) {
              bool2 = bool3;
              if (networkInfo.getType() == 0)
                bool2 = true; 
            } 
            a a = new a(networkInfo, "UNKNOWN");
            this.networkList.add(a);
            i++;
            bool4 = bool1;
            bool3 = bool2;
            continue;
          } 
          break;
        } 
      } else {
        bool2 = false;
        bool1 = false;
      } 
    } 
    if (!bool2) {
      a a = new a(connectivityManager.getNetworkInfo(1), "UNKNOWN");
      this.networkList.add(a);
    } 
    if (!bool1) {
      a a = new a(connectivityManager.getNetworkInfo(0), "UNKNOWN");
      this.networkList.add(a);
    } 
  }
  
  private static final String b(int paramInt) {
    switch (paramInt) {
      default:
        return "NULL";
      case 15:
        return "3G,HSPAP";
      case 14:
        return "3G,EHRPD";
      case 13:
        return "4G,LTE";
      case 12:
        return "3G,EVDO_B";
      case 11:
        return "2G,IDEN";
      case 10:
        return "3G,HSPA";
      case 9:
        return "3G,HSUPA";
      case 8:
        return "3G,HSDPA";
      case 7:
        return "2G,1xRTT";
      case 6:
        return "3G,EVDO_A";
      case 5:
        return "3G,EVDO_0";
      case 4:
        return "2G,CDMA";
      case 3:
        return "3G,UMTS";
      case 2:
        return "2G,EDGE";
      case 1:
        break;
    } 
    return "2G,GPRS";
  }
  
  private void b(Context paramContext) {
    TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (telephonyManager == null)
      return; 
    this.simState = telephonyManager.getSimState();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.simState);
    stringBuilder2.append(",");
    stringBuilder2.append(a(this.simState));
    this.ss = stringBuilder2.toString();
    this.networkType = telephonyManager.getNetworkType();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.networkType);
    stringBuilder1.append(",");
    stringBuilder1.append(b(this.networkType));
    this.nt = stringBuilder1.toString();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{si=");
    stringBuilder.append(this.sdkInt);
    stringBuilder.append(", nl=");
    stringBuilder.append(Arrays.toString(this.networkList.toArray()));
    stringBuilder.append(", nt=");
    stringBuilder.append(this.nt);
    stringBuilder.append(", ss=");
    stringBuilder.append(this.ss);
    stringBuilder.append(", hi=");
    stringBuilder.append(this.hasIntent);
    stringBuilder.append(", ph='");
    stringBuilder.append(this.proxyHost);
    stringBuilder.append('\'');
    stringBuilder.append(", pp='");
    stringBuilder.append(this.proxyPort);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  class a implements Serializable {
    boolean available;
    
    String capability;
    
    String extra;
    
    String state;
    
    String subType;
    
    String type;
    
    public a(NetworkInfo param1NetworkInfo, String param1String) {
      if (param1NetworkInfo == null) {
        this.type = "(none)";
        this.subType = "(none)";
        this.state = "UNKNOWN";
        this.available = false;
        this.extra = "(none)";
        this.capability = "UNKNOWN";
        return;
      } 
      try {
        this.type = param1NetworkInfo.getTypeName();
        this.subType = param1NetworkInfo.getSubtypeName();
        this.state = param1NetworkInfo.getState().toString();
        this.available = param1NetworkInfo.isAvailable();
        this.extra = param1NetworkInfo.getExtraInfo();
        this.capability = param1String;
        return;
      } catch (Exception exception) {
        return;
      } 
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("{ntn='");
      stringBuilder.append(this.type);
      stringBuilder.append('\'');
      stringBuilder.append(", nst='");
      stringBuilder.append(this.subType);
      stringBuilder.append('\'');
      stringBuilder.append(", ns='");
      stringBuilder.append(this.state);
      stringBuilder.append('\'');
      stringBuilder.append(", na=");
      stringBuilder.append(this.available);
      stringBuilder.append(", ne='");
      stringBuilder.append(this.extra);
      stringBuilder.append('\'');
      stringBuilder.append(", nc='");
      stringBuilder.append(this.capability);
      stringBuilder.append('\'');
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */