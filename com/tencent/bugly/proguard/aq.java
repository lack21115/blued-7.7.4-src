package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

public final class aq extends k {
  private static byte[] i;
  
  private static Map<String, String> j = new HashMap<String, String>();
  
  public byte a = 0;
  
  public int b = 0;
  
  public byte[] c = null;
  
  public String d = "";
  
  public long e = 0L;
  
  public String f = "";
  
  public Map<String, String> g = null;
  
  private String h = "";
  
  static {
    j.put("", "");
  }
  
  public final void a(i parami) {
    this.a = parami.a(this.a, 0, true);
    this.b = parami.a(this.b, 1, true);
    byte[] arrayOfByte = i;
    this.c = parami.c(2, false);
    this.d = parami.b(3, false);
    this.e = parami.a(this.e, 4, false);
    this.h = parami.b(5, false);
    this.f = parami.b(6, false);
    this.g = (Map<String, String>)parami.<Map<String, String>>a(j, 7, false);
  }
  
  public final void a(j paramj) {
    paramj.a(this.a, 0);
    paramj.a(this.b, 1);
    byte[] arrayOfByte = this.c;
    if (arrayOfByte != null)
      paramj.a(arrayOfByte, 2); 
    String str = this.d;
    if (str != null)
      paramj.a(str, 3); 
    paramj.a(this.e, 4);
    str = this.h;
    if (str != null)
      paramj.a(str, 5); 
    str = this.f;
    if (str != null)
      paramj.a(str, 6); 
    Map<String, String> map = this.g;
    if (map != null)
      paramj.a(map, 7); 
  }
  
  static {
    byte[] arrayOfByte = new byte[1];
    i = arrayOfByte;
    arrayOfByte[0] = 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */