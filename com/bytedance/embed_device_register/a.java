package com.bytedance.embed_device_register;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

final class a {
  private static final AtomicBoolean a = new AtomicBoolean(false);
  
  private static String b = "";
  
  static String a(SharedPreferences paramSharedPreferences) {
    if (a.compareAndSet(false, true)) {
      b = paramSharedPreferences.getString("cdid", "");
      if (TextUtils.isEmpty(b)) {
        b = UUID.randomUUID().toString();
        paramSharedPreferences.edit().putString("cdid", b).apply();
      } 
    } 
    return b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embed_device_register\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */