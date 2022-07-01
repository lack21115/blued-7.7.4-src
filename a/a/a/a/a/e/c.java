package a.a.a.a.a.e;

import android.os.Build;

public class c {
  public c a;
  
  public c b;
  
  public c() {
    c c1 = c.a;
    this.a = c1;
    this.b = c1;
    e e = e.c;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Build.MODEL:");
    stringBuilder.append(Build.MODEL);
    e.c("CompatibleManager", stringBuilder.toString());
  }
  
  public static c a() {
    return b.a;
  }
  
  public boolean b() {
    if (this.a == c.a)
      this.a = d(); 
    return (this.a == c.b);
  }
  
  public boolean c() {
    if (this.b == c.a)
      this.b = e(); 
    return (this.b == c.b);
  }
  
  public final c d() {
    String[] arrayOfString = d.e;
    int j = arrayOfString.length;
    for (int i = 0; i < j; i++) {
      if (arrayOfString[i].equalsIgnoreCase(Build.MODEL))
        return c.b; 
    } 
    return c.c;
  }
  
  public final c e() {
    String[] arrayOfString = d.f;
    int j = arrayOfString.length;
    for (int i = 0; i < j; i++) {
      if (arrayOfString[i].equalsIgnoreCase(Build.MODEL))
        return c.c; 
    } 
    return c.b;
  }
  
  public static class b {
    public static final c a = new c(null);
  }
  
  public enum c {
    a, b, c;
    
    static {
      c c1 = new c("NO", 2);
      c = c1;
      d = new c[] { a, b, c1 };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */