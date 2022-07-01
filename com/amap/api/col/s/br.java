package com.amap.api.col.s;

import android.text.TextUtils;

public final class br {
  private String a;
  
  private String b;
  
  private int c = 1;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private String h;
  
  private String i;
  
  private String j;
  
  private String k;
  
  private String[] l = null;
  
  private br() {}
  
  private br(a parama) {}
  
  private static String a(String[] paramArrayOfString) {
    if (paramArrayOfString == null)
      return null; 
    try {
      int i;
      StringBuilder stringBuilder = new StringBuilder();
      return stringBuilder.toString();
    } finally {
      paramArrayOfString = null;
      paramArrayOfString.printStackTrace();
    } 
  }
  
  private static String[] a(String paramString) {
    try {
      return paramString.split(";");
    } finally {
      paramString = null;
      paramString.printStackTrace();
    } 
  }
  
  public final void a() {
    this.c = 1;
  }
  
  public final String b() {
    if (TextUtils.isEmpty(this.j) && !TextUtils.isEmpty(this.a))
      this.j = bs.c(this.a); 
    return this.j;
  }
  
  public final String c() {
    return this.g;
  }
  
  public final String d() {
    if (TextUtils.isEmpty(this.h) && !TextUtils.isEmpty(this.b))
      this.h = bs.c(this.b); 
    return this.h;
  }
  
  public final String e() {
    if (TextUtils.isEmpty(this.k) && !TextUtils.isEmpty(this.f))
      this.k = bs.c(this.f); 
    if (TextUtils.isEmpty(this.k))
      this.k = "standard"; 
    return this.k;
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (paramObject == this)
      return true; 
    if (getClass() != paramObject.getClass())
      return false; 
    try {
      return false;
    } finally {
      paramObject = null;
    } 
  }
  
  public final boolean f() {
    return (this.c == 1);
  }
  
  public final String[] g() {
    String[] arrayOfString = this.l;
    if ((arrayOfString == null || arrayOfString.length == 0) && !TextUtils.isEmpty(this.e))
      this.l = a(bs.c(this.e)); 
    return (String[])this.l.clone();
  }
  
  public static final class a {
    private String a;
    
    private String b;
    
    private String c;
    
    private String d;
    
    private boolean e = true;
    
    private String f = "standard";
    
    private String[] g = null;
    
    public a(String param1String1, String param1String2, String param1String3) {
      this.a = param1String2;
      this.b = param1String2;
      this.d = param1String3;
      this.c = param1String1;
    }
    
    public final a a(String param1String) {
      this.b = param1String;
      return this;
    }
    
    public final a a(boolean param1Boolean) {
      this.e = param1Boolean;
      return this;
    }
    
    public final a a(String[] param1ArrayOfString) {
      if (param1ArrayOfString != null)
        this.g = (String[])param1ArrayOfString.clone(); 
      return this;
    }
    
    public final br a() throws bh {
      if (this.g != null)
        return new br(this, (byte)0); 
      throw new bh("sdk packages is null");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */