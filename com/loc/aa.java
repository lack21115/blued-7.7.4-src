package com.loc;

import java.util.HashMap;
import java.util.Map;

public final class aa extends q {
  private byte[] a;
  
  private String b = "1";
  
  public aa(byte[] paramArrayOfbyte, String paramString) {
    this.a = (byte[])paramArrayOfbyte.clone();
    this.b = paramString;
  }
  
  public final Map<String, String> b() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("Content-Type", "application/zip");
    hashMap.put("Content-Length", String.valueOf(this.a.length));
    return (Map)hashMap;
  }
  
  public final Map<String, String> b_() {
    return null;
  }
  
  public final String c() {
    String str1 = u.c(v.b);
    String str2 = this.b;
    byte[] arrayOfByte1 = u.a(v.a);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 50];
    System.arraycopy(this.a, 0, arrayOfByte2, 0, 50);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 50, arrayOfByte1.length);
    return String.format(str1, new Object[] { "1", str2, "1", "open", r.a(arrayOfByte2) });
  }
  
  public final byte[] e() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */