package com.amap.api.col.s;

import android.content.Context;

public final class dc {
  private Context a;
  
  private br b;
  
  private String c;
  
  private static String a(Context paramContext, br parambr, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      stringBuilder.append("\"sdkversion\":\"");
      stringBuilder.append(parambr.d());
      stringBuilder.append("\",\"product\":\"");
      stringBuilder.append(parambr.b());
      stringBuilder.append("\",\"nt\":\"");
      stringBuilder.append(bm.d(paramContext));
      stringBuilder.append("\",\"details\":");
      stringBuilder.append(paramString);
    } finally {
      paramContext = null;
    } 
  }
  
  final byte[] a() {
    return bs.a(a(this.a, this.b, this.c));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */