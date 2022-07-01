package com.qiniu.pili.droid.shortvideo.f;

public class h {
  private String a = "pldroid_beauty";
  
  private String b = "pldroid_amix";
  
  private String c = "pldroid_decoder";
  
  private String d = "pldroid_encoder";
  
  private h() {}
  
  public static h a() {
    return b.a;
  }
  
  private boolean a(String paramString) {
    if (paramString != null)
      try {
        if (paramString.contains("/")) {
          System.load(paramString);
        } else {
          System.loadLibrary(paramString);
        } 
        return true;
      } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
        e e = e.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Load error:");
        stringBuilder.append(unsatisfiedLinkError.getMessage());
        e.e("PLSONameHelper", stringBuilder.toString());
      }  
    return false;
  }
  
  public static boolean a(boolean paramBoolean) {
    if (paramBoolean && !com.qiniu.pili.droid.beauty.a.a)
      e.a.e("PLSONameHelper", "MM Processing is not available"); 
    return com.qiniu.pili.droid.beauty.a.a;
  }
  
  public String a(a parama) {
    int i = null.a[parama.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i == 4)
            return this.d; 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("cannot support the so type:");
          stringBuilder.append(parama);
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
        return this.c;
      } 
      return this.b;
    } 
    return this.a;
  }
  
  public boolean b() {
    return a(a(a.a));
  }
  
  public boolean c() {
    return a(a(a.b));
  }
  
  public boolean d() {
    return a(a(a.d));
  }
  
  public enum a {
    a, b, c, d;
  }
  
  static class b {
    public static final h a = new h();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\f\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */