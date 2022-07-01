package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class ct {
  public static String a() {
    String str = null;
    try {
      String str1 = String.valueOf(System.currentTimeMillis());
      null = "1";
      str = str1;
      if (!cq.a())
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
      dl.a(exception, "CI", "TS");
    } 
  }
  
  public static String a(Context paramContext) {
    try {
      a a = new a();
      return a(paramContext, a);
    } finally {
      paramContext = null;
      dl.a((Throwable)paramContext, "CI", "IX");
    } 
  }
  
  private static String a(Context paramContext, a parama) {
    return cv.b(b(paramContext, parama));
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2) {
    try {
      null = cq.e(paramContext);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(null);
      stringBuilder.append(":");
      stringBuilder.append(paramString1.substring(0, paramString1.length() - 3));
      return cx.b(stringBuilder.toString());
    } finally {
      paramContext = null;
      dl.a((Throwable)paramContext, "CI", "Sco");
    } 
  }
  
  public static void a(ByteArrayOutputStream paramByteArrayOutputStream, String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      byte b;
      if ((paramString.getBytes()).length > 255) {
        b = -1;
      } else {
        b = (byte)(paramString.getBytes()).length;
      } 
      db.a(paramByteArrayOutputStream, b, db.a(paramString));
      return;
    } 
    db.a(paramByteArrayOutputStream, (byte)0, new byte[0]);
  }
  
  private static byte[] a(Context paramContext, ByteArrayOutputStream paramByteArrayOutputStream) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
    return b(paramContext, db.b(paramByteArrayOutputStream.toByteArray()));
  }
  
  public static byte[] a(Context paramContext, boolean paramBoolean) {
    try {
      return b(paramContext, b(paramContext, paramBoolean));
    } finally {
      paramContext = null;
      dl.a((Throwable)paramContext, "CI", "gz");
    } 
  }
  
  public static byte[] a(Context paramContext, byte[] paramArrayOfbyte) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
    return cv.a(paramArrayOfbyte);
  }
  
  private static a b(Context paramContext, boolean paramBoolean) {
    a a = new a();
    a.a = cu.v(paramContext);
    a.b = cu.m(paramContext);
    String str5 = cu.h(paramContext);
    String str4 = str5;
    if (str5 == null)
      str4 = ""; 
    a.c = str4;
    a.d = cq.c(paramContext);
    a.e = Build.MODEL;
    a.f = Build.MANUFACTURER;
    a.g = Build.DEVICE;
    a.h = cq.b(paramContext);
    a.i = cq.d(paramContext);
    a.j = String.valueOf(Build.VERSION.SDK_INT);
    a.k = cu.x(paramContext);
    a.l = cu.u(paramContext);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(cu.r(paramContext));
    stringBuilder2.append("");
    a.m = stringBuilder2.toString();
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(cu.q(paramContext));
    stringBuilder2.append("");
    a.n = stringBuilder2.toString();
    a.o = cu.z(paramContext);
    a.p = cu.p(paramContext);
    if (paramBoolean) {
      a.q = "";
    } else {
      a.q = cu.l(paramContext);
    } 
    if (paramBoolean) {
      a.r = "";
    } else {
      a.r = cu.k(paramContext);
    } 
    if (paramBoolean) {
      a.s = "";
      a.t = "";
    } else {
      String[] arrayOfString = cu.n(paramContext);
      a.s = arrayOfString[0];
      a.t = arrayOfString[1];
    } 
    a.w = cu.a();
    String str3 = cu.b(paramContext);
    if (!TextUtils.isEmpty(str3)) {
      a.x = str3;
    } else {
      a.x = "";
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("aid=");
    stringBuilder1.append(cu.j(paramContext));
    stringBuilder1.append("|serial=");
    stringBuilder1.append(cu.i(paramContext));
    stringBuilder1.append("|storage=");
    stringBuilder1.append(cu.c());
    stringBuilder1.append("|ram=");
    stringBuilder1.append(cu.y(paramContext));
    stringBuilder1.append("|arch=");
    stringBuilder1.append(cu.d());
    a.y = stringBuilder1.toString();
    String str2 = cu.a(paramContext);
    if (!TextUtils.isEmpty(str2)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a.y);
      stringBuilder.append("|adiuExtras=");
      stringBuilder.append(str2);
      a.y = stringBuilder.toString();
    } 
    str2 = cu.a(paramContext, ",", true);
    if (!TextUtils.isEmpty(str2)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a.y);
      stringBuilder.append("|multiImeis=");
      stringBuilder.append(str2);
      a.y = stringBuilder.toString();
    } 
    String str1 = cu.w(paramContext);
    if (!TextUtils.isEmpty(str1)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a.y);
      stringBuilder.append("|meid=");
      stringBuilder.append(str1);
      a.y = stringBuilder.toString();
    } 
    return a;
  }
  
  public static String b(Context paramContext) {
    try {
      return a(paramContext, b(paramContext, false));
    } finally {
      paramContext = null;
      dl.a((Throwable)paramContext, "CI", "gCX");
    } 
  }
  
  private static byte[] b(Context paramContext, a parama) {
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    } finally {
      parama = null;
    } 
    try {
      dl.a((Throwable)parama, "CI", "gzx");
      return null;
    } finally {
      if (paramContext != null)
        try {
          paramContext.close();
        } finally {
          paramContext = null;
        }  
    } 
  }
  
  public static byte[] b(Context paramContext, byte[] paramArrayOfbyte) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
    byte[] arrayOfByte;
    PublicKey publicKey = db.d();
    if (paramArrayOfbyte.length > 117) {
      byte[] arrayOfByte1 = new byte[117];
      System.arraycopy(paramArrayOfbyte, 0, arrayOfByte1, 0, 117);
      arrayOfByte = cv.a(arrayOfByte1, publicKey);
      arrayOfByte1 = new byte[paramArrayOfbyte.length + 128 - 117];
      System.arraycopy(arrayOfByte, 0, arrayOfByte1, 0, 128);
      System.arraycopy(paramArrayOfbyte, 117, arrayOfByte1, 128, paramArrayOfbyte.length - 117);
      return arrayOfByte1;
    } 
    return cv.a(paramArrayOfbyte, (Key)arrayOfByte);
  }
  
  static class a {
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */