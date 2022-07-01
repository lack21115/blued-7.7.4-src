package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;

public final class d extends c {
  private static HashMap<String, byte[]> f;
  
  private static HashMap<String, HashMap<String, byte[]>> g;
  
  private f e = new f();
  
  public d() {
    this.e.a = 2;
  }
  
  public final <T> void a(String paramString, T paramT) {
    if (!paramString.startsWith(".")) {
      super.a(paramString, paramT);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder("put name can not startwith . , now is ");
    stringBuilder.append(paramString);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final void a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte.length >= 4)
      try {
        i i = new i(paramArrayOfbyte, 4);
        i.a(this.b);
        this.e.a(i);
        short s = this.e.a;
        if (s == 3) {
          i = new i(this.e.e);
          i.a(this.b);
          if (f == null) {
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            f = (HashMap)hashMap;
            hashMap.put("", new byte[0]);
          } 
          this.d = i.a(f, 0, false);
          return;
        } 
        i = new i(this.e.e);
        i.a(this.b);
        if (g == null) {
          g = new HashMap<String, HashMap<String, byte[]>>();
          HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
          hashMap.put("", new byte[0]);
          g.put("", hashMap);
        } 
        this.a = i.a(g, 0, false);
        new HashMap<Object, Object>();
        return;
      } catch (Exception exception) {
        throw new RuntimeException(exception);
      }  
    throw new IllegalArgumentException("decode package must include size head");
  }
  
  public final byte[] a() {
    if (this.e.a == 2) {
      if (!this.e.c.equals("")) {
        if (this.e.d.equals(""))
          throw new IllegalArgumentException("funcName can not is null"); 
      } else {
        throw new IllegalArgumentException("servantName can not is null");
      } 
    } else {
      if (this.e.c == null)
        this.e.c = ""; 
      if (this.e.d == null)
        this.e.d = ""; 
    } 
    j j = new j(0);
    j.a(this.b);
    if (this.e.a == 2) {
      j.a(this.a, 0);
    } else {
      j.a(this.d, 0);
    } 
    this.e.e = l.a(j.a());
    j = new j(0);
    j.a(this.b);
    this.e.a(j);
    byte[] arrayOfByte = l.a(j.a());
    int i = arrayOfByte.length + 4;
    ByteBuffer byteBuffer = ByteBuffer.allocate(i);
    byteBuffer.putInt(i).put(arrayOfByte).flip();
    return byteBuffer.array();
  }
  
  public final void b(int paramInt) {
    this.e.b = 1;
  }
  
  public final void b(String paramString) {
    this.e.c = paramString;
  }
  
  public final void c() {
    super.c();
    this.e.a = 3;
  }
  
  public final void c(String paramString) {
    this.e.d = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */