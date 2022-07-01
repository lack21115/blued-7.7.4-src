package com.huawei.hms.framework.common;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.android.os.BuildEx;
import com.huawei.android.telephony.ServiceStateEx;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NetworkUtil {
  private static final String TAG = "NetworkUtil";
  
  private static final int TYPE_WIFI_P2P = 13;
  
  public static String getDnsServerIps(Context paramContext) {
    return Arrays.toString((Object[])getDnsServerIpsFromConnectionManager(paramContext));
  }
  
  private static String[] getDnsServerIpsFromConnectionManager(Context paramContext) {
    StringBuilder stringBuilder;
    LinkedList<String> linkedList2 = new LinkedList();
    LinkedList<String> linkedList1 = linkedList2;
    if (Build.VERSION.SDK_INT >= 21) {
      linkedList1 = linkedList2;
      if (paramContext != null) {
        ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
        linkedList1 = linkedList2;
        if (connectivityManager != null)
          try {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            linkedList1 = linkedList2;
            if (networkInfo != null)
              linkedList1 = getDnsServerIpsFromLinkProperties(connectivityManager, networkInfo); 
          } catch (SecurityException securityException) {
            String str = TAG;
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("getActiveNetworkInfo failed, exception:");
            stringBuilder1.append(securityException.getClass().getSimpleName());
            Logger.i(str, stringBuilder1.toString());
            LinkedList<String> linkedList = linkedList2;
          } catch (RuntimeException runtimeException) {
            String str = TAG;
            stringBuilder = new StringBuilder();
          }  
      } 
    } 
    return stringBuilder.isEmpty() ? new String[0] : (String[])stringBuilder.toArray((Object[])new String[stringBuilder.size()]);
  }
  
  private static LinkedList<String> getDnsServerIpsFromLinkProperties(ConnectivityManager paramConnectivityManager, NetworkInfo paramNetworkInfo) {
    LinkedList<String> linkedList = new LinkedList();
    Network[] arrayOfNetwork = paramConnectivityManager.getAllNetworks();
    if (arrayOfNetwork != null) {
      if (arrayOfNetwork.length == 0)
        return linkedList; 
      int j = arrayOfNetwork.length;
      for (int i = 0; i < j; i++) {
        Network network = arrayOfNetwork[i];
        if (network != null) {
          NetworkInfo networkInfo = null;
          try {
            NetworkInfo networkInfo1 = paramConnectivityManager.getNetworkInfo(network);
            networkInfo = networkInfo1;
          } catch (NullPointerException nullPointerException) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("connectivityManager getNetworkInfo failed, exception:");
            stringBuilder.append(nullPointerException.getClass().getSimpleName());
            Logger.i(str, stringBuilder.toString());
          } 
          if (networkInfo != null && networkInfo.getType() == paramNetworkInfo.getType()) {
            LinkProperties linkProperties = paramConnectivityManager.getLinkProperties(network);
            if (linkProperties != null) {
              Iterator<InetAddress> iterator = linkProperties.getDnsServers().iterator();
              while (iterator.hasNext())
                linkedList.add(((InetAddress)iterator.next()).getHostAddress()); 
            } 
          } 
        } 
      } 
    } 
    return linkedList;
  }
  
  public static String getHost(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    try {
      URI uRI = new URI(paramString);
      if (uRI.getPort() == -1)
        return uRI.getHost(); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(uRI.getHost());
      stringBuilder.append(":");
      stringBuilder.append(uRI.getPort());
      return stringBuilder.toString();
    } catch (URISyntaxException uRISyntaxException) {
      Logger.w(TAG, uRISyntaxException.getClass().getSimpleName());
      return "";
    } 
  }
  
  private static int getHwNetworkType(Context paramContext) {
    boolean bool = EmuiUtil.isEMUI();
    byte b2 = 0;
    byte b3 = 0;
    byte b4 = 0;
    byte b1 = 0;
    if (!bool)
      return 0; 
    int i = b1;
    if (paramContext != null) {
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      i = b1;
      if (telephonyManager != null) {
        String str1;
        String str2;
        i = b1;
        int j = b2;
        int k = b3;
        int m = b4;
        try {
          if (BuildEx.VERSION.EMUI_SDK_INT >= 21) {
            j = b2;
            k = b3;
            m = b4;
            ServiceState serviceState = telephonyManager.getServiceState();
            i = b1;
            if (serviceState != null) {
              j = b2;
              k = b3;
              m = b4;
              i = ServiceStateEx.getConfigRadioTechnology(serviceState);
              j = i;
              k = i;
              m = i;
              str1 = TAG;
              j = i;
              k = i;
              m = i;
              StringBuilder stringBuilder = new StringBuilder();
              j = i;
              k = i;
              m = i;
              stringBuilder.append("getHwNetworkType return networkType is:");
              j = i;
              k = i;
              m = i;
              stringBuilder.append(i);
              j = i;
              k = i;
              m = i;
              Logger.i(str1, stringBuilder.toString());
              return i;
            } 
          } 
          return i;
        } catch (SecurityException securityException) {
          str2 = TAG;
          str1 = "requires permission maybe missing.";
        } catch (NoSuchMethodError noSuchMethodError) {
          str2 = TAG;
          str1 = "NoSuchMethodError occur in method getHwNetworkType.";
          j = k;
        } catch (NoClassDefFoundError noClassDefFoundError) {
          str2 = TAG;
          str1 = "NoClassDefFoundError occur in method getHwNetworkType.";
          j = m;
        } 
        Logger.w(str2, str1);
        i = j;
      } 
    } 
    return i;
  }
  
  public static int getMobileRsrp(Context paramContext) {
    if (paramContext != null) {
      Object object = paramContext.getSystemService("phone");
      boolean bool = object instanceof TelephonyManager;
      SignalStrength signalStrength = null;
      if (bool) {
        object = object;
      } else {
        object = null;
      } 
      if (object != null) {
        if (Build.VERSION.SDK_INT >= 28)
          signalStrength = object.createForSubscriptionId(SubscriptionManager.getDefaultDataSubscriptionId()).getSignalStrength(); 
        if (signalStrength != null) {
          String str1;
          String str2;
          try {
            return ((Integer)SignalStrength.class.getDeclaredMethod("getDbm", new Class[0]).invoke(signalStrength, new Object[0])).intValue();
          } catch (NoSuchMethodException noSuchMethodException) {
            str2 = TAG;
            str1 = "getDbm: function not found";
          } catch (IllegalAccessException illegalAccessException) {
            str2 = TAG;
            str1 = "getDbm: cannot access";
          } catch (InvocationTargetException invocationTargetException) {
            str2 = TAG;
            str1 = "getDbm: InvocationTargetException";
          } 
          Logger.i(str2, str1);
        } 
      } 
    } 
    return 0;
  }
  
  public static int getMobileRsrpLevel(Context paramContext) {
    if (paramContext != null) {
      Object object = paramContext.getSystemService("phone");
      boolean bool = object instanceof TelephonyManager;
      SignalStrength signalStrength = null;
      if (bool) {
        object = object;
      } else {
        object = null;
      } 
      if (object != null) {
        if (Build.VERSION.SDK_INT >= 28)
          signalStrength = object.getSignalStrength(); 
        if (signalStrength != null) {
          String str1;
          String str2;
          try {
            return ((Integer)SignalStrength.class.getDeclaredMethod("getLteLevel", new Class[0]).invoke(signalStrength, new Object[0])).intValue();
          } catch (NoSuchMethodException noSuchMethodException) {
            str2 = TAG;
            str1 = "getDbm: function not found";
          } catch (IllegalAccessException illegalAccessException) {
            str2 = TAG;
            str1 = "getDbm: cannot access";
          } catch (InvocationTargetException invocationTargetException) {
            str2 = TAG;
            str1 = "getDbm: InvocationTargetException";
          } 
          Logger.i(str2, str1);
        } 
      } 
    } 
    return 0;
  }
  
  public static NetworkInfo getNetworkInfo(Context paramContext) {
    if (paramContext != null) {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (connectivityManager != null)
        try {
          return connectivityManager.getActiveNetworkInfo();
        } catch (SecurityException securityException) {
          return null;
        } catch (RuntimeException runtimeException) {
          String str = TAG;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("getActiveNetworkInfo failed, exception:");
          stringBuilder.append(runtimeException.getClass().getSimpleName());
          Logger.i(str, stringBuilder.toString());
          return null;
        }  
    } 
    return null;
  }
  
  public static int getNetworkType(Context paramContext) {
    return (paramContext != null) ? getNetworkType(getNetworkInfo(paramContext), paramContext) : 0;
  }
  
  public static int getNetworkType(NetworkInfo paramNetworkInfo) {
    byte b;
    byte b1 = 3;
    if (paramNetworkInfo != null && paramNetworkInfo.isConnected()) {
      b = paramNetworkInfo.getType();
      if (1 == b || 13 == b)
        return 1; 
      if (b == 0) {
        int i = paramNetworkInfo.getSubtype();
        switch (i) {
          default:
            b = 0;
            break;
          case 13:
            b = 4;
            break;
          case 3:
          case 5:
          case 6:
          case 8:
          case 9:
          case 10:
          case 12:
          case 14:
          case 15:
            b = 3;
            break;
          case 1:
          case 2:
          case 4:
          case 7:
          case 11:
            b = 2;
            break;
        } 
        if (b == 0 && Build.VERSION.SDK_INT >= 25) {
          if (i != 16) {
            b = b1;
            if (i != 17)
              return 0; 
          } else {
            return 2;
          } 
        } else {
          return b;
        } 
      } else {
        return 0;
      } 
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static int getNetworkType(NetworkInfo paramNetworkInfo, Context paramContext) {
    byte b;
    byte b1 = 3;
    if (paramNetworkInfo != null && paramNetworkInfo.isConnected()) {
      b = paramNetworkInfo.getType();
      if (1 == b || 13 == b)
        return 1; 
      if (b == 0) {
        b = getHwNetworkType(paramContext);
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getHwNetworkType return is: ");
        stringBuilder.append(b);
        Logger.v(str, stringBuilder.toString());
        int i = b;
        if (b == 0)
          i = paramNetworkInfo.getSubtype(); 
        if (i != 20) {
          switch (i) {
            default:
              b = 0;
              break;
            case 13:
              b = 4;
              break;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
              b = 3;
              break;
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
              b = 2;
              break;
          } 
        } else {
          b = 5;
        } 
        if (b == 0 && Build.VERSION.SDK_INT >= 25) {
          if (i != 16) {
            b = b1;
            if (i != 17)
              return 0; 
          } else {
            return 2;
          } 
        } else {
          return b;
        } 
      } else {
        return 0;
      } 
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static String getSSIDByNetWorkId(Context paramContext) {
    return "";
  }
  
  public static String getWifiGatewayIp(Context paramContext) {
    if (paramContext != null) {
      Object object = paramContext.getApplicationContext().getSystemService("wifi");
      if (object instanceof WifiManager) {
        object = object;
      } else {
        object = null;
      } 
      if (object != null)
        try {
          object = object.getDhcpInfo();
          if (object != null) {
            int i = ((DhcpInfo)object).gateway;
            byte b1 = (byte)(i & 0xFF);
            byte b2 = (byte)(i >> 8 & 0xFF);
            byte b3 = (byte)(i >> 16 & 0xFF);
            byte b4 = (byte)(i >> 24 & 0xFF);
            try {
              return InetAddress.getByAddress(new byte[] { b1, b2, b3, b4 }).getHostAddress();
            } catch (Exception exception) {
              Logger.i(TAG, "getWifiGatewayIp: can not get ip addr");
              return " ";
            } 
          } 
        } catch (SecurityException securityException) {
          Logger.i(TAG, "getWifiGatewayIp did not has permission!");
        }  
    } 
    return " ";
  }
  
  public static int getWifiRssi(Context paramContext) {
    if (paramContext != null) {
      Object object = paramContext.getApplicationContext().getSystemService("wifi");
      if (object instanceof WifiManager) {
        object = object;
      } else {
        object = null;
      } 
      if (object != null)
        try {
          object = object.getConnectionInfo();
          if (object != null && object.getBSSID() != null)
            return object.getRssi(); 
        } catch (SecurityException securityException) {
          Logger.i(TAG, "getWifiRssiLevel did not has permission!");
        }  
    } 
    return 0;
  }
  
  public static int getWifiRssiLevel(Context paramContext) {
    if (paramContext != null) {
      Object object = paramContext.getApplicationContext().getSystemService("wifi");
      if (object instanceof WifiManager) {
        object = object;
      } else {
        object = null;
      } 
      if (object != null)
        try {
          object = object.getConnectionInfo();
          if (object != null && object.getBSSID() != null)
            return WifiManager.calculateSignalLevel(object.getRssi(), 5); 
        } catch (SecurityException securityException) {
          Logger.i(TAG, "getWifiRssiLevel did not has permission!");
        }  
    } 
    return 0;
  }
  
  public static boolean isForeground(Context paramContext) {
    if (paramContext != null) {
      ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
      if (activityManager != null) {
        List list = null;
        try {
          List list1 = activityManager.getRunningAppProcesses();
          list = list1;
        } catch (Exception exception) {
          Logger.w(TAG, "activityManager getRunningAppProcesses occur exception: ", exception);
        } 
        if (list != null)
          for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
            String str = runningAppProcessInfo.processName;
            if (str != null && str.equals(paramContext.getPackageName()) && runningAppProcessInfo.importance == 100) {
              Logger.v(TAG, "isForeground true");
              return true;
            } 
          }  
      } 
    } 
    return false;
  }
  
  public static boolean isInteractive(Context paramContext) {
    if (paramContext != null) {
      Object object = paramContext.getSystemService("power");
      if (object instanceof android.os.PowerManager) {
        object = object;
      } else {
        object = null;
      } 
      if (object != null && Build.VERSION.SDK_INT >= 20)
        return object.isInteractive(); 
    } 
    return false;
  }
  
  public static boolean isNetworkAvailable(Context paramContext) {
    if (paramContext != null) {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (connectivityManager != null)
        try {
          NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
          return (networkInfo != null) ? networkInfo.isConnected() : false;
        } catch (SecurityException securityException) {
          Logger.w(TAG, "networkIsConnected catch SecurityException");
          return true;
        }  
    } 
    return false;
  }
  
  public static NetworkInfo.DetailedState networkStatus(Context paramContext) {
    NetworkInfo.DetailedState detailedState = NetworkInfo.DetailedState.IDLE;
    if (paramContext != null) {
      Object object = paramContext.getSystemService("connectivity");
      if (object instanceof ConnectivityManager) {
        object = object;
      } else {
        object = null;
      } 
      if (object != null)
        try {
          object = object.getActiveNetworkInfo();
          if (object != null)
            return object.getDetailedState(); 
          object = TAG;
          Logger.i((String)object, "networkIsConnected netInfo is null!");
          return detailedState;
        } catch (SecurityException securityException) {
          return detailedState;
        }  
      String str = TAG;
      object = "networkStatus ConnectivityManager is null!";
      Logger.i(str, object);
      return detailedState;
    } 
    String str2 = TAG;
    String str1 = "networkStatus Context is null!";
    Logger.i(str2, str1);
    return detailedState;
  }
  
  public static final class NetType {
    public static final int TYPE_2G = 2;
    
    public static final int TYPE_3G = 3;
    
    public static final int TYPE_4G = 4;
    
    public static final int TYPE_5G = 5;
    
    public static final int TYPE_NO_NETWORK = -1;
    
    public static final int TYPE_UNKNOWN = 0;
    
    public static final int TYPE_WIFI = 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\NetworkUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */