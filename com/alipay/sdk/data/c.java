package com.alipay.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.mobilesecuritysdk.face.SecurityClientMobile;
import com.alipay.sdk.app.i;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.tid.b;
import com.alipay.sdk.util.a;
import com.alipay.sdk.util.n;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class c {
  private static final String a = "virtualImeiAndImsi";
  
  private static final String b = "virtual_imei";
  
  private static final String c = "virtual_imsi";
  
  private static volatile c d;
  
  private String e;
  
  private String f = "sdk-and-lite";
  
  private String g;
  
  private c() {
    String str = i.a();
    if (!i.b()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.f);
      stringBuilder.append('_');
      stringBuilder.append(str);
      this.f = stringBuilder.toString();
    } 
  }
  
  public static String a(Context paramContext) {
    if (paramContext != null)
      try {
        StringBuilder stringBuilder = new StringBuilder();
        String str = paramContext.getPackageName();
        PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(str, 0);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(";");
        stringBuilder.append(packageInfo.versionCode);
        stringBuilder.append(")");
        return stringBuilder.toString();
      } catch (Exception exception) {} 
    return "";
  }
  
  public static void a(String paramString) {
    // Byte code:
    //   0: ldc com/alipay/sdk/data/c
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   7: istore_1
    //   8: iload_1
    //   9: ifeq -> 16
    //   12: ldc com/alipay/sdk/data/c
    //   14: monitorexit
    //   15: return
    //   16: invokestatic a : ()Lcom/alipay/sdk/sys/b;
    //   19: invokevirtual b : ()Landroid/content/Context;
    //   22: invokestatic getDefaultSharedPreferences : (Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   25: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   30: ldc 'trideskey'
    //   32: aload_0
    //   33: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   38: invokeinterface apply : ()V
    //   43: aload_0
    //   44: putstatic com/alipay/sdk/cons/a.e : Ljava/lang/String;
    //   47: ldc com/alipay/sdk/data/c
    //   49: monitorexit
    //   50: return
    //   51: astore_0
    //   52: ldc com/alipay/sdk/data/c
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   3	8	51	finally
    //   16	47	51	finally
  }
  
  public static c b() {
    // Byte code:
    //   0: ldc com/alipay/sdk/data/c
    //   2: monitorenter
    //   3: getstatic com/alipay/sdk/data/c.d : Lcom/alipay/sdk/data/c;
    //   6: ifnonnull -> 19
    //   9: new com/alipay/sdk/data/c
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/alipay/sdk/data/c.d : Lcom/alipay/sdk/data/c;
    //   19: getstatic com/alipay/sdk/data/c.d : Lcom/alipay/sdk/data/c;
    //   22: astore_0
    //   23: ldc com/alipay/sdk/data/c
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/alipay/sdk/data/c
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  private static String b(Context paramContext) {
    return Float.toString((new TextView(paramContext)).getTextSize());
  }
  
  private static String b(a parama, Context paramContext, HashMap<String, String> paramHashMap) {
    StringBuilder stringBuilder;
    String str;
    try {
      str = SecurityClientMobile.GetApdid(paramContext, paramHashMap);
    } finally {
      paramContext = null;
      com.alipay.sdk.util.c.a((Throwable)paramContext);
      a.a(parama, "third", "GetApdidEx", (Throwable)paramContext);
    } 
    stringBuilder.append(str);
    com.alipay.sdk.util.c.a("mspl", stringBuilder.toString());
    return str;
  }
  
  public static String c() {
    Context context = b.a().b();
    SharedPreferences sharedPreferences = context.getSharedPreferences("virtualImeiAndImsi", 0);
    String str2 = sharedPreferences.getString("virtual_imei", null);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      if (TextUtils.isEmpty(b.a(context).a())) {
        str1 = g();
      } else {
        str1 = a.a(context).b();
      } 
      sharedPreferences.edit().putString("virtual_imei", str1).apply();
    } 
    return str1;
  }
  
  private static String c(Context paramContext) {
    WifiInfo wifiInfo = ((WifiManager)paramContext.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
    return (wifiInfo != null) ? wifiInfo.getSSID() : "-1";
  }
  
  private static String c(a parama, Context paramContext, HashMap<String, String> paramHashMap) {
    Future<?> future = Executors.newFixedThreadPool(2).submit(new d(parama, paramContext, paramHashMap));
    try {
      return (String)future.get(3000L, TimeUnit.MILLISECONDS);
    } finally {
      future = null;
      a.a(parama, "third", "GetApdidTimeout", (Throwable)future);
    } 
  }
  
  public static String d() {
    Context context = b.a().b();
    SharedPreferences sharedPreferences = context.getSharedPreferences("virtualImeiAndImsi", 0);
    String str2 = sharedPreferences.getString("virtual_imsi", null);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      if (TextUtils.isEmpty(b.a(context).a())) {
        str1 = b.a().e();
        if (TextUtils.isEmpty(str1)) {
          str1 = g();
        } else {
          str1 = str1.substring(3, 18);
        } 
      } else {
        str1 = a.a(context).a();
      } 
      sharedPreferences.edit().putString("virtual_imsi", str1).apply();
    } 
    return str1;
  }
  
  private static String d(Context paramContext) {
    WifiInfo wifiInfo = ((WifiManager)paramContext.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
    return (wifiInfo != null) ? wifiInfo.getBSSID() : "00";
  }
  
  private static String e() {
    return "1";
  }
  
  private static String f() {
    return "-1;-1";
  }
  
  private static String g() {
    String str = Long.toHexString(System.currentTimeMillis());
    Random random = new Random();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(random.nextInt(9000) + 1000);
    return stringBuilder.toString();
  }
  
  public String a() {
    return this.g;
  }
  
  public String a(a parama, b paramb) {
    Context context = b.a().b();
    a a1 = a.a(context);
    if (TextUtils.isEmpty(this.e)) {
      String str13 = n.b();
      String str14 = n.c();
      String str15 = n.d(context);
      String str16 = n.f(context);
      String str17 = n.e(context);
      String str18 = b(context);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Msp/15.7.4");
      stringBuilder1.append(" (");
      stringBuilder1.append(str13);
      stringBuilder1.append(";");
      stringBuilder1.append(str14);
      stringBuilder1.append(";");
      stringBuilder1.append(str15);
      stringBuilder1.append(";");
      stringBuilder1.append(str16);
      stringBuilder1.append(";");
      stringBuilder1.append(str17);
      stringBuilder1.append(";");
      stringBuilder1.append(str18);
      this.e = stringBuilder1.toString();
    } 
    String str1 = a.b(context).b();
    String str2 = n.g(context);
    String str3 = e();
    String str4 = a1.a();
    String str5 = a1.b();
    String str6 = d();
    String str7 = c();
    if (paramb != null)
      this.g = paramb.b(); 
    String str8 = Build.MANUFACTURER.replace(";", " ");
    String str9 = Build.MODEL.replace(";", " ");
    boolean bool = b.d();
    String str10 = a1.d();
    String str11 = c(context);
    String str12 = d(context);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.e);
    stringBuilder.append(";");
    stringBuilder.append(str1);
    stringBuilder.append(";");
    stringBuilder.append(str2);
    stringBuilder.append(";");
    stringBuilder.append(str3);
    stringBuilder.append(";");
    stringBuilder.append(str4);
    stringBuilder.append(";");
    stringBuilder.append(str5);
    stringBuilder.append(";");
    stringBuilder.append(this.g);
    stringBuilder.append(";");
    stringBuilder.append(str8);
    stringBuilder.append(";");
    stringBuilder.append(str9);
    stringBuilder.append(";");
    stringBuilder.append(bool);
    stringBuilder.append(";");
    stringBuilder.append(str10);
    stringBuilder.append(";");
    stringBuilder.append(f());
    stringBuilder.append(";");
    stringBuilder.append(this.f);
    stringBuilder.append(";");
    stringBuilder.append(str6);
    stringBuilder.append(";");
    stringBuilder.append(str7);
    stringBuilder.append(";");
    stringBuilder.append(str11);
    stringBuilder.append(";");
    stringBuilder.append(str12);
    if (paramb != null) {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("tid", b.a(context).a());
      hashMap.put("utdid", b.a().e());
      String str = c(parama, context, (HashMap)hashMap);
      if (!TextUtils.isEmpty(str)) {
        stringBuilder.append(";");
        stringBuilder.append(str);
      } 
    } 
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\data\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */