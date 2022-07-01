package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;

public final class t extends b<String, Integer> {
  private Context j;
  
  private String k;
  
  public t(Context paramContext, String paramString) {
    super(paramContext, paramString);
    this.j = paramContext;
    this.k = paramString;
  }
  
  protected final String a() {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("key=");
    stringBuffer.append(bi.f(this.j));
    stringBuffer.append("&userid=");
    stringBuffer.append(this.k);
    return stringBuffer.toString();
  }
  
  public final String g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(h.c());
    stringBuilder.append("/nearby/data/delete");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */