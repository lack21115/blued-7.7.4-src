package com.tencent.bugly.proguard;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public final class f extends k {
  private static byte[] k;
  
  private static Map<String, String> l;
  
  public short a = 0;
  
  public int b = 0;
  
  public String c = null;
  
  public String d = null;
  
  public byte[] e;
  
  private byte f = 0;
  
  private int g = 0;
  
  private int h = 0;
  
  private Map<String, String> i;
  
  private Map<String, String> j;
  
  static {
    k = null;
    l = null;
  }
  
  public final void a(i parami) {
    try {
      this.a = parami.a(this.a, 1, true);
      this.f = parami.a(this.f, 2, true);
      this.g = parami.a(this.g, 3, true);
      this.b = parami.a(this.b, 4, true);
      this.c = parami.b(5, true);
      this.d = parami.b(6, true);
      if (k == null)
        k = new byte[] { 0 }; 
      byte[] arrayOfByte = k;
      this.e = parami.c(7, true);
      this.h = parami.a(this.h, 8, true);
      Map<String, String> map = l;
      if (map == null) {
        map = new HashMap<String, String>();
        l = map;
        map.put("", "");
      } 
      this.i = (Map<String, String>)parami.<Map<String, String>>a(l, 9, true);
      if (l == null) {
        map = new HashMap<String, String>();
        l = map;
        map.put("", "");
      } 
      this.j = (Map<String, String>)parami.<Map<String, String>>a(l, 10, true);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      PrintStream printStream = System.out;
      StringBuilder stringBuilder = new StringBuilder("RequestPacket decode error ");
      stringBuilder.append(e.a(this.e));
      printStream.println(stringBuilder.toString());
      throw new RuntimeException(exception);
    } 
  }
  
  public final void a(j paramj) {
    paramj.a(this.a, 1);
    paramj.a(this.f, 2);
    paramj.a(this.g, 3);
    paramj.a(this.b, 4);
    paramj.a(this.c, 5);
    paramj.a(this.d, 6);
    paramj.a(this.e, 7);
    paramj.a(this.h, 8);
    paramj.a(this.i, 9);
    paramj.a(this.j, 10);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {
    h h = new h(paramStringBuilder, paramInt);
    h.a(this.a, "iVersion");
    h.a(this.f, "cPacketType");
    h.a(this.g, "iMessageType");
    h.a(this.b, "iRequestId");
    h.a(this.c, "sServantName");
    h.a(this.d, "sFuncName");
    h.a(this.e, "sBuffer");
    h.a(this.h, "iTimeout");
    h.a(this.i, "context");
    h.a(this.j, "status");
  }
  
  public final Object clone() {
    try {
      return super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      if (m)
        return null; 
      throw new AssertionError();
    } 
  }
  
  public final boolean equals(Object paramObject) {
    paramObject = paramObject;
    short s = ((f)paramObject).a;
    Integer integer = Integer.valueOf(1);
    return (l.a(1, s) && l.a(1, ((f)paramObject).f) && l.a(1, ((f)paramObject).g) && l.a(1, ((f)paramObject).b) && l.a(integer, ((f)paramObject).c) && l.a(integer, ((f)paramObject).d) && l.a(integer, ((f)paramObject).e) && l.a(1, ((f)paramObject).h) && l.a(integer, ((f)paramObject).i) && l.a(integer, ((f)paramObject).j));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */