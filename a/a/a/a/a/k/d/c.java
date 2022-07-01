package a.a.a.a.a.k.d;

public final class c {
  public Object a = new Object();
  
  public StringBuilder b = new StringBuilder();
  
  public static c a() {
    return a.a;
  }
  
  public boolean a(String paramString) {
    if (paramString != null) {
      if (paramString.equals(""))
        return false; 
      if (this.b.length() > 65536)
        return false; 
      try {
        synchronized (this.a) {
          this.b.append(paramString);
        } 
      } catch (OutOfMemoryError outOfMemoryError) {
        outOfMemoryError.printStackTrace();
      } 
      return true;
    } 
    return false;
  }
  
  public void b() {
    synchronized (this.a) {
      this.b.delete(0, this.b.length());
      return;
    } 
  }
  
  public String c() {
    StringBuilder stringBuilder = this.b;
    if (stringBuilder == null || stringBuilder.length() == 0)
      return null; 
    synchronized (this.a) {
      return this.b.toString();
    } 
  }
  
  public static class a {
    public static final c a = new c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\k\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */