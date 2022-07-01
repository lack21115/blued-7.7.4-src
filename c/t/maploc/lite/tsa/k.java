package c.t.maploc.lite.tsa;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.Locale;
import java.util.regex.Pattern;

public final class k implements Runnable {
  private static final Pattern f;
  
  private static final Pattern g;
  
  private static final Pattern h = Pattern.compile("[a-zA-Z0-9]{12}");
  
  public String a;
  
  public int b;
  
  public String c;
  
  public String d;
  
  public long e;
  
  private String i;
  
  private final j j;
  
  private String k;
  
  private String l;
  
  private String m;
  
  private int n = 0;
  
  private int o;
  
  private int p;
  
  k(j paramj) {
    this.j = paramj;
  }
  
  public static String a() {
    return "lite.1.1.1";
  }
  
  private static String a(String paramString) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(paramString.getBytes());
      byte[] arrayOfByte = messageDigest.digest();
      StringBuilder stringBuilder = new StringBuilder();
      int m = arrayOfByte.length;
      for (int i = 0; i < m; i++) {
        String str2 = Integer.toHexString(arrayOfByte[i] & 0xFF);
        String str1 = str2;
        if (str2.length() != 2)
          str1 = "0".concat(String.valueOf(str2)); 
        stringBuilder.append(str1);
        stringBuilder.append("");
      } 
      return stringBuilder.toString();
    } catch (Exception exception) {
      return paramString;
    } 
  }
  
  private static String a(String paramString, Pattern paramPattern) {
    return (paramString == null) ? "" : (!paramPattern.matcher(paramString).matches() ? "" : paramString);
  }
  
  public static String b() {
    return "200214";
  }
  
  public static String c() {
    return "sdk_lite";
  }
  
  public static String d() {
    return "0123456789ABCDEF";
  }
  
  private String j() {
    String str2 = "";
    String str1 = str2;
    try {
      SharedPreferences sharedPreferences = this.j.h;
      if (sharedPreferences != null) {
        str1 = str2;
        str2 = sharedPreferences.getString("mac_addr", "");
      } 
      str1 = str2;
      if (!TextUtils.isEmpty(str2))
        return str2; 
      str1 = str2;
      Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
      while (true) {
        str1 = str2;
        return str2;
      } 
    } finally {
      str2 = null;
    } 
  }
  
  public final void e() {
    (new Thread(this)).start();
  }
  
  public final String f() {
    return (TextUtils.isEmpty(this.k) || this.k.contains("0000")) ? "0123456789ABCDEF" : this.k;
  }
  
  public final String g() {
    return TextUtils.isEmpty(this.l) ? "0123456789ABCDEF" : this.l;
  }
  
  public final String h() {
    return TextUtils.isEmpty(this.m) ? "0123456789ABCDEF" : this.m;
  }
  
  public final String i() {
    if (this.i == null) {
      StringBuilder stringBuilder = new StringBuilder(100);
      stringBuilder.append(g());
      stringBuilder.append("_");
      stringBuilder.append(h());
      stringBuilder.append("_");
      stringBuilder.append(f());
      stringBuilder.append("_QQGeoLocation");
      this.i = a(stringBuilder.toString());
    } 
    return this.i;
  }
  
  public final void run() {
    try {
      Context context = this.j.a;
      this.d = context.getPackageName();
      try {
        PackageInfo packageInfo = this.j.d.getPackageInfo(this.d, 0);
        if (packageInfo != null) {
          this.b = packageInfo.versionCode;
          this.a = packageInfo.versionName;
        } 
      } finally {
        Exception exception;
      } 
      CharSequence charSequence = context.getApplicationInfo().loadLabel(this.j.d);
      if (charSequence != null) {
        charSequence = charSequence.toString();
      } else {
        charSequence = "unknown";
      } 
      this.c = (String)charSequence;
      this.c = this.c.replaceAll("[|_]", "");
      if (this.j.a()) {
        TelephonyManager telephonyManager = this.j.e;
        int[] arrayOfInt = new int[2];
        ab.a(telephonyManager, arrayOfInt);
        this.o = arrayOfInt[0];
        this.p = arrayOfInt[1];
        this.n = telephonyManager.getPhoneType();
        try {
          this.l = a(telephonyManager.getDeviceId(), f).toUpperCase(Locale.ENGLISH);
          this.m = a(telephonyManager.getSubscriberId(), g);
        } finally {}
      } 
      this.k = a(j().replaceAll(":", "").toUpperCase(Locale.ENGLISH), h);
      charSequence = new StringBuilder("os:[");
      charSequence.append(Build.MODEL);
      charSequence.append(",");
      charSequence.append(Build.VERSION.RELEASE);
      charSequence.append(",");
      charSequence.append(g());
      charSequence.append("],net:[");
      charSequence.append(this.o);
      charSequence.append(",");
      charSequence.append(this.p);
      charSequence.append(",");
      charSequence.append(this.j.d());
      charSequence.append("],app:[");
      charSequence.append(this.c);
      charSequence.append(",");
      charSequence.append(this.b);
      charSequence.append(",");
      charSequence.append(this.a);
      charSequence.append("],sdk:[lite.1.1.1,200214]");
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  static {
    Pattern pattern = Pattern.compile("[0-9a-zA-Z+-]*");
    f = pattern;
    g = pattern;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */