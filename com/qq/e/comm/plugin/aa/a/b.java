package com.qq.e.comm.plugin.aa.a;

import java.io.File;

public class b {
  private final String a;
  
  private final File b;
  
  private final String c;
  
  private final boolean d;
  
  private b(File paramFile, String paramString1, String paramString2, boolean paramBoolean) {
    this.b = paramFile;
    this.c = paramString1;
    this.a = paramString2;
    this.d = paramBoolean;
  }
  
  public File a() {
    return this.b;
  }
  
  public String b() {
    return this.c;
  }
  
  public String c() {
    return this.a;
  }
  
  public boolean d() {
    return this.d;
  }
  
  public static class a {
    private String a;
    
    private File b;
    
    private String c;
    
    private boolean d = true;
    
    public a a(File param1File) {
      this.b = param1File;
      return this;
    }
    
    public a a(String param1String) {
      this.c = param1String;
      return this;
    }
    
    public a a(boolean param1Boolean) {
      this.d = param1Boolean;
      return this;
    }
    
    public b a() {
      return new b(this.b, this.c, this.a, this.d);
    }
    
    public a b(String param1String) {
      this.a = param1String;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\aa\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */