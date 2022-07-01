package com.amap.api.col.s;

import java.util.HashMap;
import java.util.Map;

public final class cf extends bp {
  private byte[] a;
  
  private String b = "1";
  
  public cf(byte[] paramArrayOfbyte, String paramString) {
    this.a = (byte[])paramArrayOfbyte.clone();
    this.b = paramString;
  }
  
  public final Map<String, String> e() {
    return null;
  }
  
  public final Map<String, String> f() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("Content-Type", "application/zip");
    hashMap.put("Content-Length", String.valueOf(this.a.length));
    return (Map)hashMap;
  }
  
  public final String g() {
    String str1 = bs.c(cc.b);
    String str2 = this.b;
    byte[] arrayOfByte1 = bs.a(cc.a);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 50];
    System.arraycopy(this.a, 0, arrayOfByte2, 0, 50);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 50, arrayOfByte1.length);
    return String.format(str1, new Object[] { "1", str2, "1", "open", bq.a(arrayOfByte2) });
  }
  
  public final byte[] i() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */