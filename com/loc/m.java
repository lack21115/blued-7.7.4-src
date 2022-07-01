package com.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

public final class m {
  public static String a() {
    String str = null;
    try {
      String str1 = String.valueOf(System.currentTimeMillis());
      null = "1";
      str = str1;
      if (!k.a())
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
      y.a(exception, "CI", "TS");
    } 
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2) {
    try {
      null = k.e(paramContext);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(null);
      stringBuilder.append(":");
      stringBuilder.append(paramString1.substring(0, paramString1.length() - 3));
      return r.a(stringBuilder.toString());
    } finally {
      paramContext = null;
      y.a((Throwable)paramContext, "CI", "Sco");
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
      u.a(paramByteArrayOutputStream, b, u.a(paramString));
      return;
    } 
    u.a(paramByteArrayOutputStream, (byte)0, new byte[0]);
  }
  
  public static byte[] a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2) {
    try {
      a a = new a((byte)0);
      a.a = n.x(paramContext);
      a.b = n.m(paramContext);
      String str5 = n.h(paramContext);
      String str4 = str5;
      if (str5 == null)
        str4 = ""; 
      a.c = str4;
      a.d = k.c(paramContext);
      a.e = Build.MODEL;
      a.f = Build.MANUFACTURER;
      a.g = Build.DEVICE;
      a.h = k.b(paramContext);
      a.i = k.d(paramContext);
      a.j = String.valueOf(Build.VERSION.SDK_INT);
      a.k = n.A(paramContext);
      a.l = n.t(paramContext);
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append(n.q(paramContext));
      a.m = stringBuilder4.toString();
      stringBuilder4 = new StringBuilder();
      stringBuilder4.append(n.p(paramContext));
      a.n = stringBuilder4.toString();
      a.o = n.C(paramContext);
      a.p = n.o(paramContext);
      if (paramBoolean1) {
        a.q = "";
      } else {
        a.q = n.l(paramContext);
      } 
      if (paramBoolean1) {
        a.r = "";
      } else {
        a.r = n.k(paramContext);
      } 
      if (paramBoolean1) {
        a.s = "";
        a.t = "";
      } else {
        String[] arrayOfString = n.c();
        a.s = arrayOfString[0];
        a.t = arrayOfString[1];
      } 
      a.w = n.a();
      String str3 = n.a(paramContext);
      if (!TextUtils.isEmpty(str3)) {
        a.x = str3;
      } else {
        a.x = "";
      } 
      StringBuilder stringBuilder3 = new StringBuilder("aid=");
      stringBuilder3.append(n.j(paramContext));
      a.y = stringBuilder3.toString();
      if ((paramBoolean2 && v.d) || v.e) {
        String str = n.g(paramContext);
        if (!TextUtils.isEmpty(str)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(a.y);
          stringBuilder.append("|oaid=");
          stringBuilder.append(str);
          a.y = stringBuilder.toString();
        } 
      } 
      String str2 = n.a(paramContext, ",");
      if (!TextUtils.isEmpty(str2)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a.y);
        stringBuilder.append("|multiImeis=");
        stringBuilder.append(str2);
        a.y = stringBuilder.toString();
      } 
      str2 = n.z(paramContext);
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
      stringBuilder2.append(n.i(paramContext));
      a.y = stringBuilder2.toString();
      String str1 = n.b();
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
      stringBuilder1.append(n.d());
      stringBuilder1.append("|ram=");
      stringBuilder1.append(n.B(paramContext));
      stringBuilder1.append("|arch=");
      return a(a);
    } finally {
      paramContext = null;
      y.a((Throwable)paramContext, "CI", "gz");
    } 
  }
  
  private static byte[] a(a parama) {
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    } finally {
      null = null;
    } 
    try {
      y.a(null, "CI", "gzx");
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */