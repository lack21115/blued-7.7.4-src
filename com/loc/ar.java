package com.loc;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public abstract class ar extends q {
  protected Context a;
  
  protected t b;
  
  public ar(Context paramContext, t paramt) {
    if (paramContext != null)
      this.a = paramContext.getApplicationContext(); 
    this.b = paramt;
  }
  
  private static byte[] q() {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      byteArrayOutputStream.write(u.a("PANDORA$"));
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
      byteArrayOutputStream.write(new byte[] { 3 });
      if (j()) {
        boolean bool;
        Context context = this.a;
        boolean bool1 = l();
        if (this.b != null && "navi".equals(this.b.a())) {
          bool = true;
        } else {
          bool = false;
        } 
        byte[] arrayOfByte1 = m.a(context, bool1, bool);
        byteArrayOutputStream.write(u.a(arrayOfByte1.length));
        byteArrayOutputStream.write(arrayOfByte1);
      } else {
        byteArrayOutputStream.write(new byte[] { 0, 0 });
      } 
      byte[] arrayOfByte = u.a(g());
      if (arrayOfByte != null && arrayOfByte.length > 0) {
        byteArrayOutputStream.write(u.a(arrayOfByte.length));
        byteArrayOutputStream.write(arrayOfByte);
      } else {
        byteArrayOutputStream.write(new byte[] { 0, 0 });
      } 
      arrayOfByte = u.a(k());
      if (arrayOfByte != null && arrayOfByte.length > 0) {
        byteArrayOutputStream.write(u.a(arrayOfByte.length));
        byteArrayOutputStream.write(arrayOfByte);
      } else {
        byteArrayOutputStream.write(new byte[] { 0, 0 });
      } 
      arrayOfByte = byteArrayOutputStream.toByteArray();
    } finally {
      null = null;
    } 
  }
  
  private byte[] s() {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      byte[] arrayOfByte = a_();
      if (arrayOfByte == null || arrayOfByte.length == 0) {
        byteArrayOutputStream.write(new byte[] { 0 });
        arrayOfByte = byteArrayOutputStream.toByteArray();
        try {
          return arrayOfByte;
        } finally {
          byteArrayOutputStream = null;
          y.a((Throwable)byteArrayOutputStream, "bre", "grrd");
        } 
      } 
      byteArrayOutputStream.write(new byte[] { 1 });
      byteArrayOutputStream.write(u.a(arrayOfByte.length));
      byteArrayOutputStream.write(arrayOfByte);
      arrayOfByte = byteArrayOutputStream.toByteArray();
    } finally {
      null = null;
    } 
  }
  
  private byte[] t() {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      byte[] arrayOfByte = f();
      if (arrayOfByte == null || arrayOfByte.length == 0) {
        byteArrayOutputStream.write(new byte[] { 0 });
        arrayOfByte = byteArrayOutputStream.toByteArray();
        try {
          return arrayOfByte;
        } finally {
          byteArrayOutputStream = null;
          y.a((Throwable)byteArrayOutputStream, "bre", "gred");
        } 
      } 
      byteArrayOutputStream.write(new byte[] { 1 });
      arrayOfByte = o.a(arrayOfByte);
      byteArrayOutputStream.write(u.a(arrayOfByte.length));
      byteArrayOutputStream.write(arrayOfByte);
      arrayOfByte = byteArrayOutputStream.toByteArray();
    } finally {
      null = null;
    } 
  }
  
  public abstract byte[] a_();
  
  public Map<String, String> b_() {
    String str1 = k.f(this.a);
    String str2 = m.a();
    Context context = this.a;
    StringBuilder stringBuilder = new StringBuilder("key=");
    stringBuilder.append(str1);
    String str3 = m.a(context, str2, stringBuilder.toString());
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("ts", str2);
    hashMap.put("key", str1);
    hashMap.put("scode", str3);
    return (Map)hashMap;
  }
  
  public final byte[] e() {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      byteArrayOutputStream.write(q());
      byteArrayOutputStream.write(r());
      byteArrayOutputStream.write(s());
      byteArrayOutputStream.write(t());
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
    } finally {
      null = null;
    } 
  }
  
  public abstract byte[] f();
  
  protected String g() {
    return "2.1";
  }
  
  public boolean j() {
    return true;
  }
  
  public String k() {
    return String.format("platform=Android&sdkversion=%s&product=%s", new Object[] { this.b.c(), this.b.a() });
  }
  
  protected boolean l() {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */