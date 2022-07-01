package com.qq.e.comm.managers.status;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DeviceStatus {
  private String a;
  
  private String b;
  
  private int c;
  
  private int d;
  
  private int e;
  
  private String f;
  
  private String g;
  
  private String h;
  
  private String i;
  
  private String j;
  
  private volatile String k;
  
  private volatile String l;
  
  private volatile float m;
  
  public final String model;
  
  private Context n;
  
  public DeviceStatus(Context paramContext) {
    int i;
    this.model = Build.MODEL;
    this.n = paramContext.getApplicationContext();
    DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
    if (getVersion() > 3) {
      i = displayMetrics.densityDpi;
    } else {
      i = 120;
    } 
    this.e = i;
    if (getVersion() > 3) {
      i = a(displayMetrics.density, displayMetrics.widthPixels);
    } else {
      i = displayMetrics.widthPixels;
    } 
    this.c = i;
    if (getVersion() > 3) {
      i = a(displayMetrics.density, displayMetrics.heightPixels);
    } else {
      i = displayMetrics.heightPixels;
    } 
    this.d = i;
    a();
  }
  
  private int a(float paramFloat, int paramInt) {
    int i = paramInt;
    if (((this.n.getApplicationInfo()).flags & 0x2000) != 0)
      i = (int)(paramInt / paramFloat); 
    return i;
  }
  
  private void a() {
    try {
      StringBuilder stringBuilder;
      LocationManager locationManager = (LocationManager)this.n.getSystemService("location");
      if (locationManager == null)
        return; 
      Criteria criteria = new Criteria();
      criteria.setAccuracy(2);
      criteria.setAltitudeRequired(false);
      criteria.setBearingRequired(false);
      criteria.setCostAllowed(true);
      criteria.setPowerRequirement(1);
      String str = locationManager.getBestProvider(criteria, true);
      Location location = locationManager.getLastKnownLocation(str);
      if (location != null) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(location.getLatitude());
        this.k = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(location.getLongitude());
        this.l = stringBuilder.toString();
        return;
      } 
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public Carrier getCarrier() {
    String str = getOperator();
    if (str != null) {
      if (str.equals("46000") || str.equals("46002") || str.equals("46007") || str.equals("46020"))
        return Carrier.CMCC; 
      if (str.equals("46001") || str.equals("46006"))
        return Carrier.UNICOM; 
      if (str.equals("46003") || str.equals("46005"))
        return Carrier.TELECOM; 
    } 
    return Carrier.UNKNOWN;
  }
  
  public String getDataNet() {
    String str;
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)this.n.getSystemService("connectivity")).getActiveNetworkInfo();
    } catch (Exception exception) {
      exception = null;
    } 
    if (exception == null)
      return null; 
    int i = exception.getType();
    if (i != 0) {
      if (i != 1) {
        str = "unknow";
      } else {
        str = "wi";
      } 
    } else {
      str = "ed";
    } 
    this.i = str;
    return this.i;
  }
  
  public int getDeviceDensity() {
    return this.e;
  }
  
  public int getDeviceHeight() {
    return this.d;
  }
  
  public int getDeviceWidth() {
    return this.c;
  }
  
  public String getDid() {
    String str = getPlainDid();
    return StringUtil.isEmpty(str) ? "" : Md5Util.encode(str.toLowerCase());
  }
  
  public Map<String, String> getLacAndCeilId() {
    String str = getOperator();
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (this.n.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0)
      return (Map)hashMap; 
    if (!StringUtil.isEmpty(str) && !"null".equalsIgnoreCase(str))
      int i = 0; 
    return (Map)hashMap;
  }
  
  public String getLanguage() {
    if (this.b == null) {
      this.b = Locale.getDefault().getLanguage().toLowerCase(Locale.US);
      if (this.b.length() == 0)
        this.b = "en"; 
    } 
    return this.b;
  }
  
  public String getLat() {
    return this.k;
  }
  
  public String getLng() {
    return this.l;
  }
  
  public float getLocationAccuracy() {
    return this.m;
  }
  
  public NetworkType getNetworkType() {
    boolean bool;
    String str = getDataNet();
    if (str != null && str.equals("wi"))
      return NetworkType.WIFI; 
    try {
      bool = Integer.parseInt(getPhoneNet());
    } catch (NumberFormatException numberFormatException) {
      bool = false;
    } 
    switch (bool) {
      default:
        return NetworkType.UNKNOWN;
      case true:
      case true:
      case true:
      case true:
      case true:
        return NetworkType.NET_4G;
      case true:
      case true:
      case true:
      case true:
      case true:
      case true:
      case true:
      case true:
      case true:
      case true:
      case true:
      case true:
        return NetworkType.NET_3G;
      case true:
      case true:
      case true:
        break;
    } 
    return NetworkType.NET_2G;
  }
  
  public String getOS() {
    return "android";
  }
  
  public String getOperator() {
    try {
      this.g = ((TelephonyManager)this.n.getSystemService("phone")).getNetworkOperator();
    } catch (Exception exception) {}
    return this.g;
  }
  
  public String getPhoneNet() {
    Context context = GDTADManager.getInstance().getAppContext();
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
      if (networkInfo != null && networkInfo.getType() == 0) {
        int j = ((TelephonyManager)context.getSystemService("phone")).getNetworkType();
        int i = j;
        if (j == 0)
          i = networkInfo.getSubtype(); 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        this.h = stringBuilder.toString();
      } 
    } catch (Exception exception) {}
    return this.h;
  }
  
  public String getPlainDid() {
    if (StringUtil.isEmpty(this.j)) {
      if (this.n.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
        if (GDTADManager.getInstance().getSM().getInteger("imeion", 1) != 1)
          return ""; 
        try {
          this.j = ((TelephonyManager)this.n.getSystemService("phone")).getDeviceId();
        } catch (Exception exception) {
          StringBuilder stringBuilder = new StringBuilder("Get imei encounter error: ");
          stringBuilder.append(exception.getMessage());
          GDTLogger.d(stringBuilder.toString());
        } 
        return StringUtil.isEmpty(this.j) ? "" : this.j;
      } 
      return "";
    } 
    return this.j;
  }
  
  public String getScreenOrientation() {
    String str;
    if ((this.n.getResources().getConfiguration()).orientation == 2) {
      str = "l";
    } else {
      str = "p";
    } 
    this.f = str;
    return this.f;
  }
  
  public String getUid() {
    int i = GDTADManager.getInstance().getSM().getInteger("adidon", 1);
    String str1 = "";
    String str2 = str1;
    if (i == 1) {
      if (this.a == null) {
        str2 = Settings.Secure.getString(this.n.getContentResolver(), "android_id");
        if (str2 != null)
          str1 = Md5Util.encode(str2); 
        this.a = str1;
      } 
      str2 = this.a;
    } 
    return str2;
  }
  
  public int getVersion() {
    try {
      return Build.VERSION.SDK_INT;
    } catch (Exception exception) {
      return 3;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\managers\status\DeviceStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */