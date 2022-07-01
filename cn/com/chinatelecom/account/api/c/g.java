package cn.com.chinatelecom.account.api.c;

import android.net.Network;

public class g {
  public Network a;
  
  public int b;
  
  public String c;
  
  public String d;
  
  public boolean e;
  
  public boolean f;
  
  public String g;
  
  public String h;
  
  private int i;
  
  private int j;
  
  public g(a parama) {
    this.i = a.a(parama);
    this.j = a.b(parama);
    this.a = a.c(parama);
    this.b = a.d(parama);
    this.c = a.e(parama);
    this.d = a.f(parama);
    this.e = a.g(parama);
    this.f = a.h(parama);
    this.g = a.i(parama);
    this.h = a.j(parama);
  }
  
  public int a() {
    int i = this.i;
    return (i > 0) ? i : 3000;
  }
  
  public int b() {
    int i = this.j;
    return (i > 0) ? i : 3000;
  }
  
  public static class a {
    private int a;
    
    private int b;
    
    private Network c;
    
    private int d;
    
    private String e;
    
    private String f;
    
    private boolean g;
    
    private boolean h;
    
    private String i;
    
    private String j;
    
    public a a(int param1Int) {
      this.a = param1Int;
      return this;
    }
    
    public a a(Network param1Network) {
      this.c = param1Network;
      return this;
    }
    
    public a a(String param1String) {
      this.e = param1String;
      return this;
    }
    
    public a a(boolean param1Boolean) {
      this.g = param1Boolean;
      return this;
    }
    
    public a a(boolean param1Boolean, String param1String1, String param1String2) {
      this.h = param1Boolean;
      this.i = param1String1;
      this.j = param1String2;
      return this;
    }
    
    public g a() {
      return new g(this);
    }
    
    public a b(int param1Int) {
      this.b = param1Int;
      return this;
    }
    
    public a b(String param1String) {
      this.f = param1String;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */