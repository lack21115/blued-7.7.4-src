package com.datavisor.vangogh.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.datavisor.vangogh.f.a;
import com.datavisor.vangogh.f.d;
import com.datavisor.vangogh.f.f;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Iterator;
import org.json.JSONArray;

public class c {
  private static c a = new c();
  
  public static c a() {
    return a;
  }
  
  private String a(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt & 0xFF);
    stringBuilder.append(".");
    stringBuilder.append(paramInt >> 8 & 0xFF);
    stringBuilder.append(".");
    stringBuilder.append(paramInt >> 16 & 0xFF);
    stringBuilder.append(".");
    stringBuilder.append(paramInt >> 24 & 0xFF);
    return stringBuilder.toString();
  }
  
  private String b(int paramInt) {
    if (paramInt > 32)
      return ""; 
    int[] arrayOfInt = new int[4];
    for (int i = 0; i < 4; i++)
      arrayOfInt[3 - i] = -1 << 32 - paramInt >> i * 8 & 0xFF; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(arrayOfInt[0]);
    String str = stringBuilder.toString();
    for (paramInt = 1; paramInt < 4; paramInt++) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append(".");
      stringBuilder1.append(arrayOfInt[paramInt]);
      str = stringBuilder1.toString();
    } 
    return str;
  }
  
  public String a(Context paramContext) {
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      return null;
    } finally {
      paramContext = null;
    } 
  }
  
  public String b() {
    try {
      JSONArray jSONArray = new JSONArray();
      return jSONArray.toString();
    } finally {
      Exception exception = null;
      d.a(exception);
    } 
  }
  
  public String b(Context paramContext) {
    String str = a(paramContext);
    return a.b(str) ? str : "empty";
  }
  
  public String c() {
    // Byte code:
    //   0: invokestatic getNetworkInterfaces : ()Ljava/util/Enumeration;
    //   3: invokestatic list : (Ljava/util/Enumeration;)Ljava/util/ArrayList;
    //   6: invokeinterface iterator : ()Ljava/util/Iterator;
    //   11: astore #5
    //   13: aload #5
    //   15: invokeinterface hasNext : ()Z
    //   20: ifeq -> 220
    //   23: aload #5
    //   25: invokeinterface next : ()Ljava/lang/Object;
    //   30: checkcast java/net/NetworkInterface
    //   33: astore #6
    //   35: aload #6
    //   37: ifnull -> 13
    //   40: aload #6
    //   42: invokevirtual getName : ()Ljava/lang/String;
    //   45: invokestatic b : (Ljava/lang/String;)Z
    //   48: ifeq -> 13
    //   51: aload #6
    //   53: invokevirtual getName : ()Ljava/lang/String;
    //   56: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   59: ldc 'K8yOmQ=='
    //   61: invokestatic convert : (Ljava/lang/String;)Ljava/lang/String;
    //   64: invokevirtual equals : (Ljava/lang/Object;)Z
    //   67: ifeq -> 13
    //   70: aload #6
    //   72: invokevirtual getHardwareAddress : ()[B
    //   75: astore #5
    //   77: aload #5
    //   79: ifnull -> 220
    //   82: new java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial <init> : ()V
    //   89: astore #6
    //   91: aload #5
    //   93: arraylength
    //   94: istore_2
    //   95: iconst_0
    //   96: istore_1
    //   97: iload_1
    //   98: iload_2
    //   99: if_icmpge -> 140
    //   102: aload #5
    //   104: iload_1
    //   105: baload
    //   106: istore_3
    //   107: aload #6
    //   109: ldc '%02X:'
    //   111: iconst_1
    //   112: anewarray java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: iload_3
    //   118: sipush #255
    //   121: iand
    //   122: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   125: aastore
    //   126: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   129: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: iload_1
    //   134: iconst_1
    //   135: iadd
    //   136: istore_1
    //   137: goto -> 97
    //   140: aload #6
    //   142: invokevirtual length : ()I
    //   145: ifle -> 161
    //   148: aload #6
    //   150: aload #6
    //   152: invokevirtual length : ()I
    //   155: iconst_1
    //   156: isub
    //   157: invokevirtual deleteCharAt : (I)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload #6
    //   163: invokevirtual toString : ()Ljava/lang/String;
    //   166: astore #5
    //   168: goto -> 171
    //   171: aload #5
    //   173: invokestatic a : (Ljava/lang/String;)Z
    //   176: ifne -> 203
    //   179: aload #5
    //   181: ldc '02:00:00:00:00:00'
    //   183: invokevirtual equals : (Ljava/lang/Object;)Z
    //   186: ifne -> 203
    //   189: aload #5
    //   191: ldc '00:00:00:00:00:00'
    //   193: invokevirtual equals : (Ljava/lang/Object;)Z
    //   196: istore #4
    //   198: iload #4
    //   200: ifeq -> 207
    //   203: ldc 'empty'
    //   205: astore #5
    //   207: aload #5
    //   209: areturn
    //   210: astore #5
    //   212: aload #5
    //   214: invokestatic a : (Ljava/lang/Throwable;)V
    //   217: ldc 'exception'
    //   219: areturn
    //   220: aconst_null
    //   221: astore #5
    //   223: goto -> 171
    // Exception table:
    //   from	to	target	type
    //   0	13	210	finally
    //   13	35	210	finally
    //   40	77	210	finally
    //   82	95	210	finally
    //   107	133	210	finally
    //   140	161	210	finally
    //   161	168	210	finally
    //   171	198	210	finally
  }
  
  public String c(Context paramContext) {
    try {
      return "empty";
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String d() {
    try {
      String str1 = System.getProperty("http.proxyHost");
      String str2 = System.getProperty("http.proxyPort");
      boolean bool = f.a(str1);
      if (bool && f.a(str2))
        return "empty"; 
      null = str1;
      if (f.a(str1))
        null = "empty"; 
      str1 = str2;
      if (f.a(str2))
        str1 = "empty"; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(null);
      return stringBuilder.toString();
    } finally {
      Exception exception = null;
      d.a(exception);
    } 
  }
  
  public String d(Context paramContext) {
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      String str1 = "default";
      return (String)enumeration;
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String e(Context paramContext) {
    try {
      return "empty";
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String f(Context paramContext) {
    try {
      String str;
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      Enumeration<NetworkInterface> enumeration2 = null;
      paramContext = null;
      Enumeration<NetworkInterface> enumeration1 = enumeration2;
      if (networkInfo != null) {
        enumeration1 = enumeration2;
        if (networkInfo.isAvailable()) {
          enumeration1 = enumeration2;
          if (networkInfo.getType() == 1) {
            enumeration2 = NetworkInterface.getNetworkInterfaces();
            label27: while (true) {
              Context context = paramContext;
              if (enumeration2.hasMoreElements()) {
                NetworkInterface networkInterface = enumeration2.nextElement();
                if (networkInterface.getName().toLowerCase().equals("wlan0")) {
                  Iterator<InterfaceAddress> iterator = networkInterface.getInterfaceAddresses().iterator();
                  Context context1 = paramContext;
                  while (true) {
                    paramContext = context1;
                    if (iterator.hasNext()) {
                      InterfaceAddress interfaceAddress = iterator.next();
                      if (interfaceAddress.getAddress() instanceof java.net.Inet4Address)
                        str = b(interfaceAddress.getNetworkPrefixLength()); 
                      continue;
                    } 
                    continue label27;
                  } 
                } 
                continue;
              } 
              break;
            } 
          } 
        } 
      } 
      return str;
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public String g(Context paramContext) {
    String str = null;
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      return str1;
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */