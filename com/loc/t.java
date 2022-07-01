package com.loc;

import android.text.TextUtils;

@af(a = "a")
public final class t {
  @ag(a = "a1", b = 6)
  private String a;
  
  @ag(a = "a2", b = 6)
  private String b;
  
  @ag(a = "a6", b = 2)
  private int c = 1;
  
  @ag(a = "a3", b = 6)
  private String d;
  
  @ag(a = "a4", b = 6)
  private String e;
  
  @ag(a = "a5", b = 6)
  private String f;
  
  private String g;
  
  private String h;
  
  private String i;
  
  private String j;
  
  private String k;
  
  private String[] l = null;
  
  private t() {}
  
  private t(a parama) {}
  
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
  
  public final String a() {
    if (TextUtils.isEmpty(this.j) && !TextUtils.isEmpty(this.a))
      this.j = u.c(this.a); 
    return this.j;
  }
  
  public final void a(boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String b() {
    return this.g;
  }
  
  public final String c() {
    if (TextUtils.isEmpty(this.h) && !TextUtils.isEmpty(this.b))
      this.h = u.c(this.b); 
    return this.h;
  }
  
  public final String d() {
    if (TextUtils.isEmpty(this.k) && !TextUtils.isEmpty(this.f))
      this.k = u.c(this.f); 
    if (TextUtils.isEmpty(this.k))
      this.k = "standard"; 
    return this.k;
  }
  
  public final boolean e() {
    return (this.c == 1);
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
  
  public final String[] f() {
    String[] arrayOfString = this.l;
    if ((arrayOfString == null || arrayOfString.length == 0) && !TextUtils.isEmpty(this.e))
      this.l = a(u.c(this.e)); 
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
    
    public final a a(String[] param1ArrayOfString) {
      if (param1ArrayOfString != null)
        this.g = (String[])param1ArrayOfString.clone(); 
      return this;
    }
    
    public final t a() throws j {
      if (this.g != null)
        return new t(this, (byte)0); 
      throw new j("sdk packages is null");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */