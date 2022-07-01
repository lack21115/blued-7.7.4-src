package a.a.a.a.a.f;

public class b {
  public long a;
  
  public String b;
  
  public volatile int c;
  
  public volatile int d;
  
  public static b a() {
    return a.a();
  }
  
  public void a(int paramInt) {
    this.c = paramInt;
  }
  
  public void a(long paramLong) {
    this.a = paramLong;
  }
  
  public void a(String paramString) {
    this.b = paramString;
  }
  
  public String b() {
    return this.b;
  }
  
  public void b(int paramInt) {
    this.d = paramInt;
  }
  
  public boolean b(long paramLong) {
    return (this.a / 1000L == paramLong);
  }
  
  public boolean c() {
    return (this.d > 0 && this.d < this.c);
  }
  
  public void d() {
    this.d++;
  }
  
  public void e() {
    if (this.c > 0 && this.d == this.c) {
      this.c = 0;
      this.d = 0;
      this.b = null;
      this.a = 0L;
    } 
  }
  
  public static class a {
    public static final b a = new b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */