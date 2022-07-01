package com.amap.api.mapcore2d;

import android.content.Context;

public class fd {
  private Context a;
  
  private da b;
  
  private String c;
  
  public fd(Context paramContext, da paramda, String paramString) {
    this.a = paramContext.getApplicationContext();
    this.b = paramda;
    this.c = paramString;
  }
  
  private static String a(Context paramContext, da paramda, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      stringBuilder.append("\"sdkversion\":\"");
      stringBuilder.append(paramda.c());
      stringBuilder.append("\",\"product\":\"");
      stringBuilder.append(paramda.a());
      stringBuilder.append("\",\"nt\":\"");
      stringBuilder.append(cu.e(paramContext));
      stringBuilder.append("\",\"details\":");
      stringBuilder.append(paramString);
    } finally {
      paramContext = null;
    } 
  }
  
  byte[] a() {
    return db.a(a(this.a, this.b, this.c));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\fd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */