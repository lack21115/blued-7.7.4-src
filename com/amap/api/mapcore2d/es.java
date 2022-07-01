package com.amap.api.mapcore2d;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public abstract class es extends ew {
  protected Context a;
  
  protected da b;
  
  public es(Context paramContext, da paramda) {
    if (paramContext != null)
      this.a = paramContext.getApplicationContext(); 
    this.b = paramda;
  }
  
  private byte[] q() {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      byteArrayOutputStream.write(db.a("PANDORA$"));
      byteArrayOutputStream.write(new byte[] { 1 });
      byteArrayOutputStream.write(new byte[] { 0 });
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
    } finally {
      null = null;
    } 
  }
  
  private byte[] r() {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      byte[] arrayOfByte = b();
      if (arrayOfByte == null || arrayOfByte.length == 0) {
        byteArrayOutputStream.write(new byte[] { 0 });
        arrayOfByte = byteArrayOutputStream.toByteArray();
        try {
          return arrayOfByte;
        } finally {
          byteArrayOutputStream = null;
          dl.a((Throwable)byteArrayOutputStream, "bre", "grrd");
        } 
      } 
      byteArrayOutputStream.write(new byte[] { 1 });
      byteArrayOutputStream.write(a(arrayOfByte));
      byteArrayOutputStream.write(arrayOfByte);
      arrayOfByte = byteArrayOutputStream.toByteArray();
    } finally {
      null = null;
    } 
  }
  
  private byte[] s() {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      byte[] arrayOfByte = c();
      if (arrayOfByte == null || arrayOfByte.length == 0) {
        byteArrayOutputStream.write(new byte[] { 0 });
        arrayOfByte = byteArrayOutputStream.toByteArray();
        try {
          return arrayOfByte;
        } finally {
          byteArrayOutputStream = null;
          dl.a((Throwable)byteArrayOutputStream, "bre", "gred");
        } 
      } 
      byteArrayOutputStream.write(new byte[] { 1 });
      arrayOfByte = ct.a(this.a, arrayOfByte);
      byteArrayOutputStream.write(a(arrayOfByte));
      byteArrayOutputStream.write(arrayOfByte);
      arrayOfByte = byteArrayOutputStream.toByteArray();
    } finally {
      null = null;
    } 
  }
  
  protected byte[] a(byte[] paramArrayOfbyte) {
    int i = paramArrayOfbyte.length;
    return new byte[] { (byte)(i / 256), (byte)(i % 256) };
  }
  
  public final byte[] a_() {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      byteArrayOutputStream.write(q());
      byteArrayOutputStream.write(i());
      byteArrayOutputStream.write(r());
      byteArrayOutputStream.write(s());
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
    } finally {
      null = null;
    } 
  }
  
  public abstract byte[] b();
  
  public abstract byte[] c();
  
  protected String d() {
    return "2.1";
  }
  
  public boolean e() {
    return true;
  }
  
  public Map<String, String> g() {
    String str1 = cq.f(this.a);
    String str2 = ct.a();
    Context context = this.a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("key=");
    stringBuilder.append(str1);
    String str3 = ct.a(context, str2, stringBuilder.toString());
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("ts", str2);
    hashMap.put("key", str1);
    hashMap.put("scode", str3);
    return (Map)hashMap;
  }
  
  public byte[] i() {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      byteArrayOutputStream.write(new byte[] { 3 });
      if (e()) {
        byte[] arrayOfByte1 = ct.a(this.a, k());
        byteArrayOutputStream.write(a(arrayOfByte1));
        byteArrayOutputStream.write(arrayOfByte1);
      } else {
        byteArrayOutputStream.write(new byte[] { 0, 0 });
      } 
      byte[] arrayOfByte = db.a(d());
      if (arrayOfByte != null && arrayOfByte.length > 0) {
        byteArrayOutputStream.write(a(arrayOfByte));
        byteArrayOutputStream.write(arrayOfByte);
      } else {
        byteArrayOutputStream.write(new byte[] { 0, 0 });
      } 
      arrayOfByte = db.a(j());
      if (arrayOfByte != null && arrayOfByte.length > 0) {
        byteArrayOutputStream.write(a(arrayOfByte));
        byteArrayOutputStream.write(arrayOfByte);
      } else {
        byteArrayOutputStream.write(new byte[] { 0, 0 });
      } 
      arrayOfByte = byteArrayOutputStream.toByteArray();
    } finally {
      null = null;
    } 
  }
  
  public String j() {
    return String.format("platform=Android&sdkversion=%s&product=%s", new Object[] { this.b.c(), this.b.a() });
  }
  
  protected boolean k() {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\es.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */