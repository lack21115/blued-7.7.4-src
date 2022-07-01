package com.qiniu.android.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public final class AndroidNetwork {
  public static String getHostIP() {
    Enumeration<InetAddress> enumeration3;
    Enumeration<InetAddress> enumeration2 = null;
    Enumeration<InetAddress> enumeration1 = null;
    try {
      Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
      label22: while (true) {
        enumeration2 = enumeration1;
        enumeration3 = enumeration1;
        if (enumeration.hasMoreElements()) {
          InetAddress inetAddress;
          enumeration2 = enumeration1;
          enumeration3 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
          while (true) {
            enumeration2 = enumeration1;
            if (enumeration3.hasMoreElements()) {
              enumeration2 = enumeration1;
              inetAddress = enumeration3.nextElement();
              enumeration2 = enumeration1;
              if (!inetAddress.isLinkLocalAddress()) {
                enumeration2 = enumeration1;
                if (!inetAddress.isLoopbackAddress()) {
                  enumeration2 = enumeration1;
                  break;
                } 
              } 
              continue;
            } 
            continue label22;
          } 
          String str = inetAddress.getHostAddress();
          continue;
        } 
        break;
      } 
    } catch (SocketException socketException) {
      socketException.printStackTrace();
      enumeration3 = enumeration2;
    } 
    return (String)enumeration3;
  }
  
  public static int getMobileDbm() {
    Context context = ContextGetter.applicationContext();
    TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
    int j = Build.VERSION.SDK_INT;
    byte b = -1;
    int i = b;
    if (j >= 17) {
      if (context.checkPermission("android.permission.ACCESS_COARSE_LOCATION", Process.myPid(), Process.myUid()) != 0)
        return -1; 
      if (context.checkPermission("android.permission.ACCESS_FINE_LOCATION", Process.myPid(), Process.myUid()) != 0)
        return -1; 
      List list = telephonyManager.getAllCellInfo();
      i = b;
      if (list != null) {
        Iterator<CellInfo> iterator = list.iterator();
        while (true) {
          i = b;
          if (iterator.hasNext()) {
            CellInfo cellInfo = iterator.next();
            if (cellInfo instanceof CellInfoGsm)
              return ((CellInfoGsm)cellInfo).getCellSignalStrength().getDbm(); 
            if (cellInfo instanceof CellInfoCdma)
              return ((CellInfoCdma)cellInfo).getCellSignalStrength().getDbm(); 
            if (cellInfo instanceof CellInfoLte)
              return ((CellInfoLte)cellInfo).getCellSignalStrength().getDbm(); 
            if (Build.VERSION.SDK_INT >= 18 && cellInfo instanceof CellInfoWcdma) {
              i = ((CellInfoWcdma)cellInfo).getCellSignalStrength().getDbm();
              break;
            } 
            continue;
          } 
          break;
        } 
      } 
    } 
    return i;
  }
  
  private static String getNetWorkClass(Context paramContext) {
    switch (((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType()) {
      default:
        return "none";
      case 13:
        return "4g";
      case 3:
      case 5:
      case 6:
      case 8:
      case 9:
      case 10:
      case 12:
      case 14:
      case 15:
        return "3g";
      case 1:
      case 2:
      case 4:
      case 7:
      case 11:
        break;
    } 
    return "2g";
  }
  
  public static boolean isNetWorkReady() {
    Context context = ContextGetter.applicationContext();
    if (context == null)
      return true; 
    ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
    try {
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      if (networkInfo != null) {
        boolean bool = networkInfo.isConnected();
        if (bool)
          return true; 
      } 
      return false;
    } catch (Exception exception) {
      return true;
    } 
  }
  
  public static String networkType(Context paramContext) {
    ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
    if (connectivityManager != null) {
      if (!networkInfo.isConnected())
        return "none"; 
      int i = connectivityManager.getActiveNetworkInfo().getType();
      if (i == 1)
        return "wifi"; 
      if (i == 0)
        return getNetWorkClass(paramContext); 
    } 
    return "none";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\androi\\utils\AndroidNetwork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */