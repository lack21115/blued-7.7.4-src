package com.amap.api.col.s;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public abstract class ct extends bp {
  protected Context a;
  
  protected br b;
  
  public ct(Context paramContext, br parambr) {
    if (paramContext != null)
      this.a = paramContext.getApplicationContext(); 
    this.b = parambr;
  }
  
  private static byte[] a() {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      byteArrayOutputStream.write(bs.a("PANDORA$"));
      byteArrayOutputStream.write(new byte[] { 1 });
      byteArrayOutputStream.write(new byte[] { 0 });
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
    } finally {
      null = null;
    } 
  }
  
  private byte[] p() {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
  }
  
  private static byte[] q() {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      byteArrayOutputStream.write(new byte[] { 0 });
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
    } finally {
      null = null;
    } 
  }
  
  private byte[] r() {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      byte[] arrayOfByte = d();
      if (arrayOfByte == null || arrayOfByte.length == 0) {
        byteArrayOutputStream.write(new byte[] { 0 });
        arrayOfByte = byteArrayOutputStream.toByteArray();
        try {
          return arrayOfByte;
        } finally {
          byteArrayOutputStream = null;
          cd.a((Throwable)byteArrayOutputStream, "bre", "gred");
        } 
      } 
      byteArrayOutputStream.write(new byte[] { 1 });
      arrayOfByte = bn.a(arrayOfByte);
      byteArrayOutputStream.write(bs.a(arrayOfByte.length));
      byteArrayOutputStream.write(arrayOfByte);
      arrayOfByte = byteArrayOutputStream.toByteArray();
    } finally {
      null = null;
    } 
  }
  
  public abstract byte[] d();
  
  public final Map<String, String> e() {
    String str1 = bi.f(this.a);
    String str2 = bl.a();
    String str3 = bl.a(this.a, str2, "key=".concat(String.valueOf(str1)));
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("ts", str2);
    hashMap.put("key", str1);
    hashMap.put("scode", str3);
    return (Map)hashMap;
  }
  
  protected String h() {
    return "2.1";
  }
  
  public final byte[] i() {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      byteArrayOutputStream.write(a());
      byteArrayOutputStream.write(p());
      byteArrayOutputStream.write(q());
      byteArrayOutputStream.write(r());
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
    } finally {
      null = null;
    } 
  }
  
  public final String l() {
    return String.format("platform=Android&sdkversion=%s&product=%s", new Object[] { this.b.d(), this.b.b() });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */