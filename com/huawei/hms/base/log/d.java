package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

public class d implements b {
  private b a;
  
  public void a(Context paramContext, String paramString) {
    b b1 = this.a;
    if (b1 != null)
      b1.a(paramContext, paramString); 
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("HMSSDK_");
    stringBuilder.append(paramString2);
    Log.println(paramInt, stringBuilder.toString(), paramString3);
    b b1 = this.a;
    if (b1 != null)
      b1.a(paramString1, paramInt, paramString2, paramString3); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\base\log\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */