package com.amap.api.mapcore2d;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;

public class el {
  private String a;
  
  public el(String paramString) {
    String str = paramString;
    if (TextUtils.isDigitsOnly(paramString))
      str = "SPUtil"; 
    this.a = cx.b(str);
  }
  
  private void a(SharedPreferences.Editor paramEditor) {
    if (paramEditor == null)
      return; 
    if (Build.VERSION.SDK_INT >= 9) {
      paramEditor.apply();
      return;
    } 
    paramEditor.commit();
  }
  
  public void a(Context paramContext, String paramString, boolean paramBoolean) {
    try {
      SharedPreferences.Editor editor = paramContext.getSharedPreferences(this.a, 0).edit();
      editor.putBoolean(paramString, paramBoolean);
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  public boolean b(Context paramContext, String paramString, boolean paramBoolean) {
    if (paramContext == null)
      return paramBoolean; 
    try {
      return paramContext.getSharedPreferences(this.a, 0).getBoolean(paramString, paramBoolean);
    } finally {
      paramContext = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\el.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */