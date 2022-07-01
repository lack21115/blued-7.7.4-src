package org.chromium.net;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.io.FileDescriptor;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLConnection;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.List;
import org.chromium.base.BuildInfo;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.CalledByNativeUnchecked;

class AndroidNetworkLibrary {
  @CalledByNativeUnchecked
  public static void addTestRootCertificate(byte[] paramArrayOfbyte) {
    X509Util.addTestRootCertificate(paramArrayOfbyte);
  }
  
  @CalledByNativeUnchecked
  public static void clearTestRootCertificates() {
    X509Util.clearTestRootCertificates();
  }
  
  @TargetApi(23)
  @CalledByNative
  private static byte[][] getDnsServers() {
    ConnectivityManager connectivityManager = (ConnectivityManager)ContextUtils.sApplicationContext.getSystemService("connectivity");
    int i = 0;
    if (connectivityManager == null)
      return (byte[][])Array.newInstance(byte.class, new int[] { 0, 0 }); 
    Network network = connectivityManager.getActiveNetwork();
    if (network == null)
      return (byte[][])Array.newInstance(byte.class, new int[] { 0, 0 }); 
    LinkProperties linkProperties = connectivityManager.getLinkProperties(network);
    if (linkProperties == null)
      return (byte[][])Array.newInstance(byte.class, new int[] { 0, 0 }); 
    if (BuildInfo.isAtLeastP())
      try {
        if (((Boolean)linkProperties.getClass().getMethod("isPrivateDnsActive", new Class[0]).invoke(linkProperties, new Object[0])).booleanValue())
          return (byte[][])Array.newInstance(byte.class, new int[] { 1, 1 }); 
      } catch (Exception exception) {
        Log.e("AndroidNetworkLibrary", "Can not call LinkProperties.isPrivateDnsActive():", exception);
      }  
    List<InetAddress> list = linkProperties.getDnsServers();
    byte[][] arrayOfByte = new byte[list.size()][];
    while (i < list.size()) {
      arrayOfByte[i] = ((InetAddress)list.get(i)).getAddress();
      i++;
    } 
    return arrayOfByte;
  }
  
  @TargetApi(23)
  @CalledByNative
  private static boolean getIsCaptivePortal() {
    if (Build.VERSION.SDK_INT < 23)
      return false; 
    ConnectivityManager connectivityManager = (ConnectivityManager)ContextUtils.sApplicationContext.getSystemService("connectivity");
    if (connectivityManager == null)
      return false; 
    Network network = connectivityManager.getActiveNetwork();
    if (network == null)
      return false; 
    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
    return (networkCapabilities != null && networkCapabilities.hasCapability(17));
  }
  
  @CalledByNative
  private static boolean getIsRoaming() {
    NetworkInfo networkInfo = ((ConnectivityManager)ContextUtils.sApplicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (networkInfo == null) ? false : networkInfo.isRoaming();
  }
  
  @CalledByNative
  public static String getMimeTypeFromExtension(String paramString) {
    StringBuilder stringBuilder = new StringBuilder("foo.");
    stringBuilder.append(paramString);
    return URLConnection.guessContentTypeFromName(stringBuilder.toString());
  }
  
  @CalledByNative
  private static String getNetworkCountryIso() {
    TelephonyManager telephonyManager = (TelephonyManager)ContextUtils.sApplicationContext.getSystemService("phone");
    return (telephonyManager == null) ? "" : telephonyManager.getNetworkCountryIso();
  }
  
  @CalledByNative
  private static String getNetworkOperator() {
    TelephonyManager telephonyManager = (TelephonyManager)ContextUtils.sApplicationContext.getSystemService("phone");
    return (telephonyManager == null) ? "" : telephonyManager.getNetworkOperator();
  }
  
  @CalledByNative
  private static String getSimOperator() {
    TelephonyManager telephonyManager = (TelephonyManager)ContextUtils.sApplicationContext.getSystemService("phone");
    return (telephonyManager == null) ? "" : telephonyManager.getSimOperator();
  }
  
  @CalledByNative
  public static String getWifiSSID() {
    Intent intent = ContextUtils.sApplicationContext.registerReceiver(null, new IntentFilter("android.net.wifi.STATE_CHANGE"));
    if (intent != null) {
      WifiInfo wifiInfo = (WifiInfo)intent.getParcelableExtra("wifiInfo");
      if (wifiInfo != null) {
        String str = wifiInfo.getSSID();
        if (str != null && !str.equals("<unknown ssid>"))
          return str; 
      } 
    } 
    return "";
  }
  
  @CalledByNative
  public static boolean haveOnlyLoopbackAddresses() {
    try {
      Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
      if (enumeration == null)
        return false; 
      while (enumeration.hasMoreElements()) {
        NetworkInterface networkInterface = enumeration.nextElement();
        try {
          if (networkInterface.isUp()) {
            boolean bool = networkInterface.isLoopback();
            if (!bool)
              return false; 
          } 
        } catch (SocketException socketException) {}
      } 
      return true;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("could not get network interfaces: ");
      stringBuilder.append(exception);
      Log.w("AndroidNetworkLibrary", stringBuilder.toString());
      return false;
    } 
  }
  
  @CalledByNative
  private static boolean isCleartextPermitted(String paramString) {
    try {
      AndroidNetworkLibrary$NetworkSecurityPolicyProxy.getInstance();
      return (Build.VERSION.SDK_INT < 24) ? AndroidNetworkLibrary$NetworkSecurityPolicyProxy.isCleartextTrafficPermitted() : NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(paramString);
    } catch (IllegalArgumentException illegalArgumentException) {
      AndroidNetworkLibrary$NetworkSecurityPolicyProxy.getInstance();
      return AndroidNetworkLibrary$NetworkSecurityPolicyProxy.isCleartextTrafficPermitted();
    } 
  }
  
  @CalledByNative
  private static void tagSocket(int paramInt1, int paramInt2, int paramInt3) {
    ParcelFileDescriptor parcelFileDescriptor;
    FileDescriptor fileDescriptor;
    int i = TrafficStats.getThreadStatsTag();
    if (paramInt3 != i)
      TrafficStats.setThreadStatsTag(paramInt3); 
    if (paramInt2 != -1)
      ThreadStatsUid.set(paramInt2); 
    if (Build.VERSION.SDK_INT < 23) {
      parcelFileDescriptor = null;
      fileDescriptor = AndroidNetworkLibrary$SetFileDescriptor.createWithFd(paramInt1);
    } else {
      parcelFileDescriptor = ParcelFileDescriptor.adoptFd(paramInt1);
      fileDescriptor = parcelFileDescriptor.getFileDescriptor();
    } 
    AndroidNetworkLibrary$SocketFd androidNetworkLibrary$SocketFd = new AndroidNetworkLibrary$SocketFd(fileDescriptor);
    TrafficStats.tagSocket(androidNetworkLibrary$SocketFd);
    androidNetworkLibrary$SocketFd.close();
    if (parcelFileDescriptor != null)
      parcelFileDescriptor.detachFd(); 
    if (paramInt3 != i)
      TrafficStats.setThreadStatsTag(i); 
    if (paramInt2 != -1)
      ThreadStatsUid.clear(); 
  }
  
  @CalledByNative
  public static AndroidCertVerifyResult verifyServerCertificates(byte[][] paramArrayOfbyte, String paramString1, String paramString2) {
    try {
      return X509Util.verifyServerCertificates(paramArrayOfbyte, paramString1, paramString2);
    } catch (KeyStoreException keyStoreException) {
      return new AndroidCertVerifyResult(-1);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      return new AndroidCertVerifyResult(-1);
    } catch (IllegalArgumentException illegalArgumentException) {
      return new AndroidCertVerifyResult(-1);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\AndroidNetworkLibrary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */