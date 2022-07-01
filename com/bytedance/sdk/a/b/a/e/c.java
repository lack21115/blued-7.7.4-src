package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.f;

public final class c {
  public static final f a = f.a(":");
  
  public static final f b = f.a(":status");
  
  public static final f c = f.a(":method");
  
  public static final f d = f.a(":path");
  
  public static final f e = f.a(":scheme");
  
  public static final f f = f.a(":authority");
  
  public final f g;
  
  public final f h;
  
  final int i;
  
  public c(f paramf1, f paramf2) {
    this.g = paramf1;
    this.h = paramf2;
    this.i = paramf1.g() + 32 + paramf2.g();
  }
  
  public c(f paramf, String paramString) {
    this(paramf, f.a(paramString));
  }
  
  public c(String paramString1, String paramString2) {
    this(f.a(paramString1), f.a(paramString2));
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof c;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.g.equals(((c)paramObject).g)) {
        bool1 = bool2;
        if (this.h.equals(((c)paramObject).h))
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public int hashCode() {
    return (527 + this.g.hashCode()) * 31 + this.h.hashCode();
  }
  
  public String toString() {
    return com.bytedance.sdk.a.b.a.c.a("%s: %s", new Object[] { this.g.a(), this.h.a() });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */