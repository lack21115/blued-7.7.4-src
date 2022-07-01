package com.huawei.hms.update.a;

import android.content.Context;
import android.content.SharedPreferences;

class a {
  private String a;
  
  private int b;
  
  private String c;
  
  private int d;
  
  private void b(Context paramContext, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("com.huawei.hms.update.DOWNLOAD_RECORD");
    stringBuilder.append(paramString);
    SharedPreferences.Editor editor = paramContext.getSharedPreferences(stringBuilder.toString(), 0).edit();
    editor.putString("mUri", this.a);
    editor.putInt("mSize", this.b);
    editor.putString("mHash", this.c);
    editor.putInt("mReceived", this.d);
    editor.commit();
  }
  
  public int a() {
    return this.b;
  }
  
  public void a(Context paramContext, int paramInt, String paramString) {
    this.d = paramInt;
    b(paramContext, paramString);
  }
  
  public void a(Context paramContext, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("com.huawei.hms.update.DOWNLOAD_RECORD");
    stringBuilder.append(paramString);
    SharedPreferences sharedPreferences = paramContext.getSharedPreferences(stringBuilder.toString(), 0);
    this.a = sharedPreferences.getString("mUri", "");
    this.b = sharedPreferences.getInt("mSize", 0);
    this.c = sharedPreferences.getString("mHash", "");
    this.d = sharedPreferences.getInt("mReceived", 0);
  }
  
  public void a(String paramString1, int paramInt, String paramString2) {
    this.a = paramString1;
    this.b = paramInt;
    this.c = paramString2;
    this.d = 0;
  }
  
  int b() {
    return this.d;
  }
  
  public boolean b(String paramString1, int paramInt, String paramString2) {
    if (paramString1 != null && paramString2 != null) {
      String str = this.a;
      if (str != null && str.equals(paramString1) && this.b == paramInt) {
        paramString1 = this.c;
        if (paramString1 != null && paramString1.equals(paramString2) && this.d <= this.b)
          return true; 
      } 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\update\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */