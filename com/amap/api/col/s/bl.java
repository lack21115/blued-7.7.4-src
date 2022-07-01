package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

public final class bl {
  public static String a() {
    String str = null;
    try {
      String str1 = String.valueOf(System.currentTimeMillis());
      null = "1";
      str = str1;
      if (!bi.a())
        null = "0"; 
      str = str1;
      int i = str1.length();
      str = str1;
      StringBuilder stringBuilder = new StringBuilder();
      str = str1;
      stringBuilder.append(str1.substring(0, i - 2));
      str = str1;
      stringBuilder.append(null);
      str = str1;
      return stringBuilder.toString();
    } finally {
      Exception exception = null;
      cd.a(exception, "CI", "TS");
    } 
  }
  
  public static String a(Context paramContext) {
    try {
      return bn.b(a(b(paramContext, false)));
    } finally {
      paramContext = null;
      cd.a((Throwable)paramContext, "CI", "gCXi");
    } 
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2) {
    try {
      null = bi.e(paramContext);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(null);
      stringBuilder.append(":");
      stringBuilder.append(paramString1.substring(0, paramString1.length() - 3));
      return bq.a(stringBuilder.toString());
    } finally {
      paramContext = null;
      cd.a((Throwable)paramContext, "CI", "Sco");
    } 
  }
  
  private static void a(ByteArrayOutputStream paramByteArrayOutputStream, String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      byte b;
      if ((paramString.getBytes()).length > 255) {
        b = -1;
      } else {
        b = (byte)(paramString.getBytes()).length;
      } 
      bs.a(paramByteArrayOutputStream, b, bs.a(paramString));
      return;
    } 
    bs.a(paramByteArrayOutputStream, (byte)0, new byte[0]);
  }
  
  public static byte[] a(Context paramContext, boolean paramBoolean) {
    try {
      return a(b(paramContext, paramBoolean));
    } finally {
      paramContext = null;
      cd.a((Throwable)paramContext, "CI", "gz");
    } 
  }
  
  private static byte[] a(a parama) {
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    } finally {
      null = null;
    } 
    try {
      cd.a(null, "CI", "gzx");
      return null;
    } finally {
      if (parama != null)
        try {
          parama.close();
        } finally {
          parama = null;
        }  
    } 
  }
  
  private static a b(Context paramContext, boolean paramBoolean) {
    a a = new a((byte)0);
    a.a = bm.t(paramContext);
    a.b = bm.m(paramContext);
    String str5 = bm.h(paramContext);
    String str4 = str5;
    if (str5 == null)
      str4 = ""; 
    a.c = str4;
    a.d = bi.c(paramContext);
    a.e = Build.MODEL;
    a.f = Build.MANUFACTURER;
    a.g = Build.DEVICE;
    a.h = bi.b(paramContext);
    a.i = bi.d(paramContext);
    a.j = String.valueOf(Build.VERSION.SDK_INT);
    a.k = bm.v(paramContext);
    a.l = bm.q(paramContext);
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append(bm.p(paramContext));
    a.m = stringBuilder4.toString();
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append(bm.o(paramContext));
    a.n = stringBuilder4.toString();
    a.o = bm.x(paramContext);
    a.p = bm.n(paramContext);
    a.q = bm.l(paramContext);
    a.r = bm.k(paramContext);
    String[] arrayOfString = bm.d();
    a.s = arrayOfString[0];
    a.t = arrayOfString[1];
    a.w = bm.a();
    String str3 = bm.a(paramContext);
    if (!TextUtils.isEmpty(str3)) {
      a.x = str3;
    } else {
      a.x = "";
    } 
    StringBuilder stringBuilder3 = new StringBuilder("aid=");
    stringBuilder3.append(bm.j(paramContext));
    a.y = stringBuilder3.toString();
    if ((paramBoolean && cc.d) || cc.e) {
      String str = bm.g(paramContext);
      if (!TextUtils.isEmpty(str)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a.y);
        stringBuilder.append("|oaid=");
        stringBuilder.append(str);
        a.y = stringBuilder.toString();
      } 
    } 
    String str2 = bm.a(paramContext, ",");
    if (!TextUtils.isEmpty(str2)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a.y);
      stringBuilder.append("|multiImeis=");
      stringBuilder.append(str2);
      a.y = stringBuilder.toString();
    } 
    str2 = bm.u(paramContext);
    if (!TextUtils.isEmpty(str2)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a.y);
      stringBuilder.append("|meid=");
      stringBuilder.append(str2);
      a.y = stringBuilder.toString();
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(a.y);
    stringBuilder2.append("|serial=");
    stringBuilder2.append(bm.i(paramContext));
    a.y = stringBuilder2.toString();
    String str1 = bm.b();
    if (!TextUtils.isEmpty(str1)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a.y);
      stringBuilder.append("|adiuExtras=");
      stringBuilder.append(str1);
      a.y = stringBuilder.toString();
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(a.y);
    stringBuilder1.append("|storage=");
    stringBuilder1.append(bm.e());
    stringBuilder1.append("|ram=");
    stringBuilder1.append(bm.w(paramContext));
    stringBuilder1.append("|arch=");
    stringBuilder1.append(bm.f());
    a.y = stringBuilder1.toString();
    return a;
  }
  
  static final class a {
    String a;
    
    String b;
    
    String c;
    
    String d;
    
    String e;
    
    String f;
    
    String g;
    
    String h;
    
    String i;
    
    String j;
    
    String k;
    
    String l;
    
    String m;
    
    String n;
    
    String o;
    
    String p;
    
    String q;
    
    String r;
    
    String s;
    
    String t;
    
    String u;
    
    String v;
    
    String w;
    
    String x;
    
    String y;
    
    private a() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */