package com.amap.api.mapcore2d;

import java.util.HashMap;
import java.util.Map;

public class dn extends ew {
  private byte[] a;
  
  private String b = "1";
  
  public dn(byte[] paramArrayOfbyte, String paramString) {
    this.a = (byte[])paramArrayOfbyte.clone();
    this.b = paramString;
  }
  
  private String b() {
    byte[] arrayOfByte1 = db.a(dj.b);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 50];
    System.arraycopy(this.a, 0, arrayOfByte2, 0, 50);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 50, arrayOfByte1.length);
    return cx.a(arrayOfByte2);
  }
  
  public byte[] a_() {
    return this.a;
  }
  
  public Map<String, String> f() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("Content-Type", "application/zip");
    hashMap.put("Content-Length", String.valueOf(this.a.length));
    return (Map)hashMap;
  }
  
  public Map<String, String> g() {
    return null;
  }
  
  public String h() {
    return String.format(db.c(dj.c), new Object[] { "1", this.b, "1", "open", b() });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */