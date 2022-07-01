package com.amap.api.mapcore2d;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

@du(a = "a")
public class da {
  @dv(a = "a1", b = 6)
  private String a;
  
  @dv(a = "a2", b = 6)
  private String b;
  
  @dv(a = "a6", b = 2)
  private int c = 1;
  
  @dv(a = "a3", b = 6)
  private String d;
  
  @dv(a = "a4", b = 6)
  private String e;
  
  @dv(a = "a5", b = 6)
  private String f;
  
  private String g;
  
  private String h;
  
  private String i;
  
  private String j;
  
  private String k;
  
  private String[] l = null;
  
  private da() {}
  
  private da(a parama) {}
  
  public static String a(String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("a1", db.b(paramString));
    return dt.a((Map)hashMap);
  }
  
  private String a(String[] paramArrayOfString) {
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
  
  private String[] b(String paramString) {
    try {
      return paramString.split(";");
    } finally {
      paramString = null;
      paramString.printStackTrace();
    } 
  }
  
  public static String h() {
    return "a6=1";
  }
  
  public String a() {
    if (TextUtils.isEmpty(this.j) && !TextUtils.isEmpty(this.a))
      this.j = db.c(this.a); 
    return this.j;
  }
  
  public void a(boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public String b() {
    return this.g;
  }
  
  public String c() {
    if (TextUtils.isEmpty(this.h) && !TextUtils.isEmpty(this.b))
      this.h = db.c(this.b); 
    return this.h;
  }
  
  public String d() {
    if (TextUtils.isEmpty(this.i) && !TextUtils.isEmpty(this.d))
      this.i = db.c(this.d); 
    return this.i;
  }
  
  public String e() {
    if (TextUtils.isEmpty(this.k) && !TextUtils.isEmpty(this.f))
      this.k = db.c(this.f); 
    if (TextUtils.isEmpty(this.k))
      this.k = "standard"; 
    return this.k;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = false;
    if (paramObject == null)
      return false; 
    if (paramObject == this)
      return true; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    if (hashCode() == paramObject.hashCode())
      bool = true; 
    return bool;
  }
  
  public boolean f() {
    return (this.c == 1);
  }
  
  public String[] g() {
    String[] arrayOfString = this.l;
    if ((arrayOfString == null || arrayOfString.length == 0) && !TextUtils.isEmpty(this.e))
      this.l = b(db.c(this.e)); 
    return (String[])this.l.clone();
  }
  
  public int hashCode() {
    dk dk = new dk();
    dk.a(this.j).a(this.g).a(this.h).a((Object[])this.l);
    return dk.a();
  }
  
  public static class a {
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
    
    public a a(String param1String) {
      this.b = param1String;
      return this;
    }
    
    public a a(String[] param1ArrayOfString) {
      if (param1ArrayOfString != null)
        this.g = (String[])param1ArrayOfString.clone(); 
      return this;
    }
    
    public da a() throws cp {
      if (this.g != null)
        return new da(this); 
      throw new cp("sdk packages is null");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */