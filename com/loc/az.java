package com.loc;

import android.content.Context;

public final class az {
  private Context a;
  
  private t b;
  
  private String c;
  
  public az(Context paramContext, t paramt, String paramString) {
    this.a = paramContext.getApplicationContext();
    this.b = paramt;
    this.c = paramString;
  }
  
  private static String a(Context paramContext, t paramt, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      stringBuilder.append("\"sdkversion\":\"");
      stringBuilder.append(paramt.c());
      stringBuilder.append("\",\"product\":\"");
      stringBuilder.append(paramt.a());
      stringBuilder.append("\",\"nt\":\"");
      stringBuilder.append(n.d(paramContext));
      stringBuilder.append("\",\"details\":");
      stringBuilder.append(paramString);
    } finally {
      paramContext = null;
    } 
  }
  
  final byte[] a() {
    return u.a(a(this.a, this.b, this.c));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */