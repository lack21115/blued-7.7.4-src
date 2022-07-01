package a.a.a.a.a.a.j;

import a.a.a.a.a.e.e;

public final class a {
  public int a = 30;
  
  public float b = -1.0F;
  
  public float c = 0.0F;
  
  public long d = 0L;
  
  public long e = 0L;
  
  public int f = 0;
  
  public boolean g = true;
  
  public static a a() {
    return a.a();
  }
  
  public void a(int paramInt) {
    this.a = paramInt;
    e e = e.g;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("set desire fps:");
    stringBuilder.append(this.a);
    e.c("FPSController", stringBuilder.toString());
  }
  
  public void a(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public boolean b() {
    if (!this.g)
      return false; 
    this.d++;
    long l1 = System.currentTimeMillis();
    long l2 = this.d;
    if (l2 != 0L) {
      long l = l1 - this.e;
      if (l > 1000L) {
        int i = Math.round((float)(l2 * 1000L / l));
        this.e = l1;
        this.d = 0L;
        int j = this.a;
        if (i <= j) {
          this.b = -1.0F;
        } else {
          this.b = i / (i - j);
        } 
        this.f = i;
        e e = e.g;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("average fps = ");
        stringBuilder.append(i);
        stringBuilder.append(", delta fps = ");
        stringBuilder.append(this.b);
        e.b("FPSController", stringBuilder.toString());
      } 
    } 
    float f1 = this.b;
    if (f1 < 0.0F)
      return false; 
    float f2 = this.c + 1.0F;
    this.c = f2;
    if (f2 >= f1) {
      this.c = f2 - f1;
      return true;
    } 
    return false;
  }
  
  public int c() {
    return this.f;
  }
  
  public int d() {
    return this.a;
  }
  
  public static class a {
    public static final a a = new a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\j\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */