package com.bytedance.tea.crash.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.tea.crash.h;

public final class j {
  private SharedPreferences a;
  
  public j(Context paramContext) {
    this.a = paramContext.getSharedPreferences("npth", 0);
  }
  
  public String a() {
    String str = h.a().e();
    return (TextUtils.isEmpty(str) || "0".equals(str)) ? this.a.getString("device_id", "0") : str;
  }
  
  public void a(String paramString) {
    this.a.edit().putString("device_id", paramString).apply();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\e\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */